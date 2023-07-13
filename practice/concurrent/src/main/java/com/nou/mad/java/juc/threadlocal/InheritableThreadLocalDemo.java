package com.nou.mad.java.juc.threadlocal;

public class InheritableThreadLocalDemo {

    private static final InheritableThreadLocal<String> threadlocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        threadlocal.set("hello");
        System.out.println(threadlocal.get());

        new Thread(()->{

            System.out.println(threadlocal.get());

        }).start();

    }
}
