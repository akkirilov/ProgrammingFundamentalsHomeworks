package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] phrases = new String[]{
                "Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."
        };
        String[] events  = new String[]{
                "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"
        };
        String[] author  = new String[]{
                "Diana",
                "Petya",
                "Stella",
                "Elena",
                "Katya",
                "Iva",
                "Annie",
                "Eva"
        };
        String[] cities  = new String[]{
               "Burgas",
               "Sofia",
               "Plovdiv",
               "Varna",
               "Ruse"
        };

        Random rnd = new Random();

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        while (count > 0){
            System.out.println(
                    phrases[rnd.nextInt(phrases.length)]
            + " " + events[rnd.nextInt(events.length)]
            + " " + author[rnd.nextInt(author.length )]
            + " - " + cities[rnd.nextInt(cities.length)]
            );

            count--;
        }
    }
}