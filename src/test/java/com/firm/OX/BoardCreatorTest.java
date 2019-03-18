package com.firm.OX;

import org.testng.annotations.Test;

@Test
public class BoardCreatorTest {

    @Test
    public void testIfBoardCreatorCanDrawEmptyGrid() {
        BoardCreator boardCreator = new BoardCreator();
        assert (boardCreator.drawEmptyGrid()) : "Board creator didn't draw grid";
    }

    @Test
    public void testIfBoardCreatorCanDrawGridWithCoordinates() {
        BoardCreator boardCreator = new BoardCreator();
        assert (boardCreator.drawGridWithCoordinates()) : "Board creator didn't draw grid with coordinates";
    }
}
