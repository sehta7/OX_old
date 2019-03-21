package com.firm.OX;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author Ola Podorska
 */
public class Player {

    private String name;
    private Characters character;
    private int points;
    private InputReader inputReader;

    public Player() {
    }

    public Player(String name, Characters character) {
        this.name = name;
        this.character = character;
    }

    public Player(String name, InputReader inputReader) {
        this.name = name;
        this.inputReader = inputReader;
        this.points = 0;
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

    public Position chooseField() {
        return inputReader.readPosition();
    }

    public boolean isO() {
        boolean firtst = (this.character == Characters.NAUGHT);
        boolean second = (this.character.equals("O"));
        boolean thirf = (this.character.equals(Characters.NAUGHT));
        boolean fourth = (character.equals(Characters.NAUGHT));
        return character.equals(Characters.NAUGHT);
    }

    void chooseCharacter(Characters character){
        this.character = character;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", character=" + character +
                ", points=" + points +
                '}';
    }
}
