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
}
