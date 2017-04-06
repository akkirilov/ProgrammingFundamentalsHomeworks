package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] circle1 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(x -> Integer.parseInt(x))
                .toArray();
        int[] circle2 = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(x -> Integer.parseInt(x))
                .toArray();

        double distance = Math.sqrt(Math.pow((circle1[0] - circle2[0]), 2) + Math.pow((circle1[1] - circle2[1]), 2));

        String result = "Yes";
        if(distance > (circle1[2] + circle2[2])){
            result = "No";
        }

        System.out.print(result);
    }
}