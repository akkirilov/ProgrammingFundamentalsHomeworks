package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sides = Arrays.stream(scanner.nextLine().split("\\D+"))
                .filter(x -> !x.isEmpty())
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < sides.length; i += 2) {
            areas.add(sides[i] * sides[i + 1]);
        }

        int sum;
        int bestSum = -1;

        for (int i = 0; i < areas.size() - 2; i++) {
            sum = areas.get(i) + areas.get(i + 1) + areas.get(i + 2);
            if (sum > bestSum) {
                bestSum = sum;
            }

            sum = 0;
        }

        System.out.println(bestSum);
    }
}