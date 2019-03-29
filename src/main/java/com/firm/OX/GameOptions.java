package com.firm.OX;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains basic information about game:
 * players list, board size, number of winning characters, language
 *
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

    boolean isPlayerNaught(Player player) {
        return player.equals(players.get("O"));
    }

    boolean isPlayerCross(Player player) {
        return player.equals(players.get("X"));
    }

    void start(Player player) {
        //TODO: haczyk by zawsze było to O :D ;-)
        players.put("O", player);
    }

    void chosenPath(String path){
        this.pathToFile = path;
    }

    void chosenSize(Size size) throws BoardSizeException{
        if (size.lowerThan(3, 3)) {
            throw new BoardSizeException("Board must have size greater than 3x3");
        }
        boardSize = size;
        boardDrawer = new BoardDrawer(boardSize);
    }

    Size sizeOfBoard() {
        return boardSize;
    }

    void chosenCharacters(int numberOfCharacters) {
        this.winningCharacters = numberOfCharacters;
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
