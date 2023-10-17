package com.kemya.learnings;

import java.util.Arrays;

public class ThreadGroupExample {
    public static void main(String[] args) throws InterruptedException {
        ThreadClass threadClassObj=new ThreadClass();
        ThreadGroup tg=new ThreadGroup("ThreadGroup1");
        Thread t1=new Thread(threadClassObj);
        Thread t2=new Thread(threadClassObj);
        Thread.currentThread().setPriority(3);
        //copy active threads from a group to array
        Thread[] threadArray=new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        System.out.println(Arrays.toString(threadArray));
        //copy active thread group to array
        ThreadGroup[] threadGrpArray=new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadGrpArray);
        System.out.println(Arrays.toString(threadGrpArray));
        tg.setMaxPriority(2);
        tg.list();//list threads in tg thread group
        System.out.println("Active Threads in main ThreadGroup :"+Thread.currentThread().getThreadGroup().activeCount());
        Thread t3=new Thread(Thread.currentThread().getThreadGroup(),threadClassObj);
        Thread t4=new Thread(tg,threadClassObj);
        Thread t5=new Thread(threadClassObj);
        System.out.println(t1.getThreadGroup().getName()+"--"+t1.getPriority());
        System.out.println(t2.getThreadGroup().getName()+"--"+t2.getPriority());
        System.out.println(t3.getThreadGroup().getName()+"--"+t3.getPriority());
        System.out.println(t4.getThreadGroup().getName()+"--"+t4.getPriority()+"--"+t4.getThreadGroup().getParent().getName());
        System.out.println(t5.getThreadGroup().getName()+"--"+t5.getPriority());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        Thread.sleep(10);
        System.out.println("Active Threads in main ThreadGroup :"+Thread.currentThread().getThreadGroup().activeCount());
    }
}
class ThreadClass extends Thread{
    ThreadClass(ThreadClass tg,String name){
super(tg,name);
    }
    ThreadClass(){

    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getThreadGroup().getName()+"--"+Thread.currentThread().getName()+"--Priority :"+Thread.currentThread().getPriority());
    }
}
