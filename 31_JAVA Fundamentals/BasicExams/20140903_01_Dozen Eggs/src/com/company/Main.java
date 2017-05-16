package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dozens = 0;
        int eggs = 0;

        for (int i = 0; i < 7; i++) {
            int currEggs = scanner.nextInt();
            String type = scanner.next();
            if (type.equals("dozens")) {
                dozens += currEggs;
            }
            else {
                eggs += currEggs;
                if (eggs >= 12) {
                    dozens += eggs / 12;
                    eggs %= 12;
                }
            }
        }

        System.out.printf("%d dozens + %d eggs", dozens, eggs);
    }
}