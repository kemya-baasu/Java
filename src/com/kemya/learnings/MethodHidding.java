package com.kemya.learnings;

public class MethodHidding {
    public static void main(String[] args) {
        SuperClass.printClassType();
        SubClass.printClassType();
        SuperClass obj1 = new SubClass();
        obj1.printClassType();
    }
}

class SuperClass {
    public static void printClassType() {
        System.out.println("Executed SuperClass");
    }
}

class SubClass extends SuperClass {
    public static void printClassType() {
        System.out.println("Executed SubClass");
    }
}
