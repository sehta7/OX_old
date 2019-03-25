package com.firm.OX;

import java.util.Collections;
import java.util.Map;

/**
 * Draws board with given size
 *
 * @author Ola Podorska
 */
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

    private void drawHeader(int n, StringBuilder stringBuilder){
        System.out.print(" ");
        stringBuilder.append(" ");
        for (int i = 0; i < n; i++){
            if (i < 10){
                System.out.print("    " + i + " ");
                stringBuilder.append("    " + i + " ");
            } else{
                System.out.print("   " + i  + " ");
                stringBuilder.append("   " + i  + " ");
            }
        }
        System.out.println();
        stringBuilder.append(System.getProperty("line.separator"));
    }

    String drawGridWithGivenPositions(Positions mainPositions) {
        StringBuilder stringBuilder = new StringBuilder();
        Positions positions = mainPositions.copyPositions();
        int height = size.getHeight(), length = size.getLength(), row, column;
        drawHeader(length, stringBuilder);
        Position position = positions.remove();
        Map<Position, Player> playerMap = mainPositions.findPlayerPositions();
        for (int y = 0; y < height; y ++){
            for (int x = 0; x < length; x++){
                Player player = playerMap.get(position);
                row = position.getRow();
                column = position.getColumn();
                if (x == 0){
                    System.out.print(y + " ");
                    stringBuilder.append(y + " ");
                }
                if (y == row && x == column){
                    if (player.isNaught()){
                        System.out.print("|  O  ");
                        stringBuilder.append("|  O  ");
                    } else{
                        System.out.print("|  X  ");
                        stringBuilder.append("|  X  ");
                    }
                    if (!positions.isEmpty()) {
                        position = positions.remove();
                    }
                }else{
                    System.out.print("|     ");
                    stringBuilder.append("|     ");
                }
            }
            System.out.println("|");
            stringBuilder.append(System.getProperty("line.separator"));
            System.out.print("  ");
            stringBuilder.append(" ");
            String pause = " _____";
            System.out.println(String.join("", Collections.nCopies(length, pause)));
            stringBuilder.append(String.join("", Collections.nCopies(length, pause)));
            stringBuilder.append(System.getProperty("line.separator"));
        }


        return stringBuilder.toString();
    }
}
