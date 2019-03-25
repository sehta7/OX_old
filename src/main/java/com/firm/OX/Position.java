package com.firm.OX;

import java.util.Objects;

/**
 * Contains position of field in board
 *
 * @author Ola Podorska
 */
class Position {

    private int row;
    private int column;

    /**
     * The {@link String} useful only in special case - condition for ending program
     */
    private String special;

    Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    Position(String special) {
        this.special = special;
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row &&
                column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    public boolean hasEnd() {
        if (special != null){
            return true;
        }
        return false;
    }

    boolean hasNextInRow(Position element) {
        return ((this.column + 1) == element.getColumn());
    }

    boolean hasNextInColumn(Position element) {
        return ((this.row + 1) == element.getRow());
    }

    boolean hasNextInDiagonalRight(Position element) {
        return ((this.row - 1) == element.getRow() && ((this.column + 1) == element.getColumn()));
    }

    boolean hasNextInDiagonalLeft(Position element) {
        return ((this.row + 1) == element.getRow() && ((this.column + 1) == element.getColumn()));
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
