package com.kemya.learnings;

import java.util.*;
import java.util.stream.StreamSupport;

public class SpliteratorExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Spliterator.OfInt spliterator = Arrays.spliterator(numbers);
        Spliterator.OfInt parallelSpliterator = spliterator.trySplit();
        //for sequential Accessing of data
        StreamSupport.intStream(spliterator, false).forEach(System.out::println);
        // for parallel processing of List data with multiple threads argument is true
        StreamSupport.intStream(parallelSpliterator, true).forEach(System.out::println);


    }
}
