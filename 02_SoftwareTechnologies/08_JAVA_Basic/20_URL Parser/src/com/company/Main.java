package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] urlEll = Arrays.stream(scanner.nextLine()
                .split("/", 4))
                .filter(a -> !a.isEmpty())
                .map(a -> a.trim())
                .toArray(String[]::new);

        int i = 0;

        String protocol = "";
        if (urlEll[i].contains(":")){
            protocol = urlEll[i].substring(0, urlEll[i].length() - 1);
            i++;
        }

        String server = urlEll[i];
        i++;

        String resource = "";
        if(urlEll.length > 2){
            resource = urlEll[i];
        }

        System.out.println("[protocol] = \"" + protocol + "\"");
        System.out.println("[server] = \"" + server + "\"");
        System.out.println("[resource] = \"" + resource + "\"");
    }
}