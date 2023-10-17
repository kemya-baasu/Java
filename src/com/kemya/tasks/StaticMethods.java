package com.kemya.tasks;
//Class having static method and instance method ------
public class StaticMethods{
    static int variable=10;
public static void main(String[] args){
    CallStaticMethods callStaticMethodObj=new CallStaticMethods();
    callStaticMethodObj.Display();
}
//Static method
static void sayHello(){
System.out.println("Hello");
}
//Instance method
 void sayHi(){
    System.out.println("Hi");
}
}

// static block used and static method is called in this class ---
class CallStaticMethods{

static{
System.out.println("Static Block 1 is called");
}
void Display()
{
StaticMethods.sayHello();
//    StaticMethods.SayHi();
}
static{
System.out.println("Static Block 2 is called");
System.out.println(StaticMethods.variable);
}
}