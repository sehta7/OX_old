package com.firm.OX;

import org.testng.annotations.Test;

@Test
public class BoardDrawerTest {

    @Test
    public void testIfBoardCreatorCanDrawGridWithCoordinates() {
        BoardDrawer boardDrawer = new BoardDrawer(new Size(10, 10));
        assert (boardDrawer.drawGridWithCoordinates()) : "Board creator didn't draw grid with coordinates";
    }

   /* @Test(dataProviderClass = BoardDrawerDP.class, dataProvider = "positionOnBoard")
    public void testIfBoardCreatorCanDrawGridWithGivenPosition(Position position) {
        BoardDrawer boardDrawer = new BoardDrawer(new Size(10, 10));
        assert (boardDrawer.drawGridWithGivenPosition(position)) : "Board creator didn't draw grid with given position";
    }

    @Test(dataProviderClass = BoardDrawerDP.class, dataProvider = "positionWithBoardSize")
    public void testIfBoardCreatorCanDrawGridWithGivenSize(Position position, Size size) {
        BoardDrawer boardDrawer = new BoardDrawer(size);
        assert (boardDrawer.drawGridWithGivenPositionAnSize(position)) : "Board creator didn't draw grid with given position and size";
    }*/

  /*  @Test(dataProviderClass = BoardDrawerDP.class, dataProvider = "positionsWithBoardSize")
    public void testIfBoardCreatorCanDrawGridWithGivenSizeAndPositions(Positions positions, Size size) {
        BoardDrawer boardDrawer = new BoardDrawer(size);
        assert (boardDrawer.drawGridWithGivenPositions(positions, true)) : "Board creator didn't draw grid with given position and size";
    }*/
}
