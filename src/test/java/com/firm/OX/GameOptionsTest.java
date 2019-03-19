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
        gameOptions.assignPlayers(playerOne, playerTwo);
        assert (playerOne.getCharacter().equals("O") && playerTwo.getCharacter().equals("X")) : "Bad players assignment";
    }
}
