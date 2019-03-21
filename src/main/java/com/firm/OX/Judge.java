package com.firm.OX;

import java.util.Map;

/**
 * @author Ola Podorska
 */
class Judge {

    Size size;
    int neighbours;
    Direction direction;
    int numberOfCharacters;
    boolean checkOnce;

    public Judge(Size size, int numberOfCharacters) {
        this.size = size;
        neighbours = 0;
        direction = Direction.ALL;
        this.numberOfCharacters = numberOfCharacters;
        checkOnce = false;
    }

    public Field checkNeighbours(Field field, Positions positions) {
        boolean hasNeighbour = false;
        Field neighbour = field;
        Position position = field.getPosition();
        Map<Position, Player> playerMap = positions.findplayerPositions();
        if (playerMap.containsKey(position)){
            if (direction.equals(Direction.DOWN) || direction.equals(Direction.ALL)){
            if (position.getRow() != size.getLength()){

                    if (playerMap.containsKey((new Position((position.getRow() + 1), position.getColumn())))){
                        if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() + 1),position.getColumn())), positions)){
                            hasNeighbour = true;
                            neighbours++;
                            neighbour = new NotEmptyField(new Position((position.getRow() + 1),position.getColumn()));
                            direction = Direction.DOWN;
                        }else {
                            neighbour = new EmptyField(new Position(0, 0));
                        }
                    }else {
                        neighbour = new EmptyField(new Position(0, 0));
                    }
                }else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            }
            if (direction.equals(Direction.DOWN_RIGHT) || direction.equals(Direction.ALL)){
            if(position.getRow() != size.getLength() && position.getColumn() != size.getHeight()){

                if (playerMap.containsKey(new Position((position.getRow() + 1), (position.getColumn() + 1)))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() + 1), (position.getColumn() + 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position((position.getRow() + 1), (position.getColumn() + 1)));
                        direction = Direction.DOWN_RIGHT;
                    }else {
                        neighbour = new EmptyField(new Position(0, 0));
                    }
                } else {
                    neighbour = new EmptyField(new Position(0, 0));
                }
                }else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            }
            if (direction.equals(Direction.DOWN_LEFT) || direction.equals(Direction.ALL)){
            if (position.getRow() != size.getLength() && position.getColumn() != 0){

                if (playerMap.containsKey(new Position((position.getRow() + 1), (position.getColumn() - 1)))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() + 1), (position.getColumn() - 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position((position.getRow() + 1), (position.getColumn() - 1)));
                        direction = Direction.DOWN_LEFT;
                    }else {
                        neighbour = new EmptyField(new Position(0, 0));
                    }
                } else {
                    neighbour = new EmptyField(new Position(0, 0));
                }
                }else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            }
            if (direction.equals(Direction.RIGHT) || direction.equals(Direction.ALL)){
            if (position.getColumn() != size.getHeight()){

                if (playerMap.containsKey(new Position(position.getRow(), (position.getColumn() + 1)))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position(position.getRow(), (position.getColumn() + 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position(position.getRow(), (position.getColumn() + 1)));
                        direction = Direction.RIGHT;
                    }else {
                        neighbour = new EmptyField(new Position(0, 0));
                    }
                } else {
                    neighbour = new EmptyField(new Position(0, 0));
                }
                }else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            }
            if (direction.equals(Direction.LEFT) || direction.equals(Direction.ALL)){
            if (position.getColumn() != 0){

                if (playerMap.containsKey(new Position(position.getRow(), (position.getColumn() - 1)))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position(position.getRow(), (position.getColumn() - 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position(position.getRow(), (position.getColumn() - 1)));
                        direction = Direction.LEFT;
                    }else {
                        neighbour = new EmptyField(new Position(0, 0));
                    }
                } else {
                    neighbour = new EmptyField(new Position(0, 0));
                }
                }else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            }
            if (direction.equals(Direction.UP) || direction.equals(Direction.ALL)){
            if (position.getRow() != 0){

                if (playerMap.containsKey(new Position((position.getRow() - 1), position.getColumn()))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() - 1), position.getColumn())), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position((position.getRow() - 1), position.getColumn()));
                        direction = Direction.UP;
                    }else {
                        neighbour = new EmptyField(new Position(0, 0));
                    }
                } else {
                    neighbour = new EmptyField(new Position(0, 0));
                }
                }else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            }
            if (direction.equals(Direction.UP_RIGHT) || direction.equals(Direction.ALL)){
            if (position.getRow() != 0 && position.getColumn() != size.getHeight()){

                if (playerMap.containsKey(new Position((position.getRow() - 1), (position.getColumn() + 1)))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() - 1), (position.getColumn() + 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position((position.getRow() - 1), (position.getColumn() + 1)));
                        direction = Direction.UP_RIGHT;
                    }else {
                        neighbour = new EmptyField(new Position(0, 0));
                    }
                } else {
                    neighbour = new EmptyField(new Position(0, 0));
                }
                }else {
                neighbour = new EmptyField(new Position(0, 0));
            }
            }
            if (direction.equals(Direction.UP_LEFT) || direction.equals(Direction.ALL)){
                if (position.getRow() != 0 && position.getColumn() != 0){
                if (playerMap.containsKey(new Position((position.getRow() - 1), (position.getColumn() - 1)))) {
                    if (!isOtherPlayerField(field, new NotEmptyField(new Position((position.getRow() - 1), (position.getColumn() - 1))), positions)) {
                        hasNeighbour = true;
                        neighbours++;
                        neighbour = new NotEmptyField(new Position((position.getRow() - 1), (position.getColumn() - 1)));
                        direction = Direction.UP_LEFT;
                    }else {
                        neighbour = new EmptyField(new Position(0, 0));
                    }
                } else {
                    neighbour = new EmptyField(new Position(0, 0));
                }
                }else {
                    neighbour = new EmptyField(new Position(0, 0));
                }
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

    public boolean foundSequence(Field field, Positions positions) {
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
        } else{
            if (!checkOnce){
                checkOnce = true;
                return checkOtherDirection(lastOne, positions);
            }
        }
        direction = Direction.ALL;
        checkOnce = false;
        return false;
    }

    private boolean checkOtherDirection(Field field, Positions positions){
        Direction currentDirection = direction;
        switch (currentDirection){
            case UP:
                direction = Direction.DOWN;
                return foundSequence(field, positions);
            case DOWN:
                direction = Direction.UP;
                return foundSequence(field, positions);
            case LEFT:
                direction = Direction.RIGHT;
                return foundSequence(field, positions);
            case RIGHT:
                direction = Direction.LEFT;
                return foundSequence(field, positions);
            case UP_LEFT:
                direction = Direction.DOWN_RIGHT;
                return foundSequence(field, positions);
            case UP_RIGHT:
                direction = Direction.DOWN_LEFT;
                return foundSequence(field, positions);
            case DOWN_LEFT:
                direction = Direction.UP_RIGHT;
                return foundSequence(field, positions);
            case DOWN_RIGHT:
                direction = Direction.UP_LEFT;
                return foundSequence(field, positions);
            default:
                return false;
        }
    }

    public boolean checkIfWinRound(Player winner) {
        if (winner.checkPoints() %3 == 0){
            return true;
        }
        return false;
    }
}
