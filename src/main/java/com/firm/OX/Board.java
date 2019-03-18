package com.firm.OX;

public class Board {

    private Size size;
    private Field[][] board;

    public Board(Size size) {
        if (size.lowerThan(3)){
            throw new IllegalArgumentException();
        }
        this.size = size;
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
}
