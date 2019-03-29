package com.firm.OX;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Create all wining positions vertically
 *
 * @author Ola Podorska
 */
class AutomatCreatorDiagonally implements AutomatCreator {

    @Override
    public void createFile(int length, int height, int winningCharacters) {
        String name = "/home/ola/Desktop/" + length + "_" + height + "_" + winningCharacters + "_v.txt";
        File file = new File(name);
        try(FileWriter fr = new FileWriter(file)){
            fr.write("player1");
            fr.write(System.getProperty("line.separator"));
            fr.write("player2");
            fr.write(System.getProperty("line.separator"));
            fr.write(String.valueOf(length));
            fr.write(System.getProperty("line.separator"));
            fr.write(String.valueOf(height));
            fr.write(System.getProperty("line.separator"));
            fr.write(String.valueOf(winningCharacters));
            fr.write(System.getProperty("line.separator"));
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
                    winning.remove(0);
                    if (!winning.isEmpty()){
                        Position randomMove = randomMove(positionsWithoutWinning);
                        fr.write(String.valueOf(randomMove.getRow()));
                        fr.write(System.getProperty("line.separator"));
                        fr.write(String.valueOf(randomMove.getColumn()));
                        fr.write(System.getProperty("line.separator"));
                    }
                }
            }
        } catch (IOException e){

        }
    }

    private List<Position> availableFields(int length, int height) {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                positions.add(new Position(j, i));
            }
        }
        return positions;
    }

    private List<List<Position>> winning(List<Position> availablePositions, int height, int winningCharacters, int length) {
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

    private boolean hasEnoughNext(Position position, int winningCharacters, int height) {
        return (height > (position.getRow() + winningCharacters - 1));
    }

    private Position randomMove(List<Position> positions) {
        Random random = new Random();
        return positions.remove(random.nextInt(positions.size()));
    }

    private List<Position> positionsWithoutWinning(List<Position> positions, List<Position> winningPositions) {
        for (Position winningPosition : winningPositions
        ) {
            positions.remove(winningPosition);
        }
        return positions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int height = sc.nextInt();
        int winningCharacters = sc.nextInt();
        AutomatCreator creator = new AutomatCreatorDiagonally();
        creator.createFile(length, height, winningCharacters);
    }
}
