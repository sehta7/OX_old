package com.firm.OX;

/**
 * @author Ola Podorska
 */
public class Game {

    private Round round;
    private GameOptions gameOptions;

    public Game(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    public void start() {
        round = new Round(new BoardDrawer(gameOptions.sizeOfBoard()), new Judge(gameOptions.sizeOfBoard(), gameOptions.numberOfCharacters()));
        for (int i = 0; i < 3; i++){
            gameOptions.initializeBoard();
            round.start(gameOptions.players());
        }
    }
}
