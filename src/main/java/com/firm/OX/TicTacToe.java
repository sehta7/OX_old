package com.firm.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
public class TicTacToe implements GameAPI {

    private GameOptions gameOptions;
    private InputReader inputReader;


    /*
    Dependency injection vs Dependency inversion
     */

    public TicTacToe() {
        gameOptions = new GameOptions();
        inputReader = new InputReader(new Scanner(System.in));
    }

    public TicTacToe(InputReader inputReader) {
        this.inputReader = inputReader;
        this.gameOptions = new GameOptions();
    }

    @Override
    public void setGameOptions() {
        Player startingPlayer = inputReader.readPlayer();
        Player player = inputReader.readPlayer();
        Size size = inputReader.readSize();
        int numberOfCharacters = inputReader.readNumberOfCharacters();
        gameOptions.chosenSize(size);
        gameOptions.chosenCharacters(numberOfCharacters);
        gameOptions.start(startingPlayer);
        gameOptions.assignPlayers(startingPlayer, player);
    }

    @Override
    public void initializeBoard() {

    }

    @Override
    public void startGame() {

    }

    @Override
    public GameOptions gameOptions() {
        return gameOptions;
    }
}
