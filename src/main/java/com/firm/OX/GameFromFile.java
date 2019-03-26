package com.firm.OX;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Container on tic-tac-toe to play auto game from file,
 * available: setting options, start game
 *
 * @author Ola Podorska
 */
class GameFromFile implements GameAPI {

    private GameOptions gameOptions;
    private FromFileReader fileReader;
    private TicTacToe ticTacToe;

    GameFromFile(File file) throws FileNotFoundException {
        this.gameOptions = new GameOptions();
        this.fileReader = new FromFileReader(gameOptions, file, new Displayer(new Language("en")));
    }

    @Override
    public void setGameOptions() {
        fileReader.readOptions();
    }

    @Override
    public void startGame() {
        Round round = new Round(gameOptions, new Displayer(new Language("en")), new Registrar(gameOptions));
        round.startFromFile(gameOptions.players(), fileReader.readMoves());
    }

    @Override
    public GameOptions gameOptions() {
        return gameOptions;
    }
}
