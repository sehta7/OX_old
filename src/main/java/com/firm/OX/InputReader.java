package com.firm.OX;

import java.util.Scanner;

/**
 * Reads data form console
 *
 * @author Ola Podorska
 */
class InputReader implements Reader{

    private Scanner sc;

    InputReader(Scanner scanner) {
        this.sc = scanner;
    }

    String readLanguage(){
        return sc.nextLine();
    }

    public Size readSize() throws BoardSizeException{
        int length = sc.nextInt();
        int height = sc.nextInt();
        if (length < 3 || height < 3){
            throw new BoardSizeException("Board must have size greater than 3x3");
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
            throw new CharactersNumberException("Winning characters must be greater than 3");
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
