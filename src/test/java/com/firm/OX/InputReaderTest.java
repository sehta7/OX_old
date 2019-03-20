package com.firm.OX;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author Ola Podorska
 */

@Test
public class InputReaderTest {

    @Test(dataProviderClass = InputReaderDP.class, dataProvider = "inputSizes")
    public void testIfReaderCanAcceptPlayerChosenSize(Size result, String input) {
        InputReader inputReader = new InputReader();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assert (inputReader.readSize().equals(result)) : "Input reader doesn't return proper size";
    }

    @Test(dataProviderClass = InputReaderDP.class, dataProvider = "inputPlayers")
    public void testIfReaderCanAcceptWhoStartsGame(String input) {
        InputReader inputReader = new InputReader();
        Player player = new Player(input);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assert (inputReader.readStartingPlayer().equals(player));
    }
}
