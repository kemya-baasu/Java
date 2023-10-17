package com.kemya.learnings;

import java.io.FilterReader;
import java.io.IOException;

interface Game {
    int playersCount = 10; // default final & static

    default void Test() {
        System.out.println("Hi");
    }

    void SportType();//public & abstract
}

abstract class Cricket implements Game {
    abstract void batting();
}

 class DeclareSportTypeCricket extends Cricket {
    @Override
    public void SportType() {
        System.out.println("This is Cricket..");
    }
     @Override
     public void batting() {
         System.out.println("Batting is a part of Cricket");
     }
}

abstract class KhoKho implements Game {

    abstract void chasing();

}

class DeclareSportTypeKhoKho extends KhoKho {
    @Override
    public void SportType() {
        System.out.println("This is Kho-Kho..");
    }

    @Override
    public void chasing() {
        System.out.println("Im also a Chaser");
    }
}

class GetSport {
    void printSport(Game g) {
        g.SportType();
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        GetSport g = new GetSport();
        Game khoKhoobj = new DeclareSportTypeKhoKho();
        Game cricketobj = new DeclareSportTypeCricket();
        g.printSport(khoKhoobj);
        g.printSport(cricketobj);

    }
}



