package com.firm.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
public class InputReader implements Reader{

    private Scanner sc;

    public InputReader(Scanner scanner) {
        this.sc = scanner;
    }

    String readLanguage(){
        return sc.nextLine();
    }

    public Size readSize() {
        int length = sc.nextInt();
        int height = sc.nextInt();
        if (length < 3 || height < 3){
            throw new IllegalArgumentException();
        }
        Size size = new Size(length, height);
        return size;
    }


    public Player readPlayer() {
        String name = sc.nextLine();
        Player startingPlayer = new Player(name, new InputReader(sc));
        return startingPlayer;
    }

    public int readNumberOfCharacters() {
        int numberOfCharacters = sc.nextInt();
        if (numberOfCharacters < 3){
            throw new IllegalArgumentException();
        }
        return numberOfCharacters;
    }

    public Position readPosition(){
        String whatIsThat = sc.next();
        if (whatIsThat.toLowerCase().equals("q")){
            return new Position("end of game");
        } else{
            int column = Integer.valueOf(whatIsThat);
            int row = sc.nextInt();
            Position position = new Position(row, column);
            return position;
        }
    }
}
