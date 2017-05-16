package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character[] hand = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(x -> x.charAt(0))
                .toArray(Character[]::new);

        if (hand.length == 1) {
            System.out.println(getCardValue(hand[0]));
            return;
        }

        int nextValue = 0;
        int lastValue = -1;
        int result = 0;

        for (int i = 0; i < hand.length - 1; i++) {
            int cardValue = getCardValue(hand[i]);
            nextValue = getCardValue(hand[i + 1]);

            result += cardValue;
            if (cardValue == lastValue || cardValue == nextValue) {
                result += cardValue;
            }

            lastValue = cardValue;
        }

        result += nextValue;
        if (lastValue == nextValue) {
            result += nextValue;
        }

        System.out.printf("%d", result);
    }
    
    private static Integer getCardValue(Character ch){
        switch (ch){
            case '1':
                return 10;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'J':
                return 12;
            case 'Q':
                return 13;
            case 'K':
                return 14;
            case 'A':
                return 15;
            default:
                return 0;
        }
    }
}