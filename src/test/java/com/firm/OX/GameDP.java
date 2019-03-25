package com.firm.OX;

import org.testng.annotations.DataProvider;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ola Podorska
 *
 */

public class GameDP {

    private final static int MAX_ARRAY_SIZE = 4850;

    @DataProvider
    public static Object[][] options(){
        Random random = new Random();
        Displayer displayer = new Displayer(new Language("en"));
        return new Object[][]{
                {new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE)), random.nextInt(98) + 3},
                {new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE)), random.nextInt(98) + 3},
                {new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE)), random.nextInt(98) + 3},
                {new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE)), random.nextInt(98) + 3},
                {new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE)), random.nextInt(98) + 3},
                {new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE)), random.nextInt(98) + 3},
                {new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE)), random.nextInt(98) + 3},
                {new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE)), random.nextInt(98) + 3},
                {new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE)), random.nextInt(98) + 3},
                {new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Player(randomName(), new InputReader(new Scanner(System.in), displayer)), new Size(random.nextInt(MAX_ARRAY_SIZE), random.nextInt(MAX_ARRAY_SIZE)), random.nextInt(98) + 3}
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
}
