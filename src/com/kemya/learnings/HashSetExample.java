package com.kemya.learnings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class HashSetExample
{
    public static void main(String[] args) {
        HashSet <Person> personSet= new HashSet<>();
        personSet.add(new Person(1,"Ram"));
        personSet.add(new Person(1,"Ram"));
        personSet.add(new Person(2,"Ram"));
        System.out.println(personSet.size());


    }
}
class Person
{
    int id;
    String name;

    Person(int id, String name)
    {
        this.id= id;
        this.name= name;
    }
    public boolean equals(Object obj) {
        System.out.println(this);
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        return name.equals(other.name) && id == other.id;
    }
    @Override
    public int hashCode() {
        System.out.println("hashcode : " + id);
        return id;
    }


}
