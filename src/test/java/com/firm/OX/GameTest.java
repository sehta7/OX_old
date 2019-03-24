package com.firm.OX;

import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */

@Test
public class GameTest {

    @Test
    public void testIfChosenOptionsAreSaved() {
        String input = "jacek\nbasia\n100 100\n10\n";
        InputReader inputReader = new InputReader(new Scanner(input));
        Game ticTacToe = new Game(inputReader);
        ticTacToe.setGameOptions();
        assert (ticTacToe.gameOptions().sizeOfBoard().equals(new Size(100, 100))) : "Size of board wasn't save in game options";
        assert (ticTacToe.gameOptions().numberOfCharacters() == 10) : "Number of winning characters wasn't save in game options";
        //assert (ticTacToe.gameOptions().players().containsValue(new Player("jacek", new InputReader(new Scanner(System.in)))) && ticTacToe.gameOptions().players().containsValue(new Player("basia", new InputReader(new Scanner(System.in))))) : "Players wasn't save in game options";
//        assert (ticTacToe.gameOptions().whoStarts().equals(new Player("jacek", new InputReader(new Scanner(System.in))))) : "Starting player wasn't save in game options";
    }

    @Test
    public void testIfBoardCanBeInitialized() {
        String input = "jacek\nbasia\n15 10\n10\n";
        InputReader inputReader = new InputReader(new Scanner(input));
        Game ticTacToe = new Game(inputReader);
        ticTacToe.setGameOptions();
    }
}
