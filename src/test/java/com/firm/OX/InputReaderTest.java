package com.firm.OX;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author Ola Podorska
 */

@Test
public class InputReaderTest {

    @Test(dataProviderClass = InputReaderDP.class, dataProvider = "inputsSizes")
    public void testIfReaderCanAcceptPlayerChosenSize(Size result, String input) {
        InputReader inputReader = new InputReader();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assert (inputReader.readSize().equals(result)) : "Input reader doesn't return proper size";
    }
}
