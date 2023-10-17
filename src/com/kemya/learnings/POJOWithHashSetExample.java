package com.kemya.learnings;

import java.util.HashSet;

public class POJOWithHashSetExample {
    public static void main(String[] args) {
        HashSet<Student> set=new HashSet<Student>();
        set.add(new Student("Kemya",1));
        set.add(new Student("Kemya",2));
        set.add(new Student("Kemya",1));
        System.out.println(set.size());
    }
}
class Student{
 private String name;
 private int id;
 Student(String name,int id) {
     this.name=name;
     this.id=id;
 }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        Student sObj=(Student) obj;
        return this.id== sObj.id && this.name==sObj.name;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
