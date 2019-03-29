package com.firm.OX;

import java.util.Map;

/**
 * Checks terms of winning
 *
 * @author Ola Podorska
 */
class Judge {

    private GameOptions gameOptions;

    public Judge(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    boolean isOtherPlayerField(Field field1, Field field2, Positions positions) {
        Map<Position, Player> playerMap = positions.findPlayerPositions();
        Player player1 = playerMap.get(field1.getPosition());
        Player player2 = playerMap.get(field2.getPosition());
        return !player1.equals(player2);
    }

    boolean isWinningSequence(Field field, Positions positions){
        Checker horizontallyChecker = new HorizontallyChecker(gameOptions);
        boolean horizontally = horizontallyChecker.checkSequence(field, positions);
        Checker verticallyChecker = new VerticallyChecker(gameOptions);
        boolean vertically = verticallyChecker.checkSequence(field, positions);
        Checker diagonalChecker = new DiagonalChecker(gameOptions);
        boolean diagonal = diagonalChecker.checkSequence(field, positions);
        Checker antiDiagonalChecker = new AntiDiagonalChecker(gameOptions);
        boolean antiDiagonal = antiDiagonalChecker.checkSequence(field, positions);

        return horizontally || vertically || diagonal || antiDiagonal;
    }

    Player checkWhoWinRound(Map<String, Player> players) {
        int naughtScores = players.get("O").checkPoints();
        int crossScores = players.get("X").checkPoints();
        if (naughtScores > crossScores) {
            return players.get("O");
        } else {
            return players.get("X");
        }
    }

    boolean checkDraw(Positions positions, GameOptions gameOptions) {
        return positions.howMuchChosenFields() == gameOptions.availableFields();
    }

    void isPositionGood(Position position, Positions positions) throws ChosenFieldException{
        if (position.getRow() > gameOptions.sizeOfBoard().getLength() || position.getColumn() > gameOptions.sizeOfBoard().getHeight() || positions.hasPosition(position)) {
            throw new ChosenFieldException("Chosen field must be free and in board");
        }
    }

    boolean checkIfEndOfRound(int counter) {
        return counter == 3;
    }
}
