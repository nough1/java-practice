package com.nou.mad.java.thread;

import java.util.List;
import java.util.concurrent.*;

public class ThreadDemo {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<?> submit = executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
        List<Runnable> runnables = executorService.shutdownNow();

        executorService.shutdown();
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-1 << 29));
        System.out.println(-1<<29);
    }
}
