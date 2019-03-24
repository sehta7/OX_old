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
        if (player1.equals(player2)) {
            return false;
        }
        return true;
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

        if (horizontally || vertically || diagonal || antiDiagonal){
            return true;
        }
        return false;
    }

    boolean checkIfWinRound(Player winner) {
        if (winner.checkPoints() == 3) {
            return true;
        }
        return false;
    }

    boolean checkDraw(Positions positions, GameOptions gameOptions) {
        if (positions.howMuchChosenFields() == gameOptions.availableFields()) {
            return true;
        }
        return false;
    }

    void isPositionGood(Position position, Positions positions) throws ChosenFieldException{
        if (position.getRow() > gameOptions.sizeOfBoard().getLength() || position.getColumn() > gameOptions.sizeOfBoard().getHeight() || positions.hasPosition(position)) {
            throw new ChosenFieldException("Chosen field must be free and in board");
        }
    }
}
