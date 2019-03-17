package com.firm.OX;

public class EmptyField implements Field {
    public EmptyField(Position position) {

    }

    @Override
    public Position getPosition() {
        return null;
    }
}
