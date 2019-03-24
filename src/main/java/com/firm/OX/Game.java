package com.firm.OX;

import java.util.*;

/**
 * @author Ola Podorska
 */
class Game {

    private Round round;
    private GameOptions gameOptions;
    private Map<Player, Integer> points;
    private Displayer displayer;

    Game(GameOptions gameOptions, Map<Player, Integer> points, Displayer displayer) {
        this.gameOptions = gameOptions;
        this.points = points;
        this.displayer = displayer;
    }

    Game(GameOptions gameOptions, HashMap<Player, Integer> points) {
        this.gameOptions = gameOptions;
        this.points = points;
        this.displayer = new Displayer(new Language("en"));
    }

    void start() {
        for (int i = 0; i < 3; i++){
            displayer.displayNewRound();
            round = new Round(gameOptions, displayer, new Registrar(gameOptions));
            gameOptions.initializeBoard();
            Player player = round.start(gameOptions.players());
            if (points.containsKey(player)){
                points.put(player, (points.get(player) + 1));
            } else{
                points.put(player, 1);
            }
        }
        
        Player winner = checkWinner();
        displayer.displayWhoWin(winner);
    }

    void autoGame(List<Position> positions){

        round = new Round(gameOptions, displayer, new Registrar(gameOptions));
        gameOptions.initializeBoard();
        while (!positions.isEmpty()) {
            Player player = round.startFromFile(gameOptions.players(), positions);
            if (points.containsKey(player)) {
                points.put(player, (points.get(player) + 1));
            } else {
                points.put(player, 1);
            }
        }
    }

    private Player checkWinner() {
        return Collections.max(points.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
    }
}
