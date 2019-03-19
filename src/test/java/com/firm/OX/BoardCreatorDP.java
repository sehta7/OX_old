package com.firm.OX;

import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 * @author Ola Podorska
 */
public class BoardCreatorDP {

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
}
