package com.firm.OX;

/**
 * @author Ola Podorska
 */
public interface GameAPI {

    void setGameOptions();
    void initializePlayers();
    void initializeBoard();
    void startGame();

    GameOptions gameOptions();
}
