package com.firm.OX;

import org.testng.annotations.Test;

import java.util.Queue;

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

    @Test(dataProviderClass = BoardCreatorDP.class, dataProvider = "positionOnBoard")
    public void testIfBoardCreatorCanDrawGridWithGivenPosition(Position position) {
        BoardCreator boardCreator = new BoardCreator();
        assert (boardCreator.drawGridWithGivenPosition(position)) : "Board creator didn't draw grid with given position";
    }

    @Test(dataProviderClass = BoardCreatorDP.class, dataProvider = "positionWithBoardSize")
    public void testIfBoardCreatorCanDrawGridWithGivenSize(Position position, Size size) {
        BoardCreator boardCreator = new BoardCreator();
        assert (boardCreator.drawGridWithGivenPositionAnSize(position, size)) : "Board creator didn't draw grid with given position and size";
    }

    @Test(dataProviderClass = BoardCreatorDP.class, dataProvider = "positionsWithBoardSize")
    public void testIfBoardCreatorCanDrawGridWithGivenSizeAndPositions(Queue<Position> positions, Size size) {
        BoardCreator boardCreator = new BoardCreator();
        assert (boardCreator.drawGridWithGivenPositionsAnSize(positions, size)) : "Board creator didn't draw grid with given position and size";
    }
}
