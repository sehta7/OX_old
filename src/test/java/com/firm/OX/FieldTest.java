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
}
