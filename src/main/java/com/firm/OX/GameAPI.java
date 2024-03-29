package com.firm.OX;

/**
 *API for game,
 *available: setting game options and starting the game
 *
 * @author Ola Podorska
 */
public interface GameAPI {

    void setGameOptions();
    void startGame();

    GameOptions gameOptions();
}
