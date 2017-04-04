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

        int number = numArr[0];
        int frequency = 0;
        int bestFrequency = 0;

        for (int i = 0; i < numArr.length; i++){
            for (int j = i; j < numArr.length; j++){
                if(numArr[i] == numArr[j]){
                    frequency++;
                }
            }

            if(frequency > bestFrequency){
                number = numArr[i];
                bestFrequency = frequency;
            }

            frequency = 0;
        }

        System.out.println(number);
    }
}