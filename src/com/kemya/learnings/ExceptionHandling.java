package com.kemya.learnings;

import java.util.Scanner;

class AgeNotValidException extends Exception {
    public AgeNotValidException(String message) {
        System.out.println(message);
    }

    public static void validateLicense(int age, int licenseIssuedYear) throws ArithmeticException {
        if (age / licenseIssuedYear > 2) {
            System.out.println("Liscence Expired");
        }
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Age to Validate : ");
        int age = sc.nextInt();
        if (age < 18) {
            try {
                throw new AgeNotValidException("You are not allowed to have a liscence");//manually throwing Exception to JVM
            } catch (Exception e) {
                System.out.println("Exception Handled -- " + e);
            }
        }
        try {
            AgeNotValidException.validateLicense(age, 2);
        }
        catch (ArithmeticException e){
            System.out.println("Arithmetic Exception Handled -- "+e);
        }
        System.out.println("All Exceptions Handled");
    }
}
