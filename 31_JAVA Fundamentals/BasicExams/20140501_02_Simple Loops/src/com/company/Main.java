package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

	    BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();
        BigInteger c = scanner.nextBigInteger();
        BigInteger d = scanner.nextBigInteger();

        if (d.intValue() == 1) {
            System.out.println(a);
        }
        else if (d.intValue() == 2) {
            System.out.println(b);
        }
        else if (d.intValue() == 3) {
            System.out.println(c);
        }
        else if (d.intValue() == 4) {
            System.out.println(a.intValue() + b.intValue() + c.intValue());
        }
        else {
            int count = d.intValue();
            for (int i = 4; i <= count; i++) {
                d = a.add(b).add(c);
                a = b;
                b = c;
                c = d;
            }

            System.out.println(d);
        }
    }
}
