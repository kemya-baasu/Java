package com.kemya.learnings;

public class Testing {
    public static void main(String[] args) throws Exception{
        Square s=new Square();
        Shape shap=new Square();
        try{
            System.out.println("try");
            throw new Exception();
        }
        catch (Exception e){
            System.out.println("catch");
            System.exit(0);
        }
        finally {
            System.out.println("finally");
        }
        s.area();
//        s.side=5;
//        s.area();
//        s.sqrt();
//        shap.side=7;
//        shap.area();
//        shap.sqrt
    }
}
interface Shape{

    default void area(){
        System.out.println("shape area");
    }
}
interface UI{
    default void area(){
        System.out.println("UI area");
    }
}
class Square implements Shape,UI{
    int side;

    public void sqrt(){
        System.out.println("sqrt");
    }


    @Override
    public void area() {
        Shape.super.area();
    }
}
