package com.kemya.tasks;

import java.util.Arrays;

public class SortingAndLargestNumber {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 5, 6, 7, 1, 0};//4-3=7-3=4
        //Sorting Array using Bubble Sort
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if(isSwapped==false){
                System.out.println("y");
                break;
            }
        }
        System.out.println("Sorted Array : " + Arrays.toString(arr));
        System.out.println("Largest Number In Array : " + arr[arr.length - 1]);
    }

}
