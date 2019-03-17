package com.firm.OX;

public class Board {

    private Size size;
    private Field[][] board;

    public Board(Size size) {
        if (size.equals(new Size(0, 0))){
            throw new IllegalArgumentException();
        }
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void initialize() {
        board = new EmptyField[size.getLength()][size.getHeight()];
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
}
