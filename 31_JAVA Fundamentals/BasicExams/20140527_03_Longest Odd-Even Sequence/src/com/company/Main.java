package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("[)(\\s]+"))
                .filter(x -> !x.isEmpty())
                .mapToInt(Integer::parseInt)
                .map(Math::abs)
                .toArray();

        int check = numbers[0] % 2;
        if (numbers[0] == 0) {
            check = numbers[1] % 2;
        }

        int count = 0;
        int bestCount = count;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == check % 2) {
                check++;
                count++;
            }
            else if (numbers[i] == 0){
                count++;
                if (i != 0) {
                    check++;
                }
            }
            else {
                if (count > bestCount) {
                    bestCount = count;
                }
                count = 0;

                check = numbers[i] % 2;
                i--;
            }
        }

        if (count > bestCount) {
            bestCount = count;
        }

        System.out.printf("%d", bestCount);
    }
}