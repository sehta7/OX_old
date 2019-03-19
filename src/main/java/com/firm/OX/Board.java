package com.firm.OX;

import java.util.PriorityQueue;
import java.util.Queue;

public class Board {

    private Size size;
    private Field[][] board;
    private Queue<Position> positions;

    public Board(Size size) {
        if (size.lowerThan(3)){
            throw new IllegalArgumentException();
        }
        this.size = size;
        this.positions = new PriorityQueue<>(10, new PositionComparator());
    }

    public Size getSize() {
        return size;
    }

    public void initialize() {
        board = new Field[size.getLength()][size.getHeight()];
        for (int x = 0; x < size.getLength(); x++){
            for (int y = 0; y < size.getHeight(); y++){
                board[x][y] = new EmptyField(new Position(x, y));
            }
        }
    }

    public boolean isInitialized() {
        boolean initialized = false;
        for (Field[] fieldsRow: board
             ) {
            for (Field field: fieldsRow
                 ) {
                if (field instanceof EmptyField){
                    initialized = true;
                }
            }

        }
        return initialized;
    }

    public void change(Field field) {
        Position position = field.getPosition();
        board[position.getRow()][position.getColumn()] = new NotEmptyField(new Position(position.getRow(), position.getColumn()));
    }

    public Field findField(Field field) {
        Position position = field.getPosition();
        return board[position.getRow()][position.getColumn()];
    }

    public void save(Field field) {
        positions.add(field.getPosition());
    }

    public int numberOfFields() {
        return positions.size();
    }
}
