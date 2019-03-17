package com.firm.OX;

import org.testng.annotations.Test;

/**
 *
 * @author Ola Podorska
 *
 */

@Test
public class FieldTest {

    @Test
    public void testIfEmptyFieldCanBeCreated() {
        Field field = new EmptyField();
    }

    @Test
    public void testIfNotEmptyFieldCanBeCreated() {
        Field field = new NotEmptyField();
    }

    @Test(dataProviderClass = FieldDP.class, dataProvider = "positions")
    public void testIfEmptyFieldCanHavePosition(Position position) {
        Field field = new EmptyField(position);
        assert (field.getPosition().equals(position)) : "Empty field has wrong position";
    }
}
