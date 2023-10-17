package com.kemya.tasks;

import java.util.Arrays;

public class SortStringArray {
    public static void main(String[] args) {
        String[] nameArray={"Kemya","Abarna","Jayashree","Dinesh","Aakash"};
        for (int i = 0; i < nameArray.length-1 ; i++) {
            for (int j = 0; j < nameArray.length-1-i ; j++) {
                if(nameArray[j].compareTo(nameArray[j+1])>0){
                    String temp=nameArray[j+1];
                    nameArray[j+1]=nameArray[j];
                    nameArray[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(nameArray));
    }
}
