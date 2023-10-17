package com.kemya.learnings;

public class Inheritance {
    public static void main(String[] args) {
        Puppies puppy=new Puppies();
        puppy.drink();
        puppy.eat();
    }
}
 class Animal{
    void eat(){
        System.out.println("Animals eat..");
    }
}
class Horse extends Animal{
    void eat(){
        System.out.println("Horse eats grass..");
    }
}
class Dog extends Animal{
    void eat(){
        System.out.println("Dog eats pedigree..");
    }
}
class Puppies extends Dog{
    void drink(){
        System.out.println("Puppies Drink milk..");
    }
}
class Cat extends Animal{
    void eat(){
        System.out.println("Cat eats Fish..");
    }
}