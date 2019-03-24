package com.firm.OX;

public interface Reader {

    Size readSize();
    Player readPlayer();
    int readNumberOfCharacters();
    Position readPosition();
}
