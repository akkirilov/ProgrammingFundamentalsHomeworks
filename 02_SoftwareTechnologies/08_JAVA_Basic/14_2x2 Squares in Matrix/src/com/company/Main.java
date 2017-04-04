package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strArr = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(strArr[0]);
        int col = Integer.parseInt(strArr[1]);

        char[][]matrix = new char[row][col];

        for (int r = 0; r < row; r++){
            strArr = scanner.nextLine().split("\\s+");
            for(int c = 0; c < col; c++){
                matrix[r][c] = strArr[c].charAt(0);
            }
        }

        int count = 0;
        for(int r = 0; r < row - 1; r++){
            for(int c = 0; c < col - 1; c++){
                if(matrix[r][c] == matrix[r][c + 1]
                        && matrix[r + 1][c] == matrix[r + 1][c + 1]
                        && matrix[r][c] == matrix[r + 1][c + 1]){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}