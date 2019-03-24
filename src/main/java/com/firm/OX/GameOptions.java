package com.firm.OX;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ola Podorska
 */
class GameOptions {

    private Map<String, Player> players;
    private Size boardSize;
    private int winningCharacters;
    private BoardDrawer boardDrawer;
    private Language language;
    private String pathToFile;

    GameOptions(){
        players = new HashMap<>();
        //TODO: czy metoda chosenSize potem wołana nie nadpisze tej opcji? albo czy gdzieś nie podziałam na tej opcji, ZANIM zawołam chosenSize?
        boardSize = new Size();
        pathToFile = "C:\\Users\\Olka\\Desktop\\";
    }

    void assignPlayers(Player playerOne, Player playerTwo) {
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

    boolean isPlayerO(Player player) {
        if (player.equals(players.get("O"))){
            return true;
        }
        return false;
    }

    boolean isPlayerX(Player player) {
        if (player.equals(players.get("X"))){
            return true;
        }
        return false;
    }

    void start(Player player) {
        //TODO: haczyk by zawsze było to O :D ;-)
        players.put("O", player);
    }

    void chosenPath(String path){
        this.pathToFile = path;
    }

    void chosenSize(Size size) {
        if (size.lowerThan(3)){
            throw new IllegalArgumentException("Too small size of board");
        }
        boardSize = size;
        boardDrawer = new BoardDrawer(boardSize);
    }

    Size sizeOfBoard() {
        return boardSize;
    }

    void chosenCharacters(int numberOfCharacters) {
        winningCharacters = numberOfCharacters;
    }

    int numberOfCharacters() {
        return winningCharacters;
    }

    Map<String, Player> players() {
        return players;
    }

    Player whoStarts() {
        return players.get("O");
    }

    void initializeBoard() {
        boardDrawer.drawGridWithCoordinates();
    }

    int availableFields() {
        return boardSize.getLength() * boardSize.getHeight();
    }

    void assignLanguage(Language language) {
        this.language = language;
    }

    String getPath() {
        return pathToFile;
    }
}
