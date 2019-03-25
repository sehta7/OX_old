package com.firm.OX;

import java.util.InputMismatchException;
import java.util.MissingResourceException;
import java.util.Scanner;

/**
 * Reads data form console
 *
 * @author Ola Podorska
 */
class InputReader implements Reader {

    private Scanner sc;

    InputReader(Scanner scanner) {
        this.sc = scanner;
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
                System.err.println("Choose only available languages");
            }
        }
    }

    public Size readSize() throws BoardSizeException {
        int length = askAgain(), height = askAgain();
        if (length < 3 || height < 3) {
            throw new BoardSizeException("Board must have size greater than 3x3");
        }
        Size newSize = new Size(length, height);
        return newSize;
    }

    private int askAgain() {
        while (true) {
            try {
                String len = sc.nextLine();
                String h = sc.nextLine();
                int length = Integer.parseInt(len);
                int height = Integer.parseInt(h);
            } catch (NumberFormatException e) {
                System.err.println("Give number!");
            }
        }
    }


    public Player readPlayer() {
        String name = sc.nextLine();
        Player startingPlayer = new Player(name, new InputReader(sc));
        return startingPlayer;
    }

    public int readNumberOfCharacters() {
        int numberOfCharacters = sc.nextInt();
        if (numberOfCharacters < 3) {
            throw new CharactersNumberException("Winning characters must be greater than 3");
        }
        return numberOfCharacters;
    }

    public Position readPosition() {
        String whatIsThat = sc.next();
        if (whatIsThat.toLowerCase().equals("q")) {
            return new Position("end of game");
        } else {
            int column = Integer.valueOf(whatIsThat);
            int row = sc.nextInt();
            Position position = new Position(row, column);
            return position;
        }
    }
}
