package com.firm.OX;

import java.util.*;

/**
 * Sorts positions by field coordinates - helpful when printing.
 *
 * @author Ola Podorska
 */
class Positions {
    Queue<Position> positions;
    Map<Position, Player> playersPositions;

    Positions(int size, PositionComparator positionComparator) {
        positions = new PriorityQueue<> (size, positionComparator);
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

    Positions copy() {
        Positions copiedPositions = new Positions(10, new PositionComparator());
        for (Position position: this.positions
             ) {
            copiedPositions.add(position);
        }
        return copiedPositions;
    }

    void linkPlayerWithPositions(Player player, Position position){
        playersPositions.put(position, player);
    }

    Map<Position, Player> findplayerPositions(){
        return playersPositions;
    }

    public boolean enoughToCheck() {
        int size = positions.size();
        if (positions.size() > 4){
            return true;
        }
        return false;
    }

    public Player findPlayer(Field field) {
        return playersPositions.get(field.getPosition());
    }

    public int howMuchChosenFields() {
        return positions.size();
    }

    public boolean hasPosition(Position position) {
        if (positions.contains(position)){
            return true;
        }
        return false;
    }

    public Queue<Position> findAllInRow(int row, Player player) {
        Queue<Position> fields = new PriorityQueue<>(10, new PositionComparator());
        for (Position position: positions
             ) {
            if (position.getRow() == row && playersPositions.get(position).equals(player)){
                fields.add(position);
            }
        }
        return fields;
    }

    public Queue<Position> findAllInColumn(int column, Player player) {
        Queue<Position> fields = new PriorityQueue<>(10, new PositionComparator());
        for (Position position: positions
        ) {
            if (position.getColumn() == column && playersPositions.get(position).equals(player)){
                fields.add(position);
            }
        }
        return fields;
    }
}
