package com.kemya.tasks;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SearchStringInFiles {
    public static void main(String[] args) throws IOException, InterruptedException {
        writeDataToFiles();
        Thread t=new Thread(new ThreadExecutor());
        t.start();
        t.join();
        System.out.println("Completed Searching");

    }

    static void writeDataToFiles() throws IOException {
        ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
        byteArrayStream.write("Hi Today is Wednesday".getBytes());
        for (int i = 1; i < 5; i++) {
            FileOutputStream f = new FileOutputStream("D:\\JavaPrograms\\testFile" + i + ".txt");
            byteArrayStream.writeTo(f);
        }
        FileOutputStream f5 = new FileOutputStream("D:\\JavaPrograms\\testFile5.txt");
        f5.write("Hello i am Kemya".getBytes());
    }
}

class ThreadExecutor implements Runnable {
    @Override
    public void run() {
        File folder = new File("D:\\JavaPrograms");
        String[] paths = folder.list();
        System.out.println(Arrays.toString(paths));
        ExecutorService tPool = Executors.newFixedThreadPool(5);
        for (String s : paths) {
            if(s.endsWith(".txt")){
                tPool.execute(new FindWord(s));
            }
        }
    }
}
class FindWord extends Thread{
    String path="D:\\JavaPrograms\\";
FindWord(String path){
    this.path=this.path+path;
}

    @Override
    public void run() {
        System.out.println("Thread started : " + Thread.currentThread().getName());
        try (BufferedReader b = new BufferedReader(new FileReader(path))) {
            String fileContent = b.readLine();
            if(fileContent.contains("Kemya")){
                System.out.println(path);
            }
        } catch (RuntimeException | IOException ex) {
            System.out.println("caught Exception");
        }
    }
}
