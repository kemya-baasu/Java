package com.kemya.learnings;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapExamples {
    public static void main(String[] args) {
        HashMap hMap=new HashMap<>();
        hMap.put(1,"Kemya");
        hMap.put(2,"Abarna");
        hMap.put(3,"Dinesh");
        System.out.println(hMap.put(1,"Pranauv"));
        System.out.println(hMap.get(5)+"--");
        for (Object h:hMap.entrySet()) {
            System.out.println(h);
        }
        Map hMap1= Collections.synchronizedMap(hMap);

        IdentityHashMap iMap=new IdentityHashMap<>();
        iMap.put(1,"A");
        iMap.put(2,"B");
        iMap.put(new String("C"),"A");
        iMap.put("C","A");
        System.out.println(iMap);
        IdentityHashMap cMap;
        LinkedHashMap lMap;
        WeakHashMap wMap;


        }
    }
