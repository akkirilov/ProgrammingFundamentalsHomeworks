package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(x -> !x.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isFound = false;
        for (int a = 0; a < numbers.length; a++) {
            for (int b = 0; b < numbers.length; b++) {
                if (numbers[a] == numbers[b]) {
                    continue;
                }

                String ab = numbers[a] + "" + numbers[b];

                for (int c = 0; c < numbers.length; c++) {
                    for (int d = 0; d < numbers.length; d++) {
                        if (numbers[a] == numbers[c] || numbers[a] == numbers[d] ||
                                numbers[b] == numbers[c] || numbers[b] == numbers[d] ||
                                numbers[c] == numbers[d]) {
                            continue;
                        }

                        String cd = numbers[c] + "" + numbers[d];

                        if (ab.equals(cd)) {
                            isFound = true;
                            System.out.printf("%d|%d==%d|%d%n", numbers[a], numbers[b], numbers[c], numbers[d]);
                        }
                    }
                }
            }
        }

        if (!isFound) {
            System.out.println("No");
        }
    }
}