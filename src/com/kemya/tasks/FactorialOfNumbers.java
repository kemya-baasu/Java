package com.kemya.tasks;

import java.util.Scanner;

public class FactorialOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number to find factorial value : ");
        int number = sc.nextInt();
        System.out.println(factorial(number));

    }

    static int factorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
}
