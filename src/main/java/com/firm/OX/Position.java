package com.firm.OX;

import java.util.Objects;

public class Position {

    private int row;
    private int column;
    private String end;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Position(String end) {
        this.end = end;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
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

    public boolean hasNextInRow(Position element) {
        return ((this.column + 1) == element.getColumn());
    }

    public boolean hasNextInColumn(Position element) {
        return ((this.row + 1) == element.getRow());
    }

    public boolean hasNextInDiagonalRight(Position element) {
        return ((this.row - 1) == element.getRow() && ((this.column + 1) == element.getColumn()));
    }

    public boolean hasNextInDiagonalLeft(Position element) {
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
