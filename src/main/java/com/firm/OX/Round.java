package com.firm.OX;

import java.util.List;
import java.util.Map;

/**
 * Perform one round starting with first move to last, when player win having three points
 *
 * @author Ola Podorska
 */
class Round {

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
    private Positions draw;
    private int counter;

    Round(GameOptions gameOptions, Displayer displayer, Registrar registrar) {
        this.gameOptions = gameOptions;
        this.displayer = displayer;
        this.registrar = registrar;
        this.judge = new Judge(gameOptions);
        this.boardDrawer = new BoardDrawer(gameOptions.sizeOfBoard());
        positions = new Positions(10, new PositionComparator());
        startingPlayer = gameOptions.whoStarts();
        startO = true;
        counter = 0;
    }

    Player start(Map<String, Player> players) {
        boolean noWinner = true;
        chosePlayerOrder(players);
        while (noWinner) {
            noWinner = findWinner(players, noWinner);
        }
        return roundWinner;
    }

    private boolean findWinner(Map<String, Player> players, boolean noWinner) {
        Field chosenField;
        chosenField = chooseField(players);
        Positions toDraw = new Positions(10, new DrawerComparator());
        positions.copyTo(toDraw);
        String move = boardDrawer.drawGridWithGivenPositions(toDraw);
        registrar.saveMove(move);
        if (positions.enoughToCheck()) {
            noWinner = checkPositions(players, noWinner, chosenField);
        }
        return noWinner;
    }

    private boolean checkPositions(Map<String, Player> players, boolean noWinner, Field chosenField) {
        if (judge.checkDraw(positions, gameOptions)) {
            showDraw(players);
        }
        if (judge.isWinningSequence(chosenField, positions)) {
            noWinner = saveVictory(players, chosenField, positions, noWinner);
        }
        return noWinner;
    }

    private boolean saveVictory(Map<String, Player> players, Field chosenField, Positions positions, boolean noWinner) {
        Player smallWinner;
        smallWinner = positions.findPlayer(chosenField);
        smallWinner.addPoints();
        counter++;
        if (judge.checkIfEndOfRound(counter)) {
            this.roundWinner = judge.checkWhoWinRound(players);
            noWinner = finishRound();
            return noWinner;
        }
        displayer.displayScore(players);
        displayer.displaySeparator();
        cleanBoard(players);
        gameOptions.initializeBoard();
        return noWinner;
    }

    private void showDraw(Map<String, Player> players) {
        addPoint(players);
        displayer.displayDraw();
        displayer.displayScore(players);
        cleanBoard(players);
        gameOptions.initializeBoard();
    }

    private void addPoint(Map<String, Player> players) {
        players.get("O").addPoint();
        players.get("X").addPoint();
    }

    private Field chooseField(Map<String, Player> players) {
        Field chosenField;
        if (startO) {
            chosenField = play(players.get("O"));
            startO = false;
        } else {
            chosenField = play(players.get("X"));
            startO = true;
        }
        return chosenField;
    }

    private void chosePlayerOrder(Map<String, Player> players) {
        if (startingPlayer.equals(players.get("O"))) {
            nextPlayer = players.get("X");
        } else {
            nextPlayer = players.get("0");
        }
    }

    private void cleanBoard(Map<String, Player> players) {
        this.boardDrawer = new BoardDrawer(gameOptions.sizeOfBoard());
        this.positions = new Positions(10, new PositionComparator());
        this.draw = new Positions(10, new DrawerComparator());
        this.judge = new Judge(gameOptions);
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
        displayer.displaySeparator();
        displayer.displayQuestionAboutField();
        Position position = player.chooseField();
        if (position.hasEnd()) {
            System.exit(0);
        }
        try{
            judge.isPositionGood(position, positions);
            positions.linkPlayerWithPositions(player, position);
            positions.add(position);
        } catch (ChosenFieldException e){
            displayer.displayChosenFieldError();
            play(player);
        }

        return new NotEmptyField(position);
    }

    Player whoIsWinner() {
        return roundWinner;
    }

    Player startFromFile(Map<String, Player> players, List<Position> positionList) {
        boolean noWinner = true;
        chosePlayerOrder(players);
        this.draw = new Positions(10, new DrawerComparator());
        while (noWinner) {
            while (!positionList.isEmpty()) {
                checkNextPosition(players, positionList, noWinner);
            }
            return roundWinner;
        }
        return roundWinner;
    }

    private void checkNextPosition(Map<String, Player> players, List<Position> positionList, boolean noWinner) {
        Position position = positionList.get(0);
        positionList.remove(0);
        Field field = new NotEmptyField(position);
        draw.add(position);
        changePlayerOrder(position);
        boardDrawer.drawGridWithGivenPositions(draw);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (draw.enoughToCheck()) {
            if (judge.checkDraw(draw, gameOptions)) {
                showDraw(players);
            }
            if (judge.isWinningSequence(field, draw)) {
                System.out.println("Winning!");
                displayer.displaySeparator();
                draw = new Positions(10, new DrawerComparator());
            }
        }
    }

    private void changePlayerOrder(Position position) {
        if (startO) {
            draw.linkPlayerWithPositions(startingPlayer, position);
            startO = false;
        } else {
            draw.linkPlayerWithPositions(nextPlayer, position);
            startO = true;
        }
    }

    private boolean finishRound() {
        displayer.displayScores(roundWinner);
        startingPlayer.resetPoints();
        nextPlayer.resetPoints();
        return false;
    }

    void setWinner(Player player){
        this.roundWinner = player;
    }
}
