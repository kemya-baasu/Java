package com.kemya.learnings;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal threadLocal = ThreadLocal.withInitial(() -> "Override Initial Value");
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println(coreCount);
        System.out.println(threadLocal.get());
        threadLocal.set("ABCDE");
        System.out.println(threadLocal.get());
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }
}
