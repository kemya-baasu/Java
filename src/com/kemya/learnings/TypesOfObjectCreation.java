package com.kemya.learnings;
import java.io.Serializable;
import java.lang.*;
import java.io.*;

import com.kemya.learnings.Demo;

import java.lang.reflect.InvocationTargetException;

class TypesOfObjectCreation implements Serializable {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException, InstantiationException, IOException {
        // 1.Object Creation Using newInstance() method of Class
        Class<Demo> clsObj1 = Demo.class;
        Class clsObj2 = Class.forName("com.kemya.learnings.Demo");
        Demo objectName = (Demo) clsObj2.newInstance();

        // 2.Object Creation Using newInstance() method of Constructor class
        Demo DemoObj = Demo.class.getConstructor(Integer.class).newInstance(1);

        // 3.Create object using clone() method
        Demo DemoObj1=new Demo();//6.Using new Keyword
        Demo DemoObj2=(Demo) DemoObj1.clone();

        //4.serializable and deserializable object Creation
        FileOutputStream file = new FileOutputStream("D:\\JavaPrograms\\testFile1.txt");  //Saving of object in the file
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(DemoObj1);

        InputStream fileObject=new FileInputStream("D:\\JavaPrograms\\testFile1.txt");
        ObjectInputStream in=new ObjectInputStream(fileObject);
        Demo DeSerializedObj = (Demo) in.readObject();
        DeSerializedObj.methodCalled();

        //5.Factory method ... Separate class Decides which concrete class's constructor should be called

//        System.out.println(DemoObj2);
    }
}