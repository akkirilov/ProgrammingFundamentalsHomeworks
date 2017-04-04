package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberInDec = scanner.nextInt();

        System.out.println(convertInHex(numberInDec));
        System.out.println(convertInBin(numberInDec));
    }

    public static String convertInHex(int num) {
        return Integer.toString(num,16).toUpperCase();
    }

    public static String convertInBin(int num) {
        return Integer.toString(num,2);
    }
}