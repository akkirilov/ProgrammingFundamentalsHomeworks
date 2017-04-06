package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        int start;
        int end;
        String textToUpper = "";

        while (text.indexOf("<upcase>") >= 0){
            start = text.indexOf("<upcase>");
            end = text.indexOf("</upcase>");

            textToUpper += text.substring(0, start) + text.substring(start + 8, end).toUpperCase();

            text = text.substring(end + 9, text.length());
        }

        System.out.println(textToUpper + text);
    }
}