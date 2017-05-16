package com.company;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int star = n;
        int dot = 0;

        System.out.println(String.join("", Collections.nCopies(star, "*")));

        for (int i = 0; i < (n - 2) / 2 + 1; i++) {
            star -=2;
            dot++;

            System.out.print(String.join("", Collections.nCopies(dot, ".")));
            System.out.print(String.join("", Collections.nCopies(star, "*")));
            System.out.print(String.join("", Collections.nCopies(dot, ".")));
            System.out.println();
        }

        for (int i = 0; i < (n - 2) / 2; i++) {
            star+=2;
            dot--;

            System.out.print(String.join("", Collections.nCopies(dot, ".")));
            System.out.print(String.join("", Collections.nCopies(star, "*")));
            System.out.print(String.join("", Collections.nCopies(dot, ".")));
            System.out.println();
        }

        star+=2;
        System.out.println(String.join("", Collections.nCopies(star, "*")));
    }
}