package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Map<String, Integer>> students = new TreeMap<>();

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split("\\s");

            int month = Integer.parseInt(tokens[0].substring(3, 5));
            int distance = Integer.parseInt(tokens[2]);

            if (students.containsKey(month)) {
                if(students.get(month).containsKey(tokens[1])){
                    students.get(month).put(tokens[1], students.get(month).get(tokens[1]) + distance);
                }
                else {
                    students.get(month).put(tokens[1], distance);
                }
            }
            else {
                students.put(month, new TreeMap<String, Integer>()
                {{
                    put(tokens[1], distance);
                }});
            }
        }

        for (Map.Entry<Integer, Map<String, Integer>> month : students.entrySet()) {
            String result = "";
            result += String.format("%d: ", month.getKey());

            for (Map.Entry<String, Integer> name : month.getValue().entrySet()) {
                result += String.format("%s(%d), ", name.getKey(), name.getValue());
            }

            System.out.println(result.substring(0, result.length() - 2));
        }
    }
}
