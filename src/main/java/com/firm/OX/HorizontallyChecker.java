package com.firm.OX;

import java.util.Map;
import java.util.Queue;

/**
 * Looks for winning sequence in horizontally direction
 *
 * @author Ola Podorska
 */
class HorizontallyChecker implements Checker{

    private GameOptions gameOptions;

    HorizontallyChecker(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    @Override
    public boolean checkSequence(Field field, Positions positions) {
        int row = field.getPosition().getRow();
        boolean winningSequence = false;
        Map<Position, Player> playerMap = positions.findPlayerPositions();
        Player player = playerMap.get(field.getPosition());
        Queue<Position> fieldsInRow = positions.findAllInLine(row, player);
        int numberOfFields = checkInLine(fieldsInRow);
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
            if (position.hasNextInRow(fields.element())) {
                inLine++;
            } else {
                inLine = 1;
            }
        }
        return inLine;
    }
}
