package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);

        if (Character.isDigit(input)){
            System.out.print("digit");
        } else if (isVowel(input)) {
            System.out.print("vowel");
        } else {
            System.out.print("other");
        }
    }

    public static boolean isVowel(char ch) {
        return "AEYIOUaeyiou".indexOf(ch) != -1;
    }
}