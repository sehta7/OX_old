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

        int n = 3;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                String pause = "------";
                String place = "|     ";
                System.out.println(String.join("", Collections.nCopies(n, pause)));
                for (int x = 0; x < n; x++){
                    String coordinates = "|" + (i + x) + "," + (j + x) + "  ";
                    System.out.print(coordinates);
                }
                System.out.println();
                System.out.println(String.join("", Collections.nCopies(n, place)));
            }
        }
        return true;
    }
}
