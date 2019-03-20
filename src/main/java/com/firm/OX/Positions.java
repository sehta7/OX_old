package com.firm.OX;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Sorts positions by field coordinates - helpful when printing.
 *
 * @author Ola Podorska
 */
class Positions {
    Queue<Position> q;

    Positions(int size, PositionComparator positionComparator) {
        q = new PriorityQueue<> (size, positionComparator);
    }

    void add(Position position) {
        q.add(position);
    }

    Position remove() {
        return q.remove();
    }

    boolean isEmpty() {
        return q.isEmpty();
    }
}
