package com.kemya.learnings;
public class ThreadStates implements Runnable{
    public static Thread thread1;
    public static ThreadStates statesObj;

    public static void main(String[] args) throws InterruptedException {
        statesObj=new ThreadStates();
        thread1=new Thread(statesObj);
        thread1.start();
        thread1.interrupt();
        for (int i=0;i<5;i++) {
            System.out.println(i);
        }
        System.out.println(Thread.currentThread().getName()+"--"+Thread.currentThread().getState()+"--"+Thread.currentThread().getPriority());
    }
    @Override
    public void run() {
        A obj2=new A();
        Thread thread2 = new Thread(obj2);
        thread2.start();
        System.out.println("Thread2 : "+thread2.getState());
        try {
            try {
                thread1.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("got interrupted");
            }
            thread2.join();
            System.out.println("Thread1 : "+thread1.getState());
            System.out.println("Thread2 : "+thread2.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class A implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread1 : "+ThreadStates.thread1.getState());

    }
}