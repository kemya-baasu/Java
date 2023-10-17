package com.kemya.learnings;

import java.util.*;

public class SetExamples {
    public static void main(String[] args) {
        HashSet<String> hSet = new HashSet<>();
        hSet.add(null);
        System.out.println(hSet+"--");

        Set<String> lHashSet = new LinkedHashSet<>();
        lHashSet.add(null);
        System.out.println(lHashSet+"--");

        TreeSet setTree=new TreeSet(new myComparator());
        setTree.add(new StringBuffer("kemya"));
        setTree.add(new StringBuffer("kemya"));
        setTree.add(new StringBuffer("dinesh"));
        setTree.add(new StringBuffer("hari"));
//        setTree.add(null);
        setTree.add(new StringBuffer("rithik"));
        System.out.println(setTree);



        //Set Examples
        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1));
        set1.addAll(Arrays.asList(2,3,4,5));//Union
        set1.retainAll(Arrays.asList(1,2));//Intersection
        set1.removeAll(Arrays.asList(1));//difference
        set1.addAll(Arrays.asList(5,6,7,5,8,-5));
        set1.add(0);
        System.out.println(hSet+"--"+set1);

        Hashtable<Integer, ArrayList> hTable=new Hashtable<>();
        hTable.put(1,new ArrayList<>(Arrays.asList("K","e","m","y","a")));
//        hTable.put(3,new ArrayList<>(List.of(null)));
        System.out.println(hTable);

    }
}
class myComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {

         return String.valueOf(o1).compareTo(String.valueOf(o2));
    }
}


