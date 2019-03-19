package com.firm.OX;

import java.util.Objects;

/**
 * @author Ola Podorska
 */
public class Player {

    private String name;
    private Characters character;
    private int points;

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
}
