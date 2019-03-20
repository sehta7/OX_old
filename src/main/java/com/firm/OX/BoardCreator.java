package com.firm.OX;

import java.util.Collections;
import java.util.Queue;

public class BoardCreator {

    public boolean drawGridWithCoordinates(Size size) {

        int x = 0;
        System.out.print(" ");
        for (int i = 0; i < size.getLength(); i++){
            System.out.print("    " + i + " ");
        }
        System.out.println();
        for (int j = 0 ; j < size.getHeight(); j++){
            String pause = "_____ ";
            String place = "|     ";
            String placeWithCoordinates = "|     ";
            System.out.print("   ");
            System.out.println(String.join("", Collections.nCopies(size.getLength(), pause)));
            System.out.print("  ");
            System.out.print(String.join("", Collections.nCopies(size.getLength(), place)));
            System.out.println("|");
            if (x < size.getHeight()){
                System.out.print(x++ + " ");
            }
            System.out.print(String.join("", Collections.nCopies(size.getLength(), placeWithCoordinates)));
            System.out.println("|");
            System.out.print("  ");
            System.out.print(String.join("", Collections.nCopies(size.getLength(), place)));
            System.out.println("|");
        }

        String pause = "----- ";
        System.out.print("   ");
        System.out.println(String.join("", Collections.nCopies(size.getLength(), pause)));

        return true;
    }

    public boolean drawGridWithGivenPosition(Position position) {
        int n = position.getRow(), m = position.getColumn(), x = 60;
        drawHeader(m);
        for (int i = 0; i < x; i ++){
            for (int j = 0; j < x; j++){

                if (j == 0){
                    System.out.print(i + " ");
                }
                if (i == n && j == m){
                    System.out.print("|  O  ");
                }else{
                    System.out.print("|     ");
                }
            }
            System.out.println("|");
            System.out.print("  ");
            String pause = " _____";
            System.out.println(String.join("", Collections.nCopies(x, pause)));
        }
        return true;
    }

    public void drawHeader(int n){
        System.out.print(" ");
        for (int i = 0; i < n; i++){
            if (i < 10){
                System.out.print("    " + i + " ");
            } else{
                System.out.print("   " + i  + " ");
            }

        }
        System.out.println();
    }

    public boolean drawGridWithGivenPositionAnSize(Position position, Size size) {
        int n = position.getRow(), m = position.getColumn(), x = size.getHeight(), y = size.getLength();
        drawHeader(y);
        for (int i = 0; i < x; i ++){
            for (int j = 0; j < y; j++){

                if (j == 0){
                    System.out.print(i + " ");
                }
                if (i == n && j == m){
                    System.out.print("|  O  ");
                }else{
                    System.out.print("|     ");
                }
            }
            System.out.println("|");
            System.out.print("  ");
            String pause = " _____";
            System.out.println(String.join("", Collections.nCopies(y, pause)));
        }
        return true;
    }

    public boolean drawGridWithGivenPositionsAnSize(Queue<Position> positions, Size size) {
        int height = size.getHeight(), length = size.getLength(), row, column;
        drawHeader(length);
        Position position = positions.remove();
        for (int y = 0; y < height; y ++){
            for (int x = 0; x < length; x++){
                row = position.getRow();
                column = position.getColumn();
                if (x == 0){
                    System.out.print(y + " ");
                }
                if (y == row && x == column){
                    System.out.print("|  O  ");
                    if (!positions.isEmpty()) {
                        position = positions.remove();
                    }
                }else{
                    System.out.print("|     ");
                }
            }
            System.out.println("|");
            System.out.print("  ");
            String pause = " _____";
            System.out.println(String.join("", Collections.nCopies(length, pause)));
        }

        return true;
    }
}
