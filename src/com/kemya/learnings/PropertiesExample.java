package com.kemya.learnings;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesExample {
        public static void main(String[] args)throws Exception{
// Used to get data from Properties File which is stored in the form of Key-Value Pairs
            Properties p=System.getProperties();
            Set set=p.entrySet();
            Iterator itr=set.iterator();
            while(itr.hasNext()){
                Map.Entry entry=(Map.Entry)itr.next();
                System.out.println(entry.getKey()+" = "+entry.getValue());
            }

        }
    }
