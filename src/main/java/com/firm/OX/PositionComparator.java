package com.firm.OX;

import java.util.Comparator;

/**
 * Compares two positions and changes if first value of row is smaller than second,
 * useful to searching winning sequence
 *
 * @author Ola Podorska
 */
class PositionComparator implements Comparator<Position> {
    @Override
    public int compare(Position p1, Position p2) {

        if (p1.getRow() != p2.getRow()){
            return p1.getRow() - p2.getRow();
        }
        return p1.getColumn() - p2.getColumn();
    }
}
