package com.firm.OX;

import java.util.Map;

/**
 * @author Ola Podorska
 */
public class Round {

    private Player winner;
    private BoardDrawer boardDrawer;
    private Positions positions;
    private Judge judge;

    Round(BoardDrawer boardDrawer, Judge judge) {
        this.boardDrawer = boardDrawer;
        positions = new Positions(10, new PositionComparator());
        this.judge = judge;
    }

    void start(Map<String, Player> players) {
        boolean noWinner = true;
        boolean o = true;
        Field chosenField;

        while (noWinner){
            if (o){
                chosenField = play(players.get("O"));
                o = false;
            } else{
                chosenField = play(players.get("X"));
                o = true;
            }
            String history = boardDrawer.drawGridWithGivenPositions(positions);
            if (positions.enoughToCheck()){
                if (judge.foundSequence(chosenField, positions)){
                    winner = positions.findPlayer(chosenField);
                    noWinner = false;
                    System.out.println("Win " + winner);
                }
            }
        }

    }

    Field play(Player player) {
        System.out.println("Choose field");
        Position position = player.chooseField();
        positions.linkPlayerWithPositions(player, position);
        positions.add(position);
        return new NotEmptyField(position);
    }

    public Player whoIsWinner(){
        return winner;
    }
}
