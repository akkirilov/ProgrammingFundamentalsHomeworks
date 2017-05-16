package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long totalBeers = 0;

        String[] tokens = scanner.nextLine().split("\\s+");
        while (!tokens[0].equals("End")){
            if (tokens[1].equals("stacks")) {
                totalBeers += (Long.parseLong(tokens[0]) * 20);
            }
            else {
                totalBeers += Long.parseLong(tokens[0]);
            }

            tokens = scanner.nextLine().split("\\s+");
        }

        System.out.printf("%d stacks + %d beers", totalBeers / 20, totalBeers % 20);
    }
}