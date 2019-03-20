package com.firm.OX;

import java.util.Scanner;

/**
 * @author Ola Podorska
 */
public class InputReader {

    public Size readSize() {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int height = sc.nextInt();
        if (length < 3 || height < 3){
            throw new IllegalArgumentException();
        }
        Size size = new Size(length, height);
        return size;
    }


    public Player readStartingPlayer() {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Player startingPlayer = new Player(name);
        return startingPlayer;
    }

    public int readNumberOfCharacters() {
        Scanner sc = new Scanner(System.in);
        int numberOfCharacters = sc.nextInt();
        return numberOfCharacters;
    }
}
