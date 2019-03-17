package com.firm.OX;

import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 *
 * @author Ola Podorska
 *
 */

public class FieldDP {

    @DataProvider
    public static Object[][] positions(){
        Random random = new Random();
        return new Object[][]{
                {random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE)},
                {random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE)},
                {random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE)},
                {random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE)},
                {random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE)}
        };
    }
}
