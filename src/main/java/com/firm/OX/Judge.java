package com.firm.OX;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Ola Podorska
 */
class Judge {

    Size size;
    int neighbours;
    Direction direction;
    int numberOfCharacters;
    boolean checkOnce;

    public Judge(Size size, int numberOfCharacters) {
        this.size = size;
        neighbours = 0;
        direction = Direction.ALL;
        this.numberOfCharacters = numberOfCharacters;
        checkOnce = false;
    }


    public boolean isOtherPlayerField(Field field1, Field field2, Positions positions) {
        Map<Position, Player> playerMap = positions.findPlayerPositions();
        Player player1 = playerMap.get(field1.getPosition());
        Player player2 = playerMap.get(field2.getPosition());
        if (player1.equals(player2)) {
            return false;
        }
        return true;
    }

    public boolean foundSequence(Field field, Positions positions) {
        boolean horizontally = checkHorizontally(field, positions);
        boolean vertically = checkVertically(field, positions);
        boolean diagonalDownToRight = checkDiagonalDownToRight(field, positions);
        boolean diagonalUpToRight = checkDiagonalUpToRight(field, positions);

        if (horizontally || vertically || diagonalDownToRight || diagonalUpToRight){
            return true;
        }
        return false;
    }

    boolean checkHorizontally(Field field, Positions positions) {
        int row = field.getPosition().getRow();
        boolean winningSequence = false;
        Map<Position, Player> playerMap = positions.findPlayerPositions();
        Player player = playerMap.get(field.getPosition());
        Queue<Position> fieldsInRow = positions.findAllInRow(row, player);
        int numberOfFields = checkInRowLine(fieldsInRow);
        if (numberOfFields == numberOfCharacters) {
            winningSequence = true;
        }
        return winningSequence;
    }

    private int checkInRowLine(Queue<Position> fields) {
        int inLine = 1;
        while (fields.size() > 1 && inLine < numberOfCharacters) {
            Position position = fields.poll();
            if (position.hasNextInRow(fields.element())) {
                inLine++;
            } else {
                inLine = 1;
            }
        }
        return inLine;
    }

    boolean checkVertically(Field field, Positions positions) {
        int column = field.getPosition().getColumn();
        boolean winningSequence = false;
        Map<Position, Player> playerMap = positions.findPlayerPositions();
        Player player = playerMap.get(field.getPosition());
        Queue<Position> fieldsInColumn = positions.findAllInColumn(column, player);
        int numberOfFields = checkInColumnLine(fieldsInColumn);
        if (numberOfFields == numberOfCharacters) {
            winningSequence = true;
        }
        return winningSequence;
    }

    boolean checkDiagonalUpToRight(Field field, Positions positions) {
        int column = field.getPosition().getColumn();
        int row = field.getPosition().getRow();
        boolean winningSequence = false;
        Map<Position, Player> playerMap = positions.findPlayerPositions();
        Player player = playerMap.get(field.getPosition());
        Set<Position> fieldsInDiagonal = positions.findAllInDiagonal(row, column, player, size);
        int numberOfFields = checkInDiagonalLineUp(fieldsInDiagonal);
        if (numberOfFields == numberOfCharacters) {
            winningSequence = true;
        }
        return winningSequence;
    }

    boolean checkDiagonalDownToRight(Field field, Positions positions) {
        int column = field.getPosition().getColumn();
        int row = field.getPosition().getRow();
        boolean winningSequence = false;
        Map<Position, Player> playerMap = positions.findPlayerPositions();
        Player player = playerMap.get(field.getPosition());
        Set<Position> fieldsInDiagonal = positions.findAllInDiagonal(row, column, player, size);
        int numberOfFields = checkInDiagonalLineDown(fieldsInDiagonal);
        if (numberOfFields == numberOfCharacters) {
            winningSequence = true;
        }
        return winningSequence;
    }

    private int checkInDiagonalLineDown(Set<Position> fields) {
        int inLine = 1;
        while (fields.size() > 1 && inLine < numberOfCharacters) {
            Position position = fields.iterator().next();
            fields.remove(position);
            if (position.hasNextInDiagonalLeft(fields.iterator().next())) {
                inLine++;
            } else {
                inLine = 1;
            }
        }
        return inLine;
    }

    private int checkInDiagonalLineUp(Set<Position> fields) {
        int inLine = 1;
        while (fields.size() > 1 && inLine < numberOfCharacters) {
            Position position = fields.iterator().next();
            fields.remove(position);
            if (position.hasNextInDiagonalRight(fields.iterator().next())) {
                inLine++;
            } else {
                inLine = 1;
            }
        }
        return inLine;
    }

    private int checkInColumnLine(Queue<Position> fields) {
        int inLine = 1;
        while (fields.size() > 1 && inLine < numberOfCharacters) {
            Position position = fields.poll();
            if (position.hasNextInColumn(fields.element())) {
                inLine++;
            } else {
                inLine = 1;
            }
        }
        return inLine;
    }

    public boolean checkIfWinRound(Player winner) {
        if (winner.checkPoints() == 3) {
            return true;
        }
        return false;
    }

    public boolean checkDraw(Positions positions, GameOptions gameOptions) {
        if (positions.howMuchChosenFields() == gameOptions.availableFields()) {
            return true;
        }
        return false;
    }

    public boolean isPositionGood(Position position, Positions positions) {
        if (position.getRow() > size.getLength() || position.getColumn() > size.getHeight() || positions.hasPosition(position)) {
            return false;
        }
        return true;
    }
}
