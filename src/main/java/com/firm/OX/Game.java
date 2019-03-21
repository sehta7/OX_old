package com.firm.OX;

import java.util.Map;

/**
 * @author Ola Podorska
 */
public class Game {

    private Round round;
    private GameOptions gameOptions;
    private Map<Player, Integer> points;

    public Game(GameOptions gameOptions, Map<Player, Integer> points) {
        this.gameOptions = gameOptions;
        this.points = points;
    }

    public void start() {
        for (int i = 0; i < 3; i++){
            round = new Round(gameOptions);
            gameOptions.initializeBoard();
            Player player = round.start(gameOptions.players());
            if (points.containsKey(player)){
                points.put(player, (points.get(player) + 1));
            } else{
                points.put(player, 1);
            }
        }
    }
}
