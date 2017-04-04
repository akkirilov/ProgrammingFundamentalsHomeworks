package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] charArr1 = scanner.nextLine().toCharArray();
        char[] charArr2 = scanner.nextLine().toCharArray();

        int count = Math.min(charArr1.length, charArr2.length);

        for (int i = 0; i < count; i++){
            if (charArr1[i] < charArr2[i]){
                System.out.println(charArrayToString(charArr1));
                System.out.println(charArrayToString(charArr2));
                return;
            } else if (charArr1[i] > charArr2[i]){
                System.out.println(charArrayToString(charArr2));
                System.out.println(charArrayToString(charArr1));
                return;
            }
        }

        if (charArr1.length < charArr2.length) {
            System.out.println(charArrayToString(charArr1));
            System.out.println(charArrayToString(charArr2));
        } else {
            System.out.println(charArrayToString(charArr2));
            System.out.println(charArrayToString(charArr1));
        }
    }

    public static String charArrayToString(char[] charArr) {
        StringBuilder result = new StringBuilder();

        int count = charArr.length;
        for (int i = 0; i < count; i++){
            if (!Character.isSpaceChar(charArr[i])){
                result.append(charArr[i]);
            }
        }

        return result.toString();
    }
}