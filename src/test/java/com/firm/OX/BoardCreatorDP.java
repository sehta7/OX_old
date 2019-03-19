package com.firm.OX;

import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 * @author Ola Podorska
 */
public class BoardCreatorDP {

    private final static int MAX_ARRAY_SIZE = 100;
    private final static int MIN_ARRAY_SIZE = 50;

    @DataProvider
    public static Object[][] positionsOnBoard(){
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
    public static Object[][] positionsWithBoardSize(){
        Random random = new Random();
        return new Object[][]{
                {new Position(random.nextInt(MIN_ARRAY_SIZE), random.nextInt(MIN_ARRAY_SIZE)), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)},
                {new Position(random.nextInt(MIN_ARRAY_SIZE), random.nextInt(MIN_ARRAY_SIZE)), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)},
                {new Position(random.nextInt(MIN_ARRAY_SIZE), random.nextInt(MIN_ARRAY_SIZE)), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)},
                {new Position(random.nextInt(MIN_ARRAY_SIZE), random.nextInt(MIN_ARRAY_SIZE)), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)},
                {new Position(random.nextInt(MIN_ARRAY_SIZE), random.nextInt(MIN_ARRAY_SIZE)), new Size(random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE, random.nextInt((MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + 1) + MIN_ARRAY_SIZE)}
        };
    }
}
