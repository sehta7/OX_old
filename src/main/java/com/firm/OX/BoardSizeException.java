package com.firm.OX;

/**
 * Exception if board size is lower than 3x3
 *
 * @author Ola Podorska
 */
class BoardSizeException extends IllegalArgumentException {

    BoardSizeException(String message) {
        super(message);
    }
}
