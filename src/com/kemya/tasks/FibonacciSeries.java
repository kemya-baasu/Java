package com.kemya.tasks;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n1 = 0, n2 = 1, c = 0;

        while (c < 10) {
            System.out.print(n1 + " ");
            int next = n2;
            n2 = n1 + n2;
            n1 = next;
            c++;
        }
    }
}
