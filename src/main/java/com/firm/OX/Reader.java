package com.firm.OX;

import java.io.IOException;

/**
 * Provides methods to read data
 *
 * @author Ola Podorska
 */
interface Reader {

    Size readSize() throws IOException;
    Player readPlayer();
    int readNumberOfCharacters();
    Position readPosition();
}
