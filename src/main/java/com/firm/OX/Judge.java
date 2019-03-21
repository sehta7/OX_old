package com.firm.OX;

import java.util.Map;

/**
 * @author Ola Podorska
 */
class Judge {

    Size size;
    int neighbours;

    public Judge(Size size) {
        this.size = size;
        neighbours = 0;
    }

    public boolean checkNeighbours(Field field, Positions positions) {
        boolean hasNeighbour = false;
        Position position = field.getPosition();
        Map<Position, Player> playerMap = positions.findplayerPositions();
        if (playerMap.containsKey(position)){
            if (position.getRow() != size.getLength()){
                if (playerMap.containsKey((new Position((position.getRow() + 1), position.getColumn())))){
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() + 1),position.getColumn())), positions)){
                        hasNeighbour = true;
                        neighbours++;
                    }
                }
            }
            if (position.getRow() != size.getLength() && position.getColumn() != size.getHeight()){
                if (playerMap.containsKey(new Position((position.getRow() + 1), (position.getColumn() + 1)))){
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() + 1),(position.getColumn() + 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                    }
                }
            }
            if (position.getRow() != size.getLength() && position.getColumn() != 0){
                if (playerMap.containsKey(new Position((position.getRow() + 1), (position.getColumn() - 1)))){
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() + 1),(position.getColumn() - 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                    }
                }
            }
            if (position.getColumn() != size.getHeight()){
                if (playerMap.containsKey(new Position(position.getRow(), (position.getColumn() + 1)))){
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position(position.getRow(),(position.getColumn() + 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                    }
                }
            }
            if (position.getColumn() != 0){
                if (playerMap.containsKey(new Position(position.getRow(), (position.getColumn() - 1)))){
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position(position.getRow(),(position.getColumn() - 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                    }
                }
            }
            if (position.getRow() != 0){
                if (playerMap.containsKey(new Position((position.getRow() - 1), position.getColumn()))){
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() - 1),position.getColumn())), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                    }
                }
            }
            if (position.getRow() != 0 && position.getColumn() != size.getHeight()){
                if (playerMap.containsKey(new Position((position.getRow() - 1), (position.getColumn() + 1)))){
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() - 1),(position.getColumn() + 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                    }
                }
            }
            if (position.getRow() != 0 && position.getColumn() != 0){
                if (playerMap.containsKey(new Position((position.getRow() - 1), (position.getColumn() - 1)))){
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() - 1),(position.getColumn() - 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                    }
                }
            }
        }
        return hasNeighbour;
    }

    public boolean isOtherPlayerField(Field field1, Field field2, Positions positions) {
        Map<Position, Player> playerMap = positions.findplayerPositions();
        Player player1 = playerMap.get(field1.getPosition());
        Player player2 = playerMap.get(field2.getPosition());
        if (player1.equals(player2)){
            return false;
        }
        return true;
    }

    public int howManyNeighbours(Field field, Positions positions) {
        checkNeighbours(field, positions);
        return neighbours;
    }
}
