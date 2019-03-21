package com.firm.OX;

import java.util.Map;

/**
 * @author Ola Podorska
 */
public class Round {

    private Player roundWinner;
    private BoardDrawer boardDrawer;
    private Positions positions;
    private Judge judge;
    private GameOptions gameOptions;

    Round(BoardDrawer boardDrawer, Judge judge) {
        this.boardDrawer = boardDrawer;
        positions = new Positions(10, new PositionComparator());
        this.judge = judge;
    }

    public Round(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
        this.boardDrawer = new BoardDrawer(gameOptions.sizeOfBoard());
        positions = new Positions(10, new PositionComparator());
        this.judge = new Judge(gameOptions.sizeOfBoard(), gameOptions.numberOfCharacters());
    }

    Player start(Map<String, Player> players) {
        boolean noWinner = true;
        boolean o = true;
        Field chosenField;
        Player smallWinner;
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
                if (judge.checkDraw(positions, gameOptions)){
                    System.out.println("No one win");
                    cleanBoard();
                    gameOptions.initializeBoard();
                }
                if (judge.foundSequence(chosenField, positions)){
                    smallWinner = positions.findPlayer(chosenField);
                    smallWinner.addPoint();
                    if (judge.checkIfWinRound(smallWinner)){
                        roundWinner = smallWinner;
                        System.out.println("End of round!");
                        System.out.println("Win " + roundWinner);
                        noWinner = false;
                    }
                    System.out.println("Win " + smallWinner);
                    cleanBoard();
                    gameOptions.initializeBoard();
                }
            }
        }

        return roundWinner;
    }

    private void cleanBoard() {
        this.gameOptions = gameOptions;
        this.boardDrawer = new BoardDrawer(gameOptions.sizeOfBoard());
        positions = new Positions(10, new PositionComparator());
        this.judge = new Judge(gameOptions.sizeOfBoard(), gameOptions.numberOfCharacters());
    }

    Field play(Player player) {
        System.out.println("Choose field");
        Position position = player.chooseField();
        if (position.hasEnd()){
            System.exit(0);
        }
        if (judge.isPositionGood(position, positions)){
            positions.linkPlayerWithPositions(player, position);
            positions.add(position);
        } else{
            System.out.println("Give proper value");
            play(player);
        }
        return new NotEmptyField(position);
    }

    public Player whoIsWinner(){
        return roundWinner;
    }
}
