package com.firm.OX;

import org.testng.annotations.Test;

/**
 * @author Ola Podorska
 */

@Test
public class GameOptionsTest {

    @Test
    public void testIfPlayerCanChooseCharacter() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        GameOptions gameOptions = new GameOptions();
        gameOptions.assignPlayers(playerOne, "O");
        gameOptions.assignPlayers(playerTwo, "X");
        assert (gameOptions.isPlayerO(playerOne)) : "Bad players assignment for O";
        assert (gameOptions.isPlayerX(playerTwo)) : "Bad players assignment for X";
    }

    @Test
    public void testIfPlayerCanChooseWhoStartsGame() {
        GameOptions gameOptions = new GameOptions();
        Player player = new Player();
        gameOptions.start(player);
        assert (gameOptions.isPlayerO(player)) : "O always starts, but player is not O";
    }

    @Test(dataProviderClass = GameOptionsDP.class, dataProvider = "sizes")
    public void testIfPlayerCanChooseBoardSize(Size size) {
        GameOptions gameOptions = new GameOptions();
        gameOptions.chosenSize(size);
        assert (size.equals(gameOptions.sizeOfBoard())) : "Size of board is not the same as in options";
    }

    @Test(dataProviderClass = GameOptionsDP.class, dataProvider = "characters")
    public void testIfPlayerCanChoseNumberOfWinningCharacters(int numberOfCharacters) {
        GameOptions gameOptions = new GameOptions();
        gameOptions.chosenCharacters(numberOfCharacters);
        assert (gameOptions.numberOfCharacters() == numberOfCharacters) : "Number of winning characters are not the same as in options";
    }

    @Test(dataProviderClass = GameOptionsDP.class, dataProvider = "illegalSizes", expectedExceptions = IllegalArgumentException.class)
    public void testIfPlayerChoseTooLowSizeOfBoard(Size size) {
        GameOptions gameOptions = new GameOptions();
        gameOptions.chosenSize(size);
    }
}
