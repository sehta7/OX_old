package com.firm.OX;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ola Podorska
 */
public class GameOptions {

    private Map<String, Player> players;
    private Size boardSize;
    private int winningCharacters;

    public GameOptions(){
        players = new HashMap<>();
    }

    public void assignPlayers(Player playerOne, Player playerTwo) {
        Player player = players.get("O");
        if (player.equals(playerOne)){
            players.put("X", playerTwo);
        } else{
            players.put("X", playerOne);
        }
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
        players.put("O", player);
    }

    public void chosenSize(Size size) {
        if (size.lowerThan(3)){
            throw new IllegalArgumentException("Too small size of board");
        }
        boardSize = size;
    }

    public Size sizeOfBoard() {
        return boardSize;
    }

    public void chosenCharacters(int numberOfCharacters) {
        winningCharacters = numberOfCharacters;
    }

    public int numberOfCharacters() {
        return winningCharacters;
    }

    public Map<String, Player> players() {
        return players;
    }

    public Player whoStarts() {
        return players.get("O");
    }
}
