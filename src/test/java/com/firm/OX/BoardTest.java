package com.firm.OX;

import org.testng.annotations.Test;

/**
 *
 * @author Ola Podorska
 *
 */

@Test
public class BoardTest {

    @Test
    public void testIfBoardCanBeCreated() {
        Board board = new Board();
    }

    @Test(dataProviderClass = BoardDP.class, dataProvider = "sizes")
    public void testIfBoardHasSizeGivenByUser(Size size) {
        Board board = new Board(size);
        assert (board.getSize().equals(size)) : "Size of board aren't set properly";
    }
}
