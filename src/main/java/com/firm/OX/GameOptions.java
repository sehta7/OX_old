package com.firm.OX;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ola Podorska
 */
public class GameOptions {

    private Map<String, Player> players;
    private Size boardSize;

    public GameOptions(){
        players = new HashMap<>();
    }

    public void assignPlayers(Player playerOne, String character) {
        players.put(character, playerOne);
    }

    public boolean isPlayerO(Player player) {
        if (player.equals(players.get("O"))){
            return true;
        }
        return false;
    }

    public boolean isPlayerX(Player player) {
        if (player.equals(players.get("X"))){
            return true;
        }
        return false;
    }

    public void start(Player player) {
        assignPlayers(player, "O");
    }

    public void chosenSize(Size size) {
        boardSize = size;
    }

    public Size sizeOfBoard() {
        return boardSize;
    }
}
