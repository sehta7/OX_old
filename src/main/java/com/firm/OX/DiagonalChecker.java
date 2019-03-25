package com.firm.OX;

import java.util.Map;
import java.util.Queue;

/**
 * Looks for winning sequence in diagonal direction
 *
 * @author Ola Podorska
 */
class DiagonalChecker implements Checker {

    private GameOptions gameOptions;

    DiagonalChecker(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    @Override
    public boolean checkSequence(Field field, Positions positions) {
        int column = field.getPosition().getColumn();
        int row = field.getPosition().getRow();
        boolean winningSequence = false;
        Map<Position, Player> playerMap = positions.findPlayerPositions();
        Player player = playerMap.get(field.getPosition());
        Queue<Position> fieldsInDiagonal = positions.findAllInDiagonal(row, column, player, gameOptions.sizeOfBoard());
        int numberOfFields = checkInLine(fieldsInDiagonal);
        if (numberOfFields == gameOptions.numberOfCharacters()) {
            winningSequence = true;
        }
        return winningSequence;
    }

    @Override
    public int checkInLine(Queue<Position> fields) {
        int inLine = 1;
        while (fields.size() > 1 && inLine < gameOptions.numberOfCharacters()) {
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
}
