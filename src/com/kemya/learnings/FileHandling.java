package com.kemya.learnings;
import java.io.*;

public class FileHandling {
    public static void main(String[] args) throws IOException {
        FileOperations();
    }

    public static void FileOperations() throws IOException {

        //Create File and write into file using FileWriter Class
        FileWriter fout = new FileWriter("D:\\JavaPrograms\\testFile1.txt");
        fout.write("Hi this is Kemya");
        fout.close();

        // Write into a File Using BufferedWriter & Append
        FileWriter fin = new FileWriter("D:\\JavaPrograms\\testFile1.txt", true);
        BufferedWriter Bin = new BufferedWriter(fin);
        Bin.write(". Today is a Good day!");
        Bin.close();

        // Delete a file Using File Class
//        file.delete();

        // Set the file length to 0 to clear the data
        RandomAccessFile ClearFile = new RandomAccessFile("D:\\JavaPrograms\\testFile1.txt", "rw");
        ClearFile.setLength(0);
    }
}
