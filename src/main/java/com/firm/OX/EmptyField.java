package com.firm.OX;

public class EmptyField implements Field {

    private Position position;

    public EmptyField(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        if(position == null){
            throw new NullPointerException();
        }
        return position;
    }
}
