package com.firm.OX;

public class Board {

    private Size size;

    public Board(Size size) {
        if (size.equals(new Size(0, 0))){
            throw new IllegalArgumentException();
        }
        this.size = size;
    }

    public Size getSize() {
        return size;
    }
}
