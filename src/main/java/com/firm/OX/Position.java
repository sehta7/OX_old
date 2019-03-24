package com.firm.OX;

import java.util.Objects;

class Position {

    private int row;
    private int column;
    private String end;

    Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    Position(String end) {
        this.end = end;
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
        if (end != null){
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
