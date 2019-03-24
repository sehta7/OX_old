package com.firm.OX;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Ola Podorska
 */
class TicTacToe implements GameAPI {

    private GameOptions gameOptions;
    private InputReader inputReader;
    private Game game;
    private Displayer displayer;

    TicTacToe() {
        gameOptions = new GameOptions();
        inputReader = new InputReader(new Scanner(System.in));
    }

    TicTacToe(InputReader inputReader) {
        this.inputReader = inputReader;
        this.gameOptions = new GameOptions();
    }

    @Override
    public void setGameOptions() {
        System.out.println("Select language: en or pl");
        Language language = new Language(inputReader.readLanguage());
        language.loadLanguage();
        displayer = new Displayer(language);
        displayer.displayQuestionWhoStarts();
        Player startingPlayer = inputReader.readPlayer();
        displayer.displayQuestionAboutPlayer();
        Player player = inputReader.readPlayer();
        displayer.displayQuestionAboutBoardSize();
        Size size = inputReader.readSize();
        displayer.displayQuestionAboutCharacter();
        int numberOfCharacters = inputReader.readNumberOfCharacters();
        gameOptions.chosenSize(size);
        gameOptions.chosenCharacters(numberOfCharacters);
        gameOptions.start(startingPlayer);
        gameOptions.assignPlayers(startingPlayer, player);
        gameOptions.assignLanguage(language);
    }

    @Override
    public void startGame() {
        game = new Game(gameOptions, new HashMap<>(), displayer);
        game.start();
    }

    @Override
    public GameOptions gameOptions() {
        return gameOptions;
    }
}
