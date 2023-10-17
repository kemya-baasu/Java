package com.kemya.learnings;

import java.util.*;

public class SynchronizedListClass {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(12);
        arrayList.add(23);
        arrayList.add(89);
        arrayList.add(9087);

        // Create a synchronized list
        List<Integer> listing = Collections.synchronizedList(arrayList);
        listing.add(1);
        listing.add(2);
        listing.add(3);
        ListIterator<Integer> iterator1 = listing.listIterator();
        for (ListIterator<Integer> it = iterator1; it.hasNext(); ) {
            Integer a = it.next();
            System.out.println(a);
//            listing.add(4);
        }
        listing.add(4);
        System.out.println(listing.toString());
        System.out.println(arrayList.toString());

    }

}