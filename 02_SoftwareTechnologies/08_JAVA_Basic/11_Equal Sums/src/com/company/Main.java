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

        if (numArr.length == 1){
            System.out.println(0);
            return;
        } else if (numArr.length == 2){
            System.out.println("no");
            return;
        }

        long left = 0;
        long right = 0;
        for(int i = 0; i < numArr.length; i++){
            left = 0;
            right = 0;
            for(int l = 0; l < i; l++){
                left += numArr[l];
            }
            for (int r = i + 1; r < numArr.length;r++){
                right += numArr[r];
            }

            if(left == right){
                System.out.println(i);
                return;
            }
        }

        System.out.println("no");
    }
}