package com.firm.OX;

import java.util.Collections;

class BoardDrawer {

    private Size size;

    BoardDrawer(Size sizeOfBoard) {
        size = sizeOfBoard;
    }

    boolean drawGridWithCoordinates() {
        int x = 0;
        System.out.print(" ");
        for (int i = 0; i < size.getLength(); i++){
            if (i < 10){
                System.out.print("    " + i + " ");
            } else{
                System.out.print("   " + i + " ");
            }

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
                if (x < 10){
                    System.out.print(x++ + " ");
                } else{
                    System.out.print(x++ + "");
                }

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

    boolean drawGridWithGivenPosition(Position position) {
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

    private void drawHeader(int n){
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

    boolean drawGridWithGivenPositionAnSize(Position position) {
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

    boolean drawGridWithGivenPositions(Positions positions) {
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