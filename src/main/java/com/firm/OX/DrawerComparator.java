package com.firm.OX;

import java.util.Comparator;

/**
 * @author Ola Podorska
 */
class DrawerComparator implements Comparator<Position> {

    @Override
    public int compare(Position p1, Position p2) {

        if (p1.getColumn() != p2.getColumn()){
            return p1.getColumn() - p2.getColumn();
        }
        return p1.getRow() - p2.getRow();
    }
}
