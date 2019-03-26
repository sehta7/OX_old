package com.firm.OX;

import java.util.Scanner;

/**
 * Reads data form console
 *
 * @author Ola Podorska
 */
class InputReader implements Reader {

    private Scanner sc;
    private Displayer displayer;
    private boolean end;

    InputReader(Scanner scanner, Displayer displayer) {
        this.sc = scanner;
        this.displayer = displayer;
    }

    String readLanguage() throws LanguageException{
        String lang = askAgainLang();
        if (!lang.equals("pl") && !lang.equals("en")){
            throw new LanguageException("Choose only available languages");
        }
        return lang;
    }

    private String askAgainLang() {
        while (true) {
            try {
                return sc.nextLine();
            } catch (NumberFormatException e) {
                displayer.displayLanguageError();
            }
        }
    }

    public Size readSize() throws BoardSizeException {
        int length = askAgain();
        int height = askAgain();
        if (length < 3 || height < 3) {
            throw new BoardSizeException("Board must have size greater than 3x3");
        }
        Size newSize = new Size(length, height);
        return newSize;
    }

    private int askAgain() {
        while (true) {
            try {
                String num = sc.next();
                if (num.equals("")){
                    num = sc.next();
                }
                return Integer.parseInt(num);
            } catch (NumberFormatException e) {
                displayer.displayNumberError();
            }
        }
    }


    public Player readPlayer() {
        String name = sc.nextLine();
        Player startingPlayer = new Player(name, new InputReader(sc, displayer));
        return startingPlayer;
    }

    public int readNumberOfCharacters() {
        int numberOfCharacters = askAgain();
        if (numberOfCharacters < 3) {
            throw new CharactersNumberException("Winning characters must be greater than 3");
        }
        return numberOfCharacters;
    }

    public Position readPosition() {
        String readEnd = readEnd();
        if (end){
            return new Position("end of game");
        } else{
            int column = Integer.parseInt(readEnd);
            int row = askAgain();
            Position position = new Position(row, column);
            return position;
        }
    }

    String readEnd(){
        String isEnd = sc.next();
        if (isEnd.toLowerCase().equals("q")) {
            end = true;
            return "end";
        }
        return isEnd;
    }
}
