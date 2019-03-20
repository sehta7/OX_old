package com.firm.OX;

public enum Characters {

    NAUGHT ("O"), CROSS("X");

    private String character;

    Characters(String character) {
        this.character = character;
    }

    public String getCharacter(){
        return character;
    }


}
