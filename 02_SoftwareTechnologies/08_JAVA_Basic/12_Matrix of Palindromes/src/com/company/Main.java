package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArr = scanner.nextLine().split("\\s+");

        int[] numArr = new int[strArr.length];
        for(int i = 0; i < strArr.length; i++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        char main = 'a';
        for(int row = 0; row < numArr[0]; row++){
            char middle = main;
            for(int col = 0; col < numArr[1]; col++) {
                System.out.print(main + "" + middle + "" + main + ' ');
                middle++;
            }
            System.out.println();
            main++;
        }
    }
}