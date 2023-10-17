package com.kemya.learnings;

import java.io.*;

public class SingletonClass implements Serializable {
    private static SingletonClass singletonObj;
    private SingletonClass(){

    }
    public static SingletonClass getInstance(){

        if(singletonObj==null){
            synchronized (SingletonClass.class) {
                singletonObj = new SingletonClass();
            }
        }
        return singletonObj;

    }
    protected SingletonClass readResolve(){
        return singletonObj;
    }

}
class SerializeSingleton implements Serializable{
    public static SingletonClass getObject() throws IOException, ClassNotFoundException {

        FileOutputStream file = new FileOutputStream("D:\\JavaPrograms\\testFile1.txt");  //Saving of object in the file
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(SingletonClass.getInstance());

        FileInputStream fileObject = new FileInputStream("D:\\JavaPrograms\\testFile1.txt");
        ObjectInputStream in = new ObjectInputStream(fileObject);
        SingletonClass DeSerializedObj = (SingletonClass) in.readObject();
        return DeSerializedObj;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(getObject());
    }
}
