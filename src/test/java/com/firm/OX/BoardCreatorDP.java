package com.firm.OX;

import org.testng.annotations.DataProvider;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @author Ola Podorska
 */
public class BoardCreatorDP {

    private final static int MAX_ARRAY_SIZE = 10;
    private final static int MIN_ARRAY_SIZE = 5;

    @DataProvider
    public static Object[][] positionOnBoard(){
        Random random = new Random();
        return new Object[][]{
                {new Position(random.nextInt(10), random.nextInt(10))},
                {new Position(random.nextInt(10), random.nextInt(10))},
                {new Position(random.nextInt(10), random.nextInt(10))},
                {new Position(random.nextInt(10), random.nextInt(10))},
                {new Position(random.nextInt(10), random.nextInt(10))}
        };
    }

    @DataProvider
    public static Object[][] positionWithBoardSize(){
        Random random = new Random();
        return new Object[][]{
                {new Position(random.nextInt(MIN_ARRAY_SIZE), random.nextInt(MIN_ARRAY_SIZE)), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)},
                {new Position(random.nextInt(MIN_ARRAY_SIZE), random.nextInt(MIN_ARRAY_SIZE)), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)},
                {new Position(random.nextInt(MIN_ARRAY_SIZE), random.nextInt(MIN_ARRAY_SIZE)), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)},
                {new Position(random.nextInt(MIN_ARRAY_SIZE), random.nextInt(MIN_ARRAY_SIZE)), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)},
                {new Position(random.nextInt(MIN_ARRAY_SIZE), random.nextInt(MIN_ARRAY_SIZE)), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)}
        };
    }

    @DataProvider
    public static Object[][] positionsWithBoardSize(){
        Random random = new Random();
        return new Object[][]{
                {randomPositions(), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)},
                {randomPositions(), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)},
                {randomPositions(), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)},
                {randomPositions(), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)},
                {randomPositions(), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)}
        };
    }

    public static Queue<Position> randomPositions(){
        Random random = new Random();
        Queue<Position> positions = new PriorityQueue<>(10, new PositionComparator());
        for (int i = 0; i < random.nextInt(10) + 1; i++){
            positions.add(new Position(random.nextInt(MIN_ARRAY_SIZE), random.nextInt(MIN_ARRAY_SIZE)));
        }
        return positions;
    }
}
