package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger inputNum = new BigInteger(scanner.nextLine());

        BigInteger seven = new BigInteger("7");

        for (int i = 63; i >= 2; i--) {
            if ((inputNum.shiftRight(i).and(BigInteger.ONE)).compareTo(BigInteger.ZERO) != 0
                && (inputNum.shiftRight(i - 1).and(BigInteger.ONE)).compareTo(BigInteger.ZERO) != 0
                && (inputNum.shiftRight(i - 2).and(BigInteger.ONE)).compareTo(BigInteger.ZERO) != 0){

                inputNum = inputNum.xor(seven.shiftLeft(i - 2));
                i-=2;
            }
            else if ((inputNum.shiftRight(i).and(BigInteger.ONE)).compareTo(BigInteger.ZERO) == 0
                    && (inputNum.shiftRight(i - 1).and(BigInteger.ONE)).compareTo(BigInteger.ZERO) == 0
                    && (inputNum.shiftRight(i - 2).and(BigInteger.ONE)).compareTo(BigInteger.ZERO) == 0){

                inputNum = inputNum.xor(seven.shiftLeft(i - 2));
                i-=2;
            }
        }

        System.out.println(inputNum);
    }
}