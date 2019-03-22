package com.firm.OX;

import java.util.Comparator;

/**
 * @author Ola Podorska
 */
public class PositionComparator implements Comparator<Position> {
    @Override
    public int compare(Position p1, Position p2) {

        if (p1.getRow() != p2.getRow()){
            return p1.getRow() - p2.getRow();
        }
        return p1.getColumn() - p2.getColumn();
    }
}
