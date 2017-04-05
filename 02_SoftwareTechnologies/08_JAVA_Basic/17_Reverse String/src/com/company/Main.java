package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new StringBuffer(scanner.nextLine()).reverse().toString());
    }
}