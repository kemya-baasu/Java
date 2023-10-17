package com.kemya.learnings;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
public class PipedstreamExample {

    public static void main(String[] args) {
        try {
            // Create a PipedInputStream and PipedOutputStream
            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();

            // Connect the input stream to the output stream
            pipedOutputStream.connect(pipedInputStream);

            // Create and start the reader and writer threads
            Thread readerThread = new Thread(() -> readFromPipe(pipedInputStream));
            Thread writerThread = new Thread(() -> writeToPipe(pipedOutputStream));
            readerThread.start();
            writerThread.start();

            // Wait for both threads to finish
            readerThread.join();
            writerThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void readFromPipe(PipedInputStream pipedInputStream) {
        try {
            int data;
            while ((data = pipedInputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToPipe(PipedOutputStream pipedOutputStream) {
        try {
            pipedOutputStream.write("Hello, PipedOutputStream!".getBytes());
            pipedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
