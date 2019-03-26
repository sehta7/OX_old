package com.firm.OX;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainFromFile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int height = sc.nextInt();
        int winningCharacters = sc.nextInt();
        String name = "/home/ola/Desktop/" + length + "_" + height + "_" + winningCharacters + "_h.txt";

        File file = new File(name);
        try{
            GameFromFile ticTacToe = new GameFromFile(file);
            ticTacToe.setGameOptions();
            ticTacToe.startGame();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
