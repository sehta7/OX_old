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
    private Player startingPlayer;
    private Player nextPlayer;
    private boolean startO;
    private Displayer displayer;
    private Registrar registrar;

    Round(BoardDrawer boardDrawer, Judge judge, Displayer displayer, Registrar registrar) {
        this.boardDrawer = boardDrawer;
        positions = new Positions(10, new PositionComparator());
        this.judge = judge;
        this.displayer = displayer;
        this.registrar = registrar;
    }

    public Round(GameOptions gameOptions, Displayer displayer) {
        this.gameOptions = gameOptions;
        this.boardDrawer = new BoardDrawer(gameOptions.sizeOfBoard());
        this.displayer = displayer;
        this.judge = new Judge(gameOptions.sizeOfBoard(), gameOptions.numberOfCharacters());
        positions = new Positions(10, new PositionComparator());
        startingPlayer = gameOptions.whoStarts();
        startO = true;
    }

    public Round(GameOptions gameOptions, Displayer displayer, Registrar registrar) {
        this.gameOptions = gameOptions;
        this.displayer = displayer;
        this.registrar = registrar;
        this.judge = new Judge(gameOptions.sizeOfBoard(), gameOptions.numberOfCharacters());
        this.boardDrawer = new BoardDrawer(gameOptions.sizeOfBoard());
        positions = new Positions(10, new PositionComparator());
        startingPlayer = gameOptions.whoStarts();
        startO = true;
    }

    Player start(Map<String, Player> players) {
        boolean noWinner = true;
        Field chosenField;
        Player smallWinner;

        if (startingPlayer.equals(players.get("O"))) {
            nextPlayer = players.get("X");
        } else {
            nextPlayer = players.get("0");
        }

        while (noWinner) {

            if (startO) {
                chosenField = play(players.get("O"));
                startO = false;
            } else {
                chosenField = play(players.get("X"));
                startO = true;
            }
            Positions draw = new Positions(10, new DrawerComparator());
            positions.copyTo(draw);
            String move = boardDrawer.drawGridWithGivenPositions(draw);
            registrar.saveMove(move);
            if (positions.enoughToCheck()) {
                if (judge.checkDraw(positions, gameOptions)) {
                    displayer.displayDraw();
                    cleanBoard(players);
                    gameOptions.initializeBoard();
                }
                if (judge.foundSequence(chosenField, positions)) {
                    smallWinner = positions.findPlayer(chosenField);
                    smallWinner.addPoint();
                    if (judge.checkIfWinRound(smallWinner)) {
                        roundWinner = smallWinner;
                        displayer.displayScores(roundWinner);
                        noWinner = false;
                        startingPlayer.resetPoints();
                        nextPlayer.resetPoints();
                    }
                    displayer.displayScores(smallWinner);
                    cleanBoard(players);
                    gameOptions.initializeBoard();
                }
            }
        }

        return roundWinner;
    }

    private void cleanBoard(Map<String, Player> players) {
        this.boardDrawer = new BoardDrawer(gameOptions.sizeOfBoard());
        positions = new Positions(10, new PositionComparator());
        this.judge = new Judge(gameOptions.sizeOfBoard(), gameOptions.numberOfCharacters());
        if (startingPlayer.equals(players.get("O"))) {
            startingPlayer = players.get("X");
            nextPlayer = players.get("O");
            startO = false;
        } else {
            startingPlayer = players.get("O");
            nextPlayer = players.get("X");
            startO = true;
        }
    }

    Field play(Player player) {
        displayer.displayQuestionAboutField();
        Position position = player.chooseField();
        if (position.hasEnd()) {
            System.exit(0);
        }
        if (judge.isPositionGood(position, positions)) {
            positions.linkPlayerWithPositions(player, position);
            positions.add(position);
        } else {
            System.out.println("Give proper value");
            play(player);
        }
        return new NotEmptyField(position);
    }

    public Player whoIsWinner() {
        return roundWinner;
    }
}
