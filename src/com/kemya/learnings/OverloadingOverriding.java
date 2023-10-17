package com.kemya.learnings;

class Parent {
    public void punch() {
        System.out.println("Hi from Parent class");
    }
}

class Child extends Parent {
    //Override parent class method
    public void punch() {
        System.out.println("Hi from Child Class");
    }

    public int punch(int a) {
        return a;
    }
}

public class OverloadingOverriding {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.punch();
        Child CObj = new Child();
        CObj.punch();
        System.out.println(CObj.punch(7)+" --- Overloaded");
    }
}
