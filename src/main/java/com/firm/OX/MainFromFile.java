package com.firm.OX;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MainFromFile {

    public static void main(String[] args) {

        File all3 = new File("\\home\\ola\\Desktop\\3_3_3_h.txt");

        try (FileWriter fw = new FileWriter(all3)) {
            fw.write("player1");
            fw.write(System.getProperty("line.separator"));
            fw.write("player2");
            fw.write(System.getProperty("line.separator"));
            fw.write("4");
            fw.write(System.getProperty("line.separator"));
            fw.write("4");
            fw.write(System.getProperty("line.separator"));
            fw.write("3");
            fw.write(System.getProperty("line.separator"));

            int x = 0, y = 0, win = 8, charNum = 3;
            for (int num = 0; num < win; num++) {
                for (int move = 0; move < charNum; move++) {

                    fw.write(String.valueOf(x));
                    fw.write(System.getProperty("line.separator"));
                    fw.write(String.valueOf(y));
                    fw.write(System.getProperty("line.separator"));
                    if (x == 3){
                        if (y < 3) {
                            fw.write(String.valueOf(x - 1));
                            fw.write(System.getProperty("line.separator"));
                            fw.write(String.valueOf(y));
                            fw.write(System.getProperty("line.separator"));
                        }
                    } else{
                        if (y < 3) {
                            fw.write(String.valueOf(x + 1));
                            fw.write(System.getProperty("line.separator"));
                            fw.write(String.valueOf(y));
                            fw.write(System.getProperty("line.separator"));
                        }
                    }
                    y++;
                }
                y = 0;
                x++;
            }

        } catch (IOException e) {

        }

        File file = new File("\\home\\ola\\Desktop\\3_3_3_h.txt");
        try{
            GameFromFile ticTacToe = new GameFromFile(file);
            ticTacToe.setGameOptions();
            ticTacToe.startGame();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
