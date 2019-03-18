package com.firm.OX;

import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 *
 * @author Ola Podorska
 *
 */

public class BoardDP {

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
    public static Object[][] illegalSizes(){
        return new Object[][]{
                {new Size(0, 0)},
                {new Size(1, 1)},
                {new Size(2, 2)},
                {new Size(0, 1)},
                {new Size(0, 2)},
                {new Size(1, 0)},
                {new Size(1, 2)},
                {new Size(2, 0)},
                {new Size(2, 1)},
        };
    }
}
