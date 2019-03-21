package com.firm.OX;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @author Ola Podorska
 */

@Test
public class PositionsQTest {

    public void ifAllPositionsAreSavedInQueue() {
        // arrange
        Round round = new Round(new BoardDrawer(new Size()));
        Positions startingPositions = new Positions(10, new PositionComparator());
        Map<String, Player> players = new HashMap<>();
        players.put("O", new Player("kolko", new InputReader(new Scanner("0\n1"))));
        players.put("X", new Player("krzyzyk", new InputReader(new Scanner("1\n0"))));
        Scanner scanner = new Scanner("0\n1");
        InputReader inputReader = new InputReader(scanner);
        // act
        Positions afterFirstPlay = round.play(players.get("O"));
        Positions afterSecondPlay = round.play(players.get("X"));
        // assert
        assert startingPositions != afterFirstPlay : "positions are unchanged despite a move being made";
        //assert afterFirstPlay != afterSecondPlay : "positions are equal despite a 2nd move being made";
    }
}
