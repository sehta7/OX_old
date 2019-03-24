package com.firm.OX;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Contains information about board
 *
 * @author Ola Podorska
 */
class Board {

    private Size size;
    private Field[][] board;
    private Queue<Position> positions;

    Board(Size size) {
        this.size = size;
        this.positions = new PriorityQueue<>(10, new PositionComparator());
    }

    Size getSize() {
        return size;
    }

    void initialize() {
        board = new Field[size.getLength()][size.getHeight()];
        for (int x = 0; x < size.getLength(); x++) {
            for (int y = 0; y < size.getHeight(); y++) {
                board[x][y] = new EmptyField(new Position(x, y));
            }
        }
    }

    boolean isInitialized() {
        boolean initialized = false;
        for (Field[] fieldsRow : board
        ) {
            for (Field field : fieldsRow
            ) {
                if (field instanceof EmptyField) {
                    initialized = true;
                }
            }

        }
        return initialized;
    }

    void change(Field field) {
        Position position = field.getPosition();
        board[position.getRow()][position.getColumn()] = new NotEmptyField(new Position(position.getRow(), position.getColumn()));
    }

    Field findField(Field field) {
        Position position = field.getPosition();
        return board[position.getRow()][position.getColumn()];
    }

    void save(Field field) {
        positions.add(field.getPosition());
    }

    int numberOfFields() {
        return positions.size();
    }
}
