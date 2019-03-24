package com.firm.OX;

import org.testng.annotations.DataProvider;

public class ComparatorDP {

    @DataProvider
    public static Object[][] drawValues(){
        return new Object[][]{
                {new Position(5, 7), new Position(14, 6), 1},
                {new Position(8, 24), new Position(4, 24), 4},
                {new Position(3, 285), new Position(356, 35), 250},
                {new Position(25, 4), new Position(25, 29), -25},
                {new Position(73, 62), new Position(73, 62), 0},
                {new Position(135, 824), new Position(174, 184), 640},
                {new Position(4, 6), new Position(14, 6), -10},
                {new Position(8402, 257), new Position(1245, 300), -43},
                {new Position(2639, 71), new Position(3, 56), 15},
                {new Position(5373, 9724), new Position(2627, 9720), 4}
        };
    }

    @DataProvider
    public static Object[][] positionValues(){
        return new Object[][]{
                {new Position(5, 7), new Position(14, 6), -9},
                {new Position(8, 24), new Position(4, 24), 4},
                {new Position(3, 285), new Position(356, 35), -353},
                {new Position(25, 4), new Position(25, 29), -25},
                {new Position(73, 62), new Position(73, 62), 0},
                {new Position(135, 824), new Position(174, 184), -39},
                {new Position(4, 6), new Position(14, 6), -10},
                {new Position(8402, 257), new Position(1245, 300), 7157},
                {new Position(2639, 71), new Position(3, 56), 2636},
                {new Position(5373, 9724), new Position(2627, 9720), 2746}
        };
    }

}
