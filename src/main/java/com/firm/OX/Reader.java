package com.firm.OX;

/**
 * Provides methods to read data
 *
 * @author Ola Podorska
 */
public interface Reader {

    Size readSize();
    Player readPlayer();
    int readNumberOfCharacters();
    Position readPosition();
}
