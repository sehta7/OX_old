package com.firm.OX;

import org.testng.annotations.Test;

@Test
public class DrawerComparatorTest {

    @Test(dataProviderClass = ComparatorDP.class, dataProvider = "drawValues")
    public void testIfCompareTwoValuesProperly(Position p1, Position p2, int result) {
        DrawerComparator comparator = new DrawerComparator();
        int compare = comparator.compare(p1, p2);
        assert (result == compare) : "Values in comparator doesn't change properly";
    }
}