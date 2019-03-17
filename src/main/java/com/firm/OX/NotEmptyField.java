package com.firm.OX;

public class NotEmptyField implements Field {

    private Position position;

    public NotEmptyField(Position position) {
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
