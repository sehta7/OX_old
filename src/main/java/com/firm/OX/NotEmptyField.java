package com.firm.OX;

/**
 * Contains position of one not empty field from board chosen by player
 *
 * @author Ola Podorska
 */
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
