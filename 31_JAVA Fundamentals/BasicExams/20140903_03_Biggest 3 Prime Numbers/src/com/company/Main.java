package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("[()\\s]"))
                .filter(x -> !x.isEmpty())
                .map(Integer::parseInt)
                .distinct()
                .filter(Main::isPrime)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (numbers.size() < 3){
            System.out.println("No");
            return;
        }

        System.out.println(numbers.get(0) + numbers.get(1) + numbers.get(2));
    }

    private static boolean isPrime(int token) {
        if (token < 2) {
            return false;
        }

        for (int i = 2; i < token; i++) {
            if(token % i == 0){
                return false;
            }
        }

        return true;
    }
}