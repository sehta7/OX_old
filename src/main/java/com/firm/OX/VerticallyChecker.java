package com.firm.OX;

import java.util.Map;
import java.util.Queue;

/**
 * Looks for winning sequence in vertically direction
 *
 * @author Ola Podorska
 */
class VerticallyChecker implements Checker{

    private GameOptions gameOptions;

    VerticallyChecker(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    @Override
    public boolean checkSequence(Field field, Positions positions) {
        int column = field.getPosition().getColumn();
        boolean winningSequence = false;
        Map<Position, Player> playerMap = positions.findPlayerPositions();
        Player player = playerMap.get(field.getPosition());
        Queue<Position> fieldsInColumn = positions.findAllInLine(column, player);
        int numberOfFields = checkInLine(fieldsInColumn);
        if (numberOfFields == gameOptions.numberOfCharacters()) {
            winningSequence = true;
        }
        return winningSequence;
    }

    @Override
    public int checkInLine(Queue<Position> fields) {
        int inLine = 1;
        while (fields.size() > 1 && inLine < gameOptions.numberOfCharacters()) {
            Position position = fields.poll();
            if (position.hasNextInColumn(fields.element())) {
                inLine++;
            } else {
                inLine = 1;
            }
        }
        return inLine;
    }
}
