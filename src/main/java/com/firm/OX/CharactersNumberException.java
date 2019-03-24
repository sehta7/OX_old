package com.firm.OX;

/**
 * Exception if winning characters are lower than 3
 *
 * @author Ola Podorska
 */
public class CharactersNumberException extends IllegalArgumentException {

    public CharactersNumberException(String message) {
        super(message);
    }
}
