package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<String, TreeMap<String, Integer>> orders = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] currOrder = scanner.nextLine().split("\\s+");
            if (orders.containsKey(currOrder[2])) {
                if (orders.get(currOrder[2]).containsKey(currOrder[0])) {
                    orders.get(currOrder[2]).put(currOrder[0], orders.get(currOrder[2]).get(currOrder[0]) + Integer.parseInt(currOrder[1]));
                }
                else {
                    orders.get(currOrder[2]).put(currOrder[0], Integer.parseInt(currOrder[1]));
                }
            }
            else {
                orders.put(currOrder[2], new TreeMap(){{put(currOrder[0], Integer.parseInt(currOrder[1]));}});
            }
        }

        for(Map.Entry<String, TreeMap<String, Integer>> order: orders.entrySet()){
            String end = "";
            for (Map.Entry<String, Integer> name : order.getValue().entrySet()) {
                end += name.getKey() + " " + name .getValue() + ", ";
            }

            System.out.println(order.getKey() + ": " + end.substring(0, end.length() - 2));
        }
    }
}