package com.firm.OX;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Create all wining positions vertically
 *
 * @author Ola Podorska
 */
class AutomatCreatorVertically implements AutomatCreator {

    @Override
    public void createFile(int length, int height, int winningCharacters) {
        File file = new File("C:\\Users\\Olka\\Desktop\\4_4_3_h.txt");
        try(FileWriter fr = new FileWriter(file)){
            List<Position> allAvailablePositions = availableFields(length, height);
            List<List<Position>> winningPositions = winning(allAvailablePositions, height, winningCharacters, length);
            for (List<Position> winning: winningPositions
            ) {
                allAvailablePositions = availableFields(length, height);
                List<Position> positionsWithoutWinning = positionsWithoutWinning(allAvailablePositions, winning);
                while (!winning.isEmpty()) {
                    fr.write(String.valueOf(winning.get(0).getRow()));
                    fr.write(System.getProperty("line.separator"));
                    fr.write(String.valueOf(winning.get(0).getColumn()));
                    fr.write(System.getProperty("line.separator"));
                    //System.out.println(winning.get(0));
                    winning.remove(0);
                    if (!winning.isEmpty()){
                        Position randomMove = randomMove(positionsWithoutWinning);
                        fr.write(String.valueOf(randomMove.getRow()));
                        fr.write(System.getProperty("line.separator"));
                        fr.write(String.valueOf(randomMove.getColumn()));
                        fr.write(System.getProperty("line.separator"));
                        //System.out.println(randomMove(positionsWithoutWinning));
                    }
                }
            }
        } catch (IOException e){

        }
    }

    List<Position> availableFields(int length, int height) {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                positions.add(new Position(i, j));
            }
        }
        return positions;
    }

    List<List<Position>> winning(List<Position> availablePositions, int height, int winningCharacters, int length) {
        List<Position> winning = new ArrayList<>();
        List<List<Position>> allWinings = new ArrayList<>();
        for (Position position : availablePositions
        ) {
            if (hasEnoughNext(position, winningCharacters, height)) {
                winning = addPositions(position, winningCharacters, availablePositions);
            }
            if (hasEnoughNext(position, winningCharacters, height)) {
                allWinings.add(winning);
            }
        }
        return allWinings;
    }

    private List<Position> addPositions(Position position, int winningCharacters, List<Position> availablePositions) {
        List<Position> winning = new ArrayList<>();
        int index = availablePositions.indexOf(position);
        for (int i = index; i < index + winningCharacters; i++) {
            winning.add(availablePositions.get(i));
        }
        return winning;
    }

    boolean hasEnoughNext(Position position, int winningCharacters, int height) {
        return (height > (position.getColumn() + winningCharacters - 1));
    }

    Position randomMove(List<Position> positions) {
        Random random = new Random();
        return positions.remove(random.nextInt(positions.size()));
    }

    List<Position> positionsWithoutWinning(List<Position> positions, List<Position> winningPositions) {
        for (Position winningPosition : winningPositions
        ) {
            positions.remove(winningPosition);
        }
        return positions;
    }

    public static void main(String[] args) {
        AutomatCreator creator = new AutomatCreatorVertically();
        creator.createFile(4, 4, 3);
    }
}
