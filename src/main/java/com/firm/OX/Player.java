package com.firm.OX;

import java.util.Objects;

/**
 * Container for information about player
 *
 * @author Ola Podorska
 */
class Player {

    private String name;
    private Characters character;
    private int points;
    private InputReader inputReader;

    Player() {
        this.name = "player";
        this.points = 0;
    }

    Player(String name, Characters character) {
        this.name = name;
        this.character = character;
    }

    Player(String name, InputReader inputReader) {
        this.name = name;
        this.inputReader = inputReader;
        this.points = 0;
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return points == player.points &&
                Objects.equals(name, player.name) &&
                character == player.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, character, points);
    }

    Position chooseField() {
        return inputReader.readPosition();
    }

    boolean isNaught() {
        return character.equals(Characters.NAUGHT);
    }

    void chooseCharacter(Characters character){
        this.character = character;
    }

    @Override
    public String toString() {
        return name + " (" + character.getCharacter() + ")";
    }

    void addPoint() {
        points++;
    }

    int checkPoints() {
        return points;
    }

    void resetPoints() {
        points = 0;
    }
}
