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
    private BoardDrawer boardDrawer;

    public GameOptions(){
        players = new HashMap<>();
        //TODO: czy metoda chosenSize potem wołana nie nadpisze tej opcji? albo czy gdzieś nie podziałam na tej opcji, ZANIM zawołam chosenSize?
        boardSize = new Size();
    }

    public void assignPlayers(Player playerOne, Player playerTwo) {
        Player player = players.get("O");
        if (player.equals(playerOne)){
            players.put("X", playerTwo);
            playerOne.chooseCharacter(Characters.NAUGHT);
            playerTwo.chooseCharacter(Characters.CROSS);
        } else{
            players.put("X", playerOne);
            playerOne.chooseCharacter(Characters.CROSS);
            playerTwo.chooseCharacter(Characters.NAUGHT);
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
        //TODO: haczyk by zawsze było to O :D ;-)
        players.put("O", player);
    }

    public void chosenSize(Size size) {
        if (size.lowerThan(3)){
            throw new IllegalArgumentException("Too small size of board");
        }
        boardSize = size;
        boardDrawer = new BoardDrawer(boardSize);
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

    public void initializeBoard() {
        boardDrawer.drawGridWithCoordinates();
    }
}
