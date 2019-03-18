package com.firm.OX;

import java.util.Collections;

public class BoardCreator {

    public boolean drawEmptyGrid() {
        for (int y = 0; y < 3; y++){
            for (int i = 0; i < 2; i++){
                String repeated = String.join("", Collections.nCopies(5, " "));
                System.out.print(repeated);
                System.out.print("|");
                System.out.print(repeated);
                System.out.println("|");
            }
            if (y == 2){
                break;
            }
            System.out.println(String.join("", Collections.nCopies(17, "-")));
        }
        return true;
    }
}
