package com.firm.OX;

import org.testng.annotations.Test;

/**
 * @author Ola Podorska
 */

@Test
public class InputReaderTest {

    @Test(dataProviderClass = InputReaderDP.class, dataProvider = "sizes")
    public void testIfReaderCanAcceptPlayerInput(Size size) {
        InputReader inputReader = new InputReader();
        assert (inputReader.readSize(size).equals(size)) : "Input reader doesn't return proper size";
    }
}
