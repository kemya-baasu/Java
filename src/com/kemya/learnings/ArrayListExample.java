package com.kemya.learnings;
import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList names=new ArrayList();
        Collections.sort(names);
        names.add("Kemya");
        names.add("Abarna");
        names.add("Jayashree");
        names.add("Dinesh Kumar");
        Iterator namesIter=names.iterator();
        while ( namesIter.hasNext()){
            System.out.println(namesIter.next());
        }

        LinkedList<String> ll=new LinkedList<String>();
        ll.add("Ravi");
        ll.add("Vijay");
        ll.add("Ajay");
        //Traversing the list of elements in reverse order
        Iterator i=ll.descendingIterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
    }
}
