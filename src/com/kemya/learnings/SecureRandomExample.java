package com.kemya.learnings;

import java.security.SecureRandom;

public class SecureRandomExample {
    public static void main(String[] args) {

//        byte[] b=new byte[10];
        SecureRandom random=new SecureRandom();
        System.out.println( random.nextInt());
        System.out.println(random.getProvider());
    }
}
