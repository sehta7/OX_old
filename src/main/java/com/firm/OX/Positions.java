package com.firm.OX;

import java.util.*;

/**
 * Store players moves history
 *
 * @author Ola Podorska
 */
class Positions {
    Queue<Position> positions;
    Map<Position, Player> playersPositions;

    Positions(int size, PositionComparator positionComparator) {
        positions = new PriorityQueue<>(size, positionComparator);
        playersPositions = new HashMap<>();
    }

    Positions(int size, DrawerComparator drawerComparator) {
        positions = new PriorityQueue<>(size, drawerComparator);
        playersPositions = new HashMap<>();
    }

    void add(Position position) {
        positions.add(position);
    }

    Position remove() {
        return positions.remove();
    }

    boolean isEmpty() {
        return positions.isEmpty();
    }

    Positions copyPositions() {
        Positions copiedPositions = new Positions(10, new PositionComparator());
        for (Position position : this.positions
        ) {
            copiedPositions.add(position);
        }
        return copiedPositions;
    }

    void linkPlayerWithPositions(Player player, Position position) {
        playersPositions.put(position, player);
    }

    Map<Position, Player> findPlayerPositions() {
        return playersPositions;
    }

    boolean enoughToCheck() {
        if (positions.size() > 4) {
            return true;
        }
        return false;
    }

    Player findPlayer(Field field) {
        return playersPositions.get(field.getPosition());
    }

    int howMuchChosenFields() {
        return positions.size();
    }

    boolean hasPosition(Position position) {
        if (positions.contains(position)) {
            return true;
        }
        return false;
    }

    Queue<Position> findAllInRow(int placeNumber, Player player) {
        Queue<Position> fields = new PriorityQueue<>(10, new PositionComparator());
        for (Position position : positions
        ) {
            if (position.getRow() == placeNumber && playersPositions.get(position).equals(player)) {
                fields.add(position);
            }
        }
        return fields;
    }

    Queue<Position> findAllInColumn(int placeNumber, Player player) {
        Queue<Position> fields = new PriorityQueue<>(10, new PositionComparator());
        for (Position position : positions
        ) {
            if (position.getColumn() == placeNumber && playersPositions.get(position).equals(player)) {
                fields.add(position);
            }
        }
        return fields;
    }

    Queue<Position> findAllInDiagonal(int row, int column, Player player, Size size) {
        Queue<Position> fields = new PriorityQueue<>(10, new PositionComparator());
        int max = 0;
        if (size.getHeight() > size.getLength()) {
            max = size.getLength();
        } else {
            max = size.getHeight();
        }
        for (Position position : positions
        ) {
            for (int x = 0; x < max; x++) {
                if (position.getRow() == row + x && position.getColumn() == column - x ||
                        position.getRow() == row - x && position.getColumn() == column + x ||
                        position.getRow() == row + x && position.getColumn() == column + x ||
                        position.getRow() == row - x && position.getColumn() == column - x ||
                        position.getRow() == column - x && position.getColumn() == row + x ||
                        position.getRow() == column - x && position.getColumn() == row - x ||
                        position.getRow() == column + x && position.getColumn() == row + x ||
                        position.getRow() == column + x && position.getColumn() == row - x) {
                    if (playersPositions.get(position).equals(player)) {
                        fields.add(position);
                    }
                }
            }
        }
        return fields;
    }

    Queue<Position> positions() {
        return positions;
    }

    void copyTo(Positions destination) {
        for (Position position : positions
        ) {
            destination.add(position);
        }
        for (Map.Entry<Position, Player> entry : playersPositions.entrySet()
        ) {
            destination.playersPositions.put(entry.getKey(), entry.getValue());
        }
    }
}
