package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] tokens = new int[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = scanner.nextInt();
        }

        boolean findSet = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if((tokens[i] + tokens[j] + tokens[k]) % 360 == 0){
                        System.out.printf("%d + %d + %d = %d degrees%n",
                                tokens[i],
                                tokens[j],
                                tokens[k],
                                (tokens[i] + tokens[j] + tokens[k]));

                        findSet = true;
                    }
                }
            }
        }

        if (!findSet) {
            System.out.println("No");
        }
    }
}