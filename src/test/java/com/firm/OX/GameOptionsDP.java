package com.firm.OX;

import org.testng.annotations.DataProvider;

import java.util.Random;

public class GameOptionsDP {

    private final static int MAX_ARRAY_SIZE = 4850;
    @DataProvider
    public static Object[][] sizes(){
        Random random = new Random();
        return new Object[][]{
                {new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE))},
                {new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE))},
                {new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE))},
                {new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE))},
                {new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE))}
        };
    }

    @DataProvider
    public static Object[][] characters(){
        Random random = new Random();
        return new Object[][]{
                {random.nextInt(100)},
                {random.nextInt(100)},
                {random.nextInt(100)},
                {random.nextInt(100)},
                {random.nextInt(100)}
        };
    }
}
