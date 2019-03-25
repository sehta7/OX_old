package com.firm.OX;

import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.Scanner;

/**
 * Container on tic-tac-toe to play game in console,
 * available: setting options, start game
 *
 * @author Ola Podorska
 */
class Game implements GameAPI {

    private GameOptions gameOptions;
    private InputReader inputReader;
    private TicTacToe ticTacToe;
    private Displayer displayer;

    Game() {
        gameOptions = new GameOptions();
        inputReader = new InputReader(new Scanner(System.in));
    }

    Game(InputReader inputReader) {
        this.inputReader = inputReader;
        this.gameOptions = new GameOptions();
    }

    @Override
    public void setGameOptions() {
        System.out.println("Select language: en or pl");
        Language language = new Language(askAboutLanguage());
        language.loadLanguage();
        displayer = new Displayer(language);
        displayer.displayQuestionWhoStarts();
        Player startingPlayer = inputReader.readPlayer();
        displayer.displayQuestionAboutPlayer();
        Player player = inputReader.readPlayer();
        displayer.displayQuestionAboutBoardSize();
        Size size;
        size = getSizeWithException();
        displayer.displayQuestionAboutCharacter();
        int numberOfCharacters = inputReader.readNumberOfCharacters();
        gameOptions.chosenSize(size);
        gameOptions.chosenCharacters(numberOfCharacters);
        gameOptions.start(startingPlayer);
        gameOptions.assignPlayers(startingPlayer, player);
        gameOptions.assignLanguage(language);
    }

    private String askAboutLanguage() {
        while (true){
            try{
                return inputReader.readLanguage();
            } catch (LanguageException e){
                System.out.println("Choose only available language");
            }
        }
    }

    private Size getSizeWithException() {
        while (true) {
            try {
                return inputReader.readSize();
            } catch (BoardSizeException e) {
                displayer.displayBoardSizeError();
            }
            catch (NumberFormatException e){
                System.out.println("Number please..");
                displayer.displayChosenFieldError();
            }
        }
    }

    @Override
    public void startGame() {
        ticTacToe = new TicTacToe(gameOptions, new HashMap<>(), displayer);
        ticTacToe.startConsoleGame();
    }

    @Override
    public GameOptions gameOptions() {
        return gameOptions;
    }
}
