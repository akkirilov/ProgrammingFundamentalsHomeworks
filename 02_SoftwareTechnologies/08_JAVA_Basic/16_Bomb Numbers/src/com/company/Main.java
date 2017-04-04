package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArr = scanner.nextLine().split("\\s+");

        int[] nums = new int[strArr.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(strArr[i]);
        }

        strArr = scanner.nextLine().split("\\s+");
        int bomb = Integer.parseInt(strArr[0]);
        int power = Integer.parseInt(strArr[1]);

        int leftImpact = 0;
        int rightImpact = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == bomb){
                leftImpact = Math.max((i - power), 0);
                rightImpact = Math.min((i + power), (nums.length - 1));
                for(int b = leftImpact; b <= rightImpact; b++){
                    nums[b] = 0;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        System.out.println(sum);
    }
}