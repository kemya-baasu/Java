package com.kemya.learnings;

abstract class Bottle {
    static String bottleColor;

    abstract void getBottleColor();
}

class Kemya extends Bottle {
    @Override
    void getBottleColor() {
        bottleColor="Green";
        System.out.println(bottleColor);
    }
}
class Jayashree extends Bottle {
    @Override
    void getBottleColor() {
        bottleColor="Yellow";
        System.out.println(bottleColor);
    }
}
class GetConcretClassObject {
    public Bottle getBottleColorObj(String name) {
        if (name.equals("Kemya")) {
            return new Kemya();
        } else if (name.equals("Jayashree")) {
            return new Jayashree();
        }
        return null;
    }
}

public class FactoryMethod {

    public static void main(String[] args) {
        GetConcretClassObject obj=new GetConcretClassObject();
        obj.getBottleColorObj("Kemya").getBottleColor();
    }

}
