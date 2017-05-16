package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        Collections.sort(numbers);

        boolean isFound = false;
        for (int i = 0; i < numbers.size(); i++) {
            int a = numbers.get(i) * numbers.get(i);
            for (int j = i; j < numbers.size(); j++) {
                int b = numbers.get(j) * numbers.get(j);
                for (int k = j; k < numbers.size(); k++) {
                    int c = numbers.get(k) * numbers.get(k);
                    if (a + b == c) {
                        System.out.printf("%d*%d + %d*%d = %d*%d%n",
                                numbers.get(i),
                                numbers.get(i),
                                numbers.get(j),
                                numbers.get(j),
                                numbers.get(k),
                                numbers.get(k));
                        isFound = true;
                    }
                }
            }
        }

        if (!isFound) {
            System.out.println("No");
        }
    }
}