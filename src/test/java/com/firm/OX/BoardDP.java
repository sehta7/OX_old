package com.firm.OX;

import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 *
 * @author Ola Podorska
 *
 */

public class BoardDP {

    @DataProvider
    public static Object[][] sizes(){
        Random random = new Random();
        return new Object[][]{
                {new Size(random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE))},
                {new Size(random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE))},
                {new Size(random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE))},
                {new Size(random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE))},
                {new Size(random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE))}
        };
    }
}
