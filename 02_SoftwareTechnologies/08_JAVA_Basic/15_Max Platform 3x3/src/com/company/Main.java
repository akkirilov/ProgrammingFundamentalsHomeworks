package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strArr = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(strArr[0]);
        int col = Integer.parseInt(strArr[1]);

        long[][]matrix = new long[row][col];

        for (int r = 0; r < row; r++){
            strArr = scanner.nextLine().split("\\s+");
            for(int c = 0; c < col; c++){
                matrix[r][c] = Integer.parseInt(strArr[c]);
            }
        }

        long sum = 0;
        long bestSum = Long.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for(int r = 0; r <= row - 3; r++){
            for(int c = 0; c <= col - 3; c++){
                for(int rs = r; rs < r + 3; rs++){
                    for(int cs = c; cs < c + 3; cs++){
                        sum += matrix[rs][cs];
                    }
                }
                if(sum > bestSum){
                    bestSum = sum;
                    startRow = r;
                    startCol = c;
                }
                sum = 0;
            }
        }

        System.out.println(bestSum);
        for(int r = startRow; r < startRow + 3; r++){
            for(int c = startCol; c < startCol + 3; c++){
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}