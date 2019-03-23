package com.firm.OX;

import java.util.Collections;
import java.util.Map;

/**
 * @author Ola Podorska
 */
public class Game {

    private Round round;
    private GameOptions gameOptions;
    private Map<Player, Integer> points;
    private Displayer displayer;

    public Game(GameOptions gameOptions, Map<Player, Integer> points, Displayer displayer) {
        this.gameOptions = gameOptions;
        this.points = points;
        this.displayer = displayer;
    }

    public void start() {
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

    private Player checkWinner() {
        return Collections.max(points.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
    }
}
