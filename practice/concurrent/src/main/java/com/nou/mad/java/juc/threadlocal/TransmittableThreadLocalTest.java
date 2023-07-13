package com.nou.mad.java.juc.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class TransmittableThreadLocalTest {

   // private static final ThreadLocal<String> threadlocal = new InheritableThreadLocal<>();

    private static final TransmittableThreadLocal<String> threadlocal = new TransmittableThreadLocal<>();

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static Integer i=0;

    static ExecutorService executorService = Executors.newFixedThreadPool(2, r -> new Thread(r, "Thread-" + atomicInteger.getAndIncrement()));

    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            testData(i);
        }

        executorService.shutdown();
    }

    public static void testData(int s){

        threadlocal.set("hello:"+(i++));
        Future<?> submit = executorService.submit(TtlRunnable.get(new Task("任务："+s)));
        try {
            submit.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

    static class Task implements Runnable{

        String name ;
        public Task(String name){
            this.name = name;
        }
        @Override
        public void run() {

            System.out.println("thread:"+Thread.currentThread().getName()+",:"+ threadlocal.get());
            threadlocal.remove();

        }

    }
}
