package com.firm.OX;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *Reads data form file,
 * useful to auto game
 *
 * @author Ola Podorska
 */
class FromFileReader implements Reader {

    private GameOptions gameOptions;
    private File file;
    private BufferedReader bufferedReader;
    private Displayer displayer;

    FromFileReader(GameOptions gameOptions, File file, Displayer displayer) throws FileNotFoundException {
        this.gameOptions = gameOptions;
        this.file = file;
        bufferedReader = new BufferedReader(new FileReader(file));
        this.displayer = displayer;
    }

    void readOptions() {
        Player startingPlayer = readPlayer();
        gameOptions.start(startingPlayer);
        gameOptions.assignPlayers(startingPlayer, readPlayer());
        try {
            gameOptions.chosenSize(readSize());
        } catch (IOException e) {
            e.printStackTrace();
        }
        gameOptions.chosenCharacters(readNumberOfCharacters());
    }

    List<Position> readMoves() {
        List<Position> positions = new ArrayList<>();
        Position position;
        try {
            String r;
            while ((r = bufferedReader.readLine()) != null) {
                int column = Integer.parseInt(r);
                int row = Integer.parseInt(bufferedReader.readLine());
                position = new Position(row, column);
                positions.add(position);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return positions;
    }

    public Size readSize() throws IOException {
        int length = 0, height = 0;

        try {
            length = Integer.parseInt(bufferedReader.readLine());
            height = Integer.parseInt(bufferedReader.readLine());
            if (length < 3 || height < 3) {
                throw new BoardSizeException("Board must have size greater than 3x3");
            }
        } catch (InputMismatchException e) {
            System.out.println("Number please..");
            length = Integer.parseInt(bufferedReader.readLine());
            height = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Size size = new Size(length, height);
        return size;
    }

    public Player readPlayer() {
        String name = "";
        try {
            name = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Player startingPlayer = null;
        try {
            startingPlayer = new Player(name, new InputReader(new Scanner(file), displayer));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return startingPlayer;
    }

    public int readNumberOfCharacters() {
        int numberOfCharacters = 0;
        try {
            numberOfCharacters = Integer.parseInt(bufferedReader.readLine());
            if (numberOfCharacters < 3) {
                throw new CharactersNumberException("Winning characters must be greater than 3");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numberOfCharacters;
    }

    public Position readPosition() {
        int column = 0, row = 0;
        try {
            column = Integer.parseInt(bufferedReader.readLine());
            row = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Position position = new Position(row, column);
        return position;
    }
}
