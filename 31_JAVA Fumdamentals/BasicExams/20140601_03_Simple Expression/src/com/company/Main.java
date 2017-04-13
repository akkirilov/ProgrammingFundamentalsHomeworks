package com.company;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine()
                .replaceAll("\\s+", "")
                .toCharArray();

        String tempNum = "";

        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '-' && chars[i] != '+' && chars[i] != ' ') {
                tempNum += chars[i];
            }
            else {
                if (!tempNum.equals("")) {
                    sum = sum.add(new BigDecimal(tempNum));
                }

                tempNum = "" + chars[i];
            }
        }

        sum = sum.add(new BigDecimal(tempNum));
        System.out.printf("%.7f", sum);
    }
}