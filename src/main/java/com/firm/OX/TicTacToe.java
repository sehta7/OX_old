package com.firm.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
public class TicTacToe implements GameAPI {

    private GameOptions gameOptions;
    private InputReader inputReader;
    private Game game;

    public TicTacToe() {
        gameOptions = new GameOptions();
        inputReader = new InputReader(new Scanner(System.in));
        game = new Game(gameOptions);
    }

    public TicTacToe(InputReader inputReader) {
        this.inputReader = inputReader;
        this.gameOptions = new GameOptions();
        game = new Game(gameOptions);
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
    public void startGame() {
        game.start();
    }

    @Override
    public GameOptions gameOptions() {
        return gameOptions;
    }
}
