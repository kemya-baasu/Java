package com.kemya.learnings;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueExample {
    public static void main(String[] args) {
        PriorityQueue<String> que=new PriorityQueue<>();
        que.offer("hi");
        que.poll();
       // que.element();// NoSuchElement Exception as null value
        que.offer("A");
        System.out.println(que);

        // Array Deque is used to access both the ends of queue elements
        ArrayDeque<String> deque =new ArrayDeque<>();
        deque.addFirst("A");
        deque.addLast("B");

        //Blocking Queue to make Queue thread safe
        BlockingQueue< String > alph = new LinkedBlockingDeque< String >( ) ;
        alph.add( " A " ) ;
        alph.add( " B " ) ;
        alph.add( " C " ) ;
        Iterator< String > alphIter = alph.iterator( ) ;
        System.out.println( " The content of the Linked Blocking Deque is : " ) ;
        for( int i = 0 ; i < alph.size( ) ; i++ )
        {
            System.out.print( alphIter.next( ) + " ") ;
        }

        //BlockingQueue blockingQueue = new LinkedBlockingDeque( ) ;  Unbounded Blocking Queue
        //BlockingQueue blockingQueue = new LinkedBlockingDeque( 20) ;  Bounded Blocking Queue

        // Creating a PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(2);
        System.out.println("PriorityQueue: " + priorityQueue);

        // Creating a BlockingQueue
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.add(3);
        blockingQueue.add(1);
        blockingQueue.add(2);
        System.out.println("BlockingQueue: " + blockingQueue);


    }
}
