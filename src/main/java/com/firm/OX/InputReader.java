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
        Size size = new Size(length, height);
        return size;
    }


}
