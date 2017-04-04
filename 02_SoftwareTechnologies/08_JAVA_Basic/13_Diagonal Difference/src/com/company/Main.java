package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int param = Integer.parseInt(scanner.nextLine());
        int[][]matrix = new int[param][param];


        for (int r = 0; r < param; r++){
            String[] strArr = scanner.nextLine().split("\\s+");
            for(int c = 0; c < param; c++){
                matrix[r][c] = Integer.parseInt(strArr[c]);
            }
        }

        int first = 0;
        int second = 0;

        for (int i = 0; 0 < param; i++){
            param--;
            first += matrix[i][i];
            second += matrix[i][param];
        }

        System.out.println(Math.abs(first - second));
    }
}