package com.firm.OX;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author Ola Podorska
 *
 */

@Test
public class BoardTest {

    @Test
    public void testIfBoardCanBeCreated() {
        Board board = new Board(new Size(1,1));
    }

    @Test(dataProviderClass = BoardDP.class, dataProvider = "sizes")
    public void testIfBoardHasSizeGivenByUser(Size size) {
        Board board = new Board(size);
        assert (board.getSize().equals(size)) : "Size of board aren't set properly";
    }

    @Test(dataProviderClass = BoardDP.class, dataProvider = "sizes")
    public void testIfBoardIsInitializedByEmptyFields(Size size) {
        Board board = new Board(size);
        board.initialize();
        assert (board.isInitialized()) : "Board doesn't have empty fields";
    }

    @Test(invocationCount = 5)
    public void testIfBoardCanChangeField() {
        Random random = new Random();
        int length = random.nextInt(4850);
        int height = random.nextInt(4850);
        Board board = new Board(new Size(length, height));
        board.initialize();
        Field field = new EmptyField(new Position(random.nextInt(length), random.nextInt(height)));
        board.change(field);
        assert (board.findField(field) instanceof NotEmptyField) : "Board can't change empty field";
    }

    @Test(dataProviderClass = BoardDP.class, dataProvider = "illegalSizes", expectedExceptions = IllegalArgumentException.class)
    public void testIfBoardSizeIsGreaterThanThree(Size size) {
        Board board = new Board(size);
    }

    @Test(dataProviderClass = BoardDP.class, dataProvider = "sort")
    public void testIfBoardSortCharactersRelativeToPositions(Position p1, Position p2, int result) {
        Board board = new Board(new Size(10, 10));
        Queue<Position> positions = new LinkedList<>(Arrays.asList(p1, p2));
        board.sort(positions);
        assert (p1.lowerThan(p2) == result) : "Board doesn't sort positions";
    }
}
