package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] chars = new char[3];
        for (int i = 0; i < 3; i++ ){
            chars[i] = scanner.nextLine().charAt(0);
        }

        for (int i = 2; i >= 0; i--){
            System.out.print(chars[i]);
        }
    }
}