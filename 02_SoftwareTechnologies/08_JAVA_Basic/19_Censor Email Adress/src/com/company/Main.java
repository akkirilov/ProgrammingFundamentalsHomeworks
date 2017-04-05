package com.company;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();
        String text = scanner.nextLine();

        String[] emailEll = email.split("@");
        String censored = String.join("", Collections.nCopies(emailEll[0].length(), "*")) + "@" + emailEll[1];

        System.out.println(text.replaceAll(email, censored));
    }
}