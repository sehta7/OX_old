package com.firm.OX;

import org.testng.annotations.Test;

@Test
public class PositionComparatorTest {

    @Test(dataProviderClass = ComparatorDP.class, dataProvider = "positionValues")
    public void testIfCompareTwoValuesProperly(Position p1, Position p2, int result) {
        PositionComparator comparator = new PositionComparator();
        int compare = comparator.compare(p1, p2);
        assert (result == compare) : "Values in comparator doesn't change properly";
    }
}