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
}
