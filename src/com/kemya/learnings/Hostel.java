package com.kemya.learnings;

public class Hostel {
    int i;
    static int s = 10;
    static int k = 5;
    {
        System.out.println("Testing block");
    }

    public static void print() {
        System.out.println(s + " static print " + k);
    }

    static {
        System.out.println("Testing static block : " + s + " " + k);
    }

   public Hostel(){
        System.out.println(i + " " + j);
    }

    public static void main(String arg[]) {
        Hostel obj = new Hostel();
        obj.i = 100;
        obj.j = 200;
        obj.display();

        Hostel obj2 = new Hostel();

    }

    public void display() {
        System.out.println(i + " - " + j);
    }


    int j;

    static {
        System.out.println(s + "- static -" + k);
    }
}
