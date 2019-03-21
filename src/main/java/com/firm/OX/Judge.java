package com.firm.OX;

import java.util.Map;

/**
 * @author Ola Podorska
 */
class Judge {

    Size size;

    public Judge(Size size) {
        this.size = size;
    }

    public boolean checkNeighbours(Field field, Positions positions) {
        boolean hasNeighbour = false;
        Position position = field.getPosition();
        Map<Position, Player> playerMap = positions.findplayerPositions();
        if (playerMap.containsKey(position)){
            if (position.getRow() != size.getLength()){
                if (playerMap.containsKey((new Position((position.getRow() + 1), position.getColumn())))){
                    hasNeighbour = true;
                }
            }
            if (position.getRow() != size.getLength() && position.getColumn() != size.getHeight()){
                if (playerMap.containsKey(new Position((position.getRow() + 1), (position.getColumn() + 1)))){
                    hasNeighbour = true;
                }
            }
            if (position.getRow() != size.getLength() && position.getColumn() != 0){
                if (playerMap.containsKey(new Position((position.getRow() + 1), (position.getColumn() - 1)))){
                    hasNeighbour = true;
                }
            }
            if (position.getColumn() != size.getHeight()){
                if (playerMap.containsKey(new Position(position.getRow(), (position.getColumn() + 1)))){
                    hasNeighbour = true;
                }
            }
            if (position.getColumn() != 0){
                if (playerMap.containsKey(new Position(position.getRow(), (position.getColumn() - 1)))){
                    hasNeighbour = true;
                }
            }
            if (position.getRow() != 0){
                if (playerMap.containsKey(new Position((position.getRow() - 1), position.getColumn()))){
                    hasNeighbour = true;
                }
            }
            if (position.getRow() != 0 && position.getColumn() != size.getHeight()){
                if (playerMap.containsKey(new Position((position.getRow() - 1), (position.getColumn() + 1)))){
                    hasNeighbour = true;
                }
            }
            if (position.getRow() != 0 && position.getColumn() != 0){
                if (playerMap.containsKey(new Position((position.getRow() - 1), (position.getColumn() - 1)))){
                    hasNeighbour = true;
                }
            }
        }
        return hasNeighbour;
    }
}
