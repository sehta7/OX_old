package com.firm.OX;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Sorts positions by field coordinates - helpful when printing.
 *
 * @author Ola Podorska
 */
class Positions {
    Queue<Position> positions;

    Positions(int size, PositionComparator positionComparator) {
        positions = new PriorityQueue<> (size, positionComparator);
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
}
