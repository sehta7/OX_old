package com.firm.OX;

import java.util.Queue;

/**
 * Looks for winning sequence
 *
 * @author Ola Podorska
 */
public interface Checker {

    boolean checkSequence(Field field, Positions positions);
    int checkInLine(Queue<Position> fields);
}
