package com.kemya.learnings;

import java.io.Serializable;

public class Demo implements Cloneable, Serializable {
    //Parameterized Constructor
     public Demo(Integer i) throws CloneNotSupportedException {
        System.out.println(i);
         System.out.println("Object Created");
     }
     //Non-Parameterized Constructor
     public Demo() throws CloneNotSupportedException {
System.out.println("Non-Parameterized Constructor Called");
     }
     //Overriding clone() method
     @Override
     public Object clone() throws CloneNotSupportedException {
         return super.clone();
     }
    Demo DemoObj1=new Demo();//6.Using new Keyword
    Demo DemoObj2=(Demo) DemoObj1.clone();
    public static void main(String[] args) {

        System.out.println("Hello World");
        System.currentTimeMillis();

    }
    public void methodCalled(){
        System.out.println("Demo Class Method is Called ~ ~");
    }
}