package com.firm.OX;

import java.util.Map;

/**
 * @author Ola Podorska
 */
public class Round {

    private Player winner;
    private BoardDrawer boardDrawer;
    private Positions positions;

    Round(BoardDrawer boardDrawer) {
        this.boardDrawer = boardDrawer;
        positions = new Positions(10, new PositionComparator());
    }

    void start(Map<String, Player> players) {
        boolean noWinner = true;
        boolean o = true;

        while (noWinner){
            if (o){
                positions = play(players.get("O"));
                o = false;
            } else{
                positions = play(players.get("X"));
                o = true;
            }
            boardDrawer.drawGridWithGivenPositions(positions);
        }

    }

    Positions play(Player playerO) {
        System.out.println("Choose field");
        Position position = playerO.chooseField();
        positions.add(position);
        return positions;
    }

    public Player whoIsWinner(){
        return winner;
    }
}
