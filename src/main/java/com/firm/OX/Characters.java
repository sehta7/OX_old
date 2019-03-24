package com.firm.OX;

/**
 * Available characters to play
 *
 * @author Ola Podorska
 */
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
