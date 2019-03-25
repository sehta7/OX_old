package com.firm.OX;

/**
 * Available directions to check by HorizontallyChecker
 *
 * @author Ola Podorska
 */
enum Direction {

    ALL("A"), UP("U"), DOWN("D"), RIGHT("R"), LEFT("L"), UP_LEFT("UL"), UP_RIGHT("UR"), DOWN_LEFT("DL"), DOWN_RIGHT("DR");


    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    String getDirection() {
        return direction;
    }

}
