package com.company;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    String input = scanner.nextLine();
	    if(input.length() < 20){
	        String output = input + String.join("", Collections.nCopies((20 - input.length()), "*"));
	        System.out.println(output);
        }
        else if(input.length() > 20){
			System.out.println(input.substring(0, 20));
		}
		else {
			System.out.println(input);
		}
    }
}