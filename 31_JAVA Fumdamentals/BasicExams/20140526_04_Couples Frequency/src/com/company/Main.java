package com.company;

        import java.util.Arrays;
        import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(x -> !x.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<String, Integer> pairs = new LinkedHashMap<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            String key = numbers[i] + " " + numbers[i + 1];
            if (pairs.containsKey(key)) {
                pairs.put(key, pairs.get(key) + 1);
            }
            else {
                pairs.put(key, 1);
            }
        }

        if (!pairs.isEmpty()) {
            double totalPairs = (double)numbers.length - 1;
            for (Map.Entry<String, Integer> entry : pairs.entrySet()) {
                System.out.printf("%s -> %.2f%%%n", entry.getKey(),
                        (((double)entry.getValue() / totalPairs) * 100.0));
            }
        }
        else {
            System.out.println("There are no pairs!!!");
        }
    }
}