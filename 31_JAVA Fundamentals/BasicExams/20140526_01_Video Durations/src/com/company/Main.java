package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    String[] tokens = scanner.nextLine().split(":");

        long totalMinutes = 0;
	    while (!tokens[0].equals("End")){
	        totalMinutes += (Integer.parseInt(tokens[0]) * 60) + Integer.parseInt(tokens[1]);

	        tokens = scanner.nextLine().split(":");
        }

        System.out.printf("%d:%02d", totalMinutes / 60, totalMinutes % 60);
    }
}