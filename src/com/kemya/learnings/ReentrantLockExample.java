package com.kemya.learnings;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        TryReentrant tryReentrantObj = new TryReentrant();
        ScheduledExecutorService exeService = Executors.newScheduledThreadPool(2);
//        exeService.schedule(new Task("Ram"),2,TimeUnit.MINUTES);
//        exeService.schedule(new Task("Shiva"),5,TimeUnit.SECONDS);
        exeService.scheduleAtFixedRate(new Task("ravi"),2,6,TimeUnit.SECONDS);
        exeService.shutdown();
//        exeService.scheduleWithFixedDelay(tryReentrantObj, 3, 10, TimeUnit.SECONDS);
//        exeService.execute(tryReentrantObj);
//        Thread t1=new Thread(tryReentrantObj, "kemya");
//
//        t1.start();
    }
}

class TryReentrant implements Runnable {
    private ReentrantLock rL = new ReentrantLock();

    @Override
    public void run() {
        printWithLock();
    }

    void printWithLock() {
        if (rL.tryLock()) {
            rL.lock();
            for (int i = 0; i < 1; i++) {
                System.out.println("withLock"+Thread.currentThread().getName());
            }
            rL.unlock(); rL.unlock();
            System.out.println(rL.isLocked()+"if--"+Thread.currentThread().getName());

        } else {
            System.out.println("Lock Already Occupied"+Thread.currentThread().getName());
            System.out.println(rL.isLocked());
        }
    }
}
class Task implements Runnable{
    String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
       // System.out.println("Hi this is kemya");
    }
}
