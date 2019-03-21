package com.firm.OX;

import java.util.Map;

/**
 * @author Ola Podorska
 */
class Judge {

    Size size;
    int neighbours;
    Direction direction;

    public Judge(Size size) {
        this.size = size;
        neighbours = 0;
        direction = Direction.ALL;
    }

    public Field checkNeighbours(Field field, Positions positions) {
        boolean hasNeighbour = false;
        Field neighbour = field;
        Position position = field.getPosition();
        Map<Position, Player> playerMap = positions.findplayerPositions();
        if (playerMap.containsKey(position)){
            if (position.getRow() != size.getLength()){
                if (direction.equals(Direction.RIGHT) || direction.equals(Direction.ALL)){
                    if (playerMap.containsKey((new Position((position.getRow() + 1), position.getColumn())))){
                        if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() + 1),position.getColumn())), positions)){
                            hasNeighbour = true;
                            neighbours++;
                            neighbour = new NotEmptyField(new Position((position.getRow() + 1),position.getColumn()));
                            direction = Direction.RIGHT;
                        }
                    }
                }
            } else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            if (position.getRow() != size.getLength() && position.getColumn() != size.getHeight()){
                if (direction.equals(Direction.DOWN_RIGHT) || direction.equals(Direction.ALL)){
                if (playerMap.containsKey(new Position((position.getRow() + 1), (position.getColumn() + 1)))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() + 1), (position.getColumn() + 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position((position.getRow() + 1), (position.getColumn() + 1)));
                        direction = Direction.DOWN_RIGHT;
                    }
                }
                }
            } else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            if (position.getRow() != size.getLength() && position.getColumn() != 0){
                if (direction.equals(Direction.UP_RIGHT) || direction.equals(Direction.ALL)){
                if (playerMap.containsKey(new Position((position.getRow() + 1), (position.getColumn() - 1)))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() + 1), (position.getColumn() - 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position((position.getRow() + 1), (position.getColumn() - 1)));
                        direction = Direction.UP_RIGHT;
                    }
                }
                }
            } else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            if (position.getColumn() != size.getHeight()){
                if (direction.equals(Direction.DOWN) || direction.equals(Direction.ALL)){
                if (playerMap.containsKey(new Position(position.getRow(), (position.getColumn() + 1)))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position(position.getRow(), (position.getColumn() + 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position(position.getRow(), (position.getColumn() + 1)));
                        direction = Direction.DOWN;
                    }
                }
                }
            } else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            if (position.getColumn() != 0){
                if (direction.equals(Direction.UP) || direction.equals(Direction.ALL)){
                if (playerMap.containsKey(new Position(position.getRow(), (position.getColumn() - 1)))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position(position.getRow(), (position.getColumn() - 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position(position.getRow(), (position.getColumn() - 1)));
                        direction = Direction.UP;
                    }
                }
                }
            } else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            if (position.getRow() != 0){
                if (direction.equals(Direction.LEFT) || direction.equals(Direction.ALL)){
                if (playerMap.containsKey(new Position((position.getRow() - 1), position.getColumn()))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() - 1), position.getColumn())), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position((position.getRow() - 1), position.getColumn()));
                        direction = Direction.LEFT;
                    }
                }
                }
            } else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            if (position.getRow() != 0 && position.getColumn() != size.getHeight()){
                if (direction.equals(Direction.DOWN_LEFT) || direction.equals(Direction.ALL)){
                if (playerMap.containsKey(new Position((position.getRow() - 1), (position.getColumn() + 1)))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() - 1), (position.getColumn() + 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position((position.getRow() - 1), (position.getColumn() + 1)));
                        direction = Direction.DOWN_LEFT;
                    }
                }
                }
            } else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            if (position.getRow() != 0 && position.getColumn() != 0){
                if (direction.equals(Direction.UP_LEFT) || direction.equals(Direction.ALL)){
                if (playerMap.containsKey(new Position((position.getRow() - 1), (position.getColumn() - 1)))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() - 1), (position.getColumn() - 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position((position.getRow() - 1), (position.getColumn() - 1)));
                        direction = Direction.UP_LEFT;
                    }
                }
                }
            }
            else {
                neighbour = new EmptyField(new Position(0, 0));
            }
        }
        return neighbour;
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

    public boolean foundSequence(Field field, Positions positions, int numberOfCharacters) {
        Map<Position, Player> playerMap = positions.findplayerPositions();
        int counter = 0;
        boolean more = true;
        Field lastOne = field;
        while (more){
            counter++;
            lastOne = field;
            field = checkNeighbours(lastOne, positions);
            if (field instanceof EmptyField){
                more = false;
            }
        }
        if (counter == numberOfCharacters){
            return true;
        }
        return false;
    }
}
