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
        this.fileReader = new FromFileReader(gameOptions, file);
    }

    @Override
    public void setGameOptions() {
        fileReader.readOptions();
    }

    @Override
    public void startGame() {
        ticTacToe = new TicTacToe(gameOptions, new HashMap<>());
        ticTacToe.startAutoGame(fileReader.readMoves());
    }

    @Override
    public GameOptions gameOptions() {
        return gameOptions;
    }
}
