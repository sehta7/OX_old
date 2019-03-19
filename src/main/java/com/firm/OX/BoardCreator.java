package com.firm.OX;

import java.util.Collections;

public class BoardCreator {

    public boolean drawEmptyGrid() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 2; j++){
                String repeated = String.join("", Collections.nCopies(5, " "));
                System.out.print(repeated);
                System.out.print("|");
                System.out.print(repeated);
                System.out.println("|");
            }
            if (i == 2){
                break;
            }
            System.out.println(String.join("", Collections.nCopies(17, "-")));
        }
        return true;
    }

    public boolean drawGridWithCoordinates() {

        int n = 10;
        int x = 0;
        System.out.print(" ");
        for (int i = 0; i < n; i++){
            System.out.print("    " + i + " ");
        }
        System.out.println();
        for (int j = 0 ; j < n; j++){
            String pause = "_____ ";
            String place = "|     ";
            String placeWithCoordinates = "|     ";
            System.out.print("   ");
            System.out.println(String.join("", Collections.nCopies(n, pause)));
            System.out.print("  ");
            System.out.print(String.join("", Collections.nCopies(n, place)));
            System.out.println("|");
            if (x < n){
                System.out.print(x++ + " ");
            }
            System.out.print(String.join("", Collections.nCopies(n, placeWithCoordinates)));
            System.out.println("|");
            System.out.print("  ");
            System.out.print(String.join("", Collections.nCopies(n, place)));
            System.out.println("|");
        }

        String pause = "----- ";
        System.out.print("   ");
        System.out.println(String.join("", Collections.nCopies(n, pause)));

        return true;
    }
}
