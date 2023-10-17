package com.kemya.learnings;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadpoolExample {
    public static void main(String[] args) throws InterruptedException {
        ThreadpoolExample example=new ThreadpoolExample();
        ChildClass t1=new ChildClass("t1");
        ChildClass t2=new ChildClass("t2");
        ChildClass t3=new ChildClass("t3");
        ChildClass t4=new ChildClass("t4");
        t4.interrupt();
        t1.setDaemon(true);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(t1);
        executor.execute(t2);
        executor.execute(t3);
        executor.execute(t4);
        executor.shutdown();
        System.out.println(executor.isShutdown());


    }
}
class ChildClass extends Thread{
     String name;
    ChildClass(String name){
        this.name=name;
    }
    @Override
    public void run() {
//        while(isDaemon()==true){
//            System.out.println("Daemon Thread status"+Thread.currentThread().isDaemon());
//        }
       Date d=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss");
        System.out.println("Execution started for : " + Thread.currentThread().getName() +"     Thread name : "+name +"     Time : "+sdf.format(d));
        try {
            System.out.println("---");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Execution ended for : " + Thread.currentThread().getName()+"       Thread name : "+name+"     Time : "+sdf.format(d));
    }
}

