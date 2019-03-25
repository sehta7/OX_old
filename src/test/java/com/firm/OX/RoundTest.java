package com.firm.OX;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RoundTest {

    @Test
    public void testIfRoundCanReturnsWinner() {
        Round round = new Round(new GameOptions(), new Displayer(new Language("pl")), new Registrar(new GameOptions()));
        Player player = new Player("winner", Characters.NAUGHT);
        round.setWinner(player);
        assert (player.equals(round.whoIsWinner())) : "Round doesn't know winner";
    }
}