package com.firm.OX;

import java.io.File;
import java.io.FileNotFoundException;

public class MainFromFile {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Olka\\Desktop\\3_3_3.txt");
        try{
            GameFromFile ticTacToe = new GameFromFile(file);
            ticTacToe.setGameOptions();
            ticTacToe.startGame();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
