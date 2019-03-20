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
    public static Object[][] inputSizes(){
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

    @DataProvider
    public static Object[][] inputPlayers(){
        return new Object[][]{
                {randomName()},
                {randomName()},
                {randomName()},
                {randomName()},
                {randomName()}
        };
    }

    private static String randomName(){
        Random random = new Random();
        int firstASCIIChar = 32;
        int lastASCIIChar = 126;
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < random.nextInt(15); i++){
            name.append(random.nextInt((lastASCIIChar - firstASCIIChar) + 1) + firstASCIIChar);
        }
        return name.toString();
    }


    @DataProvider
    public static Object[][] inputCharacterNumbers(){
        Random random = new Random();
        int a;
        return new Object[][]{
                {a = random.nextInt(MAX_ARRAY_SIZE), "" + a},
                {a = random.nextInt(MAX_ARRAY_SIZE), "" + a},
                {a = random.nextInt(MAX_ARRAY_SIZE), "" + a},
                {a = random.nextInt(MAX_ARRAY_SIZE), "" + a},
                {a = random.nextInt(MAX_ARRAY_SIZE), "" + a}
        };
    }

    @DataProvider
    public static Object[][] illegalSizes(){
        return new Object[][]{
                {"0 0"},
                {"1 1"},
                {"2 2"},
                {"0 1"},
                {"0 2"},
                {"1 0"},
                {"1 2"},
                {"2 0"},
                {"2 1"}
        };
    }
}
