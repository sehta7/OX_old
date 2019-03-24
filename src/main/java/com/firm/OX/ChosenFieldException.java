package com.firm.OX;

/**
 * Exception if player choose is taken or off the board
 *
 * @author Ola Podorska
 */
public class ChosenFieldException extends IllegalArgumentException {

    public ChosenFieldException(String message) {
        super(message);
    }
}
