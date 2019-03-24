package com.firm.OX;

enum Characters {

    NAUGHT ("O"), CROSS("X");

    private String character;

    Characters(String character) {
        this.character = character;
    }

    String getCharacter(){
        return character;
    }


}
