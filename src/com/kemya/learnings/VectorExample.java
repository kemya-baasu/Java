package com.kemya.learnings;

import java.util.*;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> vect=new Vector<Integer>(10,5);
        vect.add(1);
        vect.addAll(Arrays.asList(2, 3, 4, 5, 6, 7));
        vect.removeElement(2);
        vect.remove(0);
        System.out.println(vect);
//        for (Integer v:vect) {
//            vect.add(10);
//            System.out.println(vect);
//        }
        ListIterator<Integer> iter= vect.listIterator();
        while(iter.hasNext()){
            try {
                System.out.println("before");
                iter.add(2);// results in concurrent modification error as there is possibility of two threads trying to access at the same time
                System.out.println("after");
            }
            catch (Exception e){
                System.out.println("handled");
            }
            System.out.println(iter.next());

        }

        System.out.println(vect);
    }



}
