package com.company;

        import java.math.BigDecimal;
        import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<BigDecimal> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(new BigDecimal(scanner.nextLine()));
        }

        Collections.sort(numbers);
        for (int i = numbers.size() - 1; i >= Math.max(0, numbers.size() - 3) ; i--) {
            System.out.printf("%s%n", numbers.get(i).toPlainString());
        }
    }
}