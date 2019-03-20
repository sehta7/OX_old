package com.firm.OX;

import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 *
 * @author Ola Podorska
 *
 */

public class InputReaderDP {

    private final static int MAX_ARRAY_SIZE = 4850;

    @DataProvider
    public static Object[][] inputsSizes(){
        Random random = new Random();
        int a, b;
        return new Object[][]{
                {new Size( a = random.nextInt(MAX_ARRAY_SIZE), b = random.nextInt(MAX_ARRAY_SIZE)), a + " " + b},
                {new Size( a = random.nextInt(MAX_ARRAY_SIZE), b = random.nextInt(MAX_ARRAY_SIZE)), a + " " + b},
                {new Size( a = random.nextInt(MAX_ARRAY_SIZE), b = random.nextInt(MAX_ARRAY_SIZE)), a + " " + b},
                {new Size( a = random.nextInt(MAX_ARRAY_SIZE), b = random.nextInt(MAX_ARRAY_SIZE)), a + " " + b},
                {new Size( a = random.nextInt(MAX_ARRAY_SIZE), b = random.nextInt(MAX_ARRAY_SIZE)), a + " " + b}
        };
    }
}
