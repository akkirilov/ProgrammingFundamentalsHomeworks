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

        int start = 0;
        int len = 1;
        int bestLen = 1;

        for(int i = 1; i < numArr.length; i++){
            if(numArr[i-1] == numArr[i]){
                len++;
            }  else  {
                if(len > bestLen){
                    start = i - len;
                    bestLen = len;
                }
                len = 1;
            }
            if(i == numArr.length - 1){
                if(len > bestLen){
                    start = i - len + 1;
                    bestLen = len;
                }
            }
        }

        for (int i = start; i < start + bestLen; i++){
            System.out.print(numArr[i] + " ");
        }
    }
}