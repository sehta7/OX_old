package com.firm.OX;

import org.testng.annotations.Test;

/**
 * @author Ola Podorska
 */

@Test
public class TicTacToeTest {

    @Test(dataProviderClass = TicTacToeDP.class, dataProvider = "options")
    public void testIfChosenOptionsAreSaved(Player p1, Player p2, Size size, int numberOfCharacters) {
        TicTacToe ticTacToe = new TicTacToe();
        GameOptions gameOptions = new GameOptions();
        ticTacToe.setGameOpotions(gameOptions);
        assert (gameOptions.sizeOfBoard().equals(size)) : "Size of board wasn't save in game options";
        assert (gameOptions.numberOfCharacters() == numberOfCharacters) : "Number of winning characters wasn't save in game options";
        assert (gameOptions.players().containsValue(p1) && gameOptions.players().containsValue(p2)) : "Players wasn't save in game options";
        assert (gameOptions.whoStarts().equals(p1)) : "Starting player wasn't save in game options";
    }
}
