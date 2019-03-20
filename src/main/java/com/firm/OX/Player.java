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

    public Player(String name, InputReader inputReader) {
        this.name = name;
        this.inputReader = inputReader;
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
}
