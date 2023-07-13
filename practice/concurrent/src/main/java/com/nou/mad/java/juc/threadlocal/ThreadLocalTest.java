package com.nou.mad.java.juc.threadlocal;

import java.util.concurrent.*;

public class ThreadLocalTest {



    public static void main(String[] args) {


        //ExecutorService executorService = Executors.newFixedThreadPool(100);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20,20,0, TimeUnit.SECONDS,new LinkedBlockingDeque(1024));
        for(int i=0;i<1000;i++){

            threadPoolExecutor.submit(new Runnable() {
                public void run() {

                    DateUtil.parse("2023-07-11 00:00:00");

                }
            });

        }

        threadPoolExecutor.shutdown();

        System.out.println("end");

    }
}
