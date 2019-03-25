package com.firm.OX;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author Ola Podorska
 */

@Test
public class InputReaderTest {

    @Test(dataProviderClass = InputReaderDP.class, dataProvider = "inputSizes")
    public void testIfReaderCanAcceptPlayerChosenSize(Size result, String input) {
        InputReader inputReader = new InputReader(new Scanner(input), new Displayer(new Language("en")));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assert (inputReader.readSize().equals(result)) : "Input reader doesn't return proper size";
    }

    @Test(dataProviderClass = InputReaderDP.class, dataProvider = "inputPlayers")
    public void testIfReaderCanAcceptWhoStartsGame(String input) {
        InputReader inputReader = new InputReader(new Scanner(input), new Displayer(new Language("en")));
        Player player = new Player(input, new InputReader(new Scanner(System.in), new Displayer(new Language("en"))));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assert (inputReader.readPlayer().equals(player)) : "Input reader doesn't return starting player";
    }

    @Test(dataProviderClass = InputReaderDP.class, dataProvider = "inputCharacterNumbers")
    public void testIfReaderCanAcceptNumberOfWinningCharacters(int result, String input) {
        InputReader inputReader = new InputReader(new Scanner(input), new Displayer(new Language("en")));
        assert (inputReader.readNumberOfCharacters() == result) : "Input reader doesn't return number of winning characters";
    }

    @Test(dataProviderClass = InputReaderDP.class, dataProvider = "illegalSizes", expectedExceptions = IllegalArgumentException.class)
    public void testIfPlayerGiveWrongBoardSize(String input) {
        InputReader inputReader = new InputReader(new Scanner(input), new Displayer(new Language("en")));
        inputReader.readSize();
    }

    @Test(dataProviderClass = InputReaderDP.class, dataProvider = "illegalCharacters", expectedExceptions = IllegalArgumentException.class)
    public void testIfPlayerGiveWrongNumberOfCharacters(String input) {
        InputReader inputReader = new InputReader(new Scanner(input), new Displayer(new Language("en")));
        inputReader.readNumberOfCharacters();
    }
}
