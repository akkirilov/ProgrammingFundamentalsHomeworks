package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int magicNum = scanner.nextInt() - 40;

        Map<Character,Integer> latins = new TreeMap()
        {{
            put('A', 10);
            put('B', 20);
            put('C', 30);
            put('E', 50);
            put('H', 80);
            put('K', 110);
            put('M', 130);
            put('P', 160);
            put('T', 200);
            put('X', 240);
        }};

        String pre = "CA";
        Set<String> allMagicNumbers = new HashSet<>();

        for (Map.Entry<Character, Integer> entry1:latins.entrySet()) {
            for (Map.Entry<Character, Integer> entry2:latins.entrySet()) {
                int reminder = magicNum - (entry1.getValue() + entry2.getValue());
                if (reminder <= 36 && reminder >= 0) {
                    String end = String.format("%c%c", entry1.getKey(), entry2.getKey());
                    for (int i = 9; i >= 0; i--) {
                        for (int j = 9; j >= 0; j--) {
                            if (reminder - i * 3 - j == 0) {
                                allMagicNumbers.add(pre + i + i + i + j + end);
                                allMagicNumbers.add(pre + j + i + i + i + end);
                            }
                            else if (reminder - j * 3 - i == 0){
                                allMagicNumbers.add(pre + j + j + j + i + end);
                                allMagicNumbers.add(pre + i + j + j + j + end);
                            }
                            else if (reminder - i * 2 - j * 2 == 0) {
                                allMagicNumbers.add(pre + i + i + j + j + end);
                                allMagicNumbers.add(pre + j + j + i + i + end);
                                allMagicNumbers.add(pre + j + i + j + i + end);
                                allMagicNumbers.add(pre + i + j + i + j + end);
                                allMagicNumbers.add(pre + i + j + j + i + end);
                                allMagicNumbers.add(pre + j + i + i + j + end);
                            }
                            else if (reminder - i * 4 == 0) {
                                allMagicNumbers.add(pre + i + i + i + i + end);
                            }
                            else if (reminder - j * 4 == 0) {
                                allMagicNumbers.add(pre + j + j + j + j + end);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(allMagicNumbers.size());
    }
}