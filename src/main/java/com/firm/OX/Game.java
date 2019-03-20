package com.firm.OX;

/**
 * @author Ola Podorska
 */
public class Game {

    private Round round;
    private GameOptions gameOptions;

    public Game(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
        round = new Round(new BoardDrawer(gameOptions.sizeOfBoard()));
    }

    public void start() {
        gameOptions.initializeBoard();
        for (int i = 0; i < 3; i++){
            round.start(gameOptions.players());
        }
    }
}
