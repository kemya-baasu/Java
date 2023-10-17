package com.kemya.learnings;

import java.util.UUID;

public class ThreadSynchronization {
    public static void main(String[] args) {
        MyThread myThreadObj = new MyThread();
        Thread t1 = new Thread(myThreadObj);
        Thread t2 = new Thread(myThreadObj);
        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable {
    int c = 0;

    public synchronized void printA() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "--- Got and released object level lock - printA");
        Thread.sleep(1000);
    }

    public synchronized void printB() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "--- Got and released object level lock - printB");
        Thread.sleep(1000);
    }

    public static synchronized void printC() {
        System.out.println(Thread.currentThread().getName()+"--- Got and released class level lock - printC");
    }

    public static synchronized void printD() {
        System.out.println(Thread.currentThread().getName()+"--- Got and released class level lock - printD");
    }

    public static void printE() {
        System.out.println(Thread.currentThread().getName()+"--- I don't need lock as i am only static method");
    }

    public void printF(){
        System.out.println(Thread.currentThread().getName()+"--- I am just a normal method");
    }

    @Override

    public void run() {
        try {
            printA();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            printB();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        printC();

        printD();
        printE();
        printF();
    }
}
