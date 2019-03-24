package com.firm.OX;

class NotEmptyField implements Field {

    private Position position;

    NotEmptyField(Position position) {
        this.position = position;
    }

    NotEmptyField() {
        position = new Position(0,0);
    }

    @Override
    public Position getPosition() {
        if(position == null){
            throw new NullPointerException();
        }
        return position;
    }
}
