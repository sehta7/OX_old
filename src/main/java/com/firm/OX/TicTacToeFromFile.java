package com.firm.OX;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * @author Ola Podorska
 */
class TicTacToeFromFile implements GameAPI {

    private GameOptions gameOptions;
    private FromFileReader fileReader;
    private Game game;

    TicTacToeFromFile(File file) throws FileNotFoundException {
        this.gameOptions = new GameOptions();
        this.fileReader = new FromFileReader(gameOptions, file);
    }

    @Override
    public void setGameOptions() {
        fileReader.readOptions();
    }

    @Override
    public void startGame() {
        game = new Game(gameOptions, new HashMap<>());
        game.autoGame(fileReader.readMove());
    }

    @Override
    public GameOptions gameOptions() {
        return gameOptions;
    }
}
