package com.zou.concurrency1.synchronizeddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncheonizedTest1 {


    public void test1() {


        //修饰一个代码块
        synchronized (this) {

            for (int i = 0; i < 10; i++) {

                System.out.println(i);
            }
        }
    }

    //修饰一个方法
    public synchronized void test2() {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

    }


    public static void main(String[] args) {


        SyncheonizedTest1 syncheonizedTest1 = new SyncheonizedTest1();

        SyncheonizedTest1 syncheonizedTest11 = new SyncheonizedTest1();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {

            syncheonizedTest1.test1();
        });

        System.out.println();

        executorService.execute(() -> {

            syncheonizedTest11.test1();
        });


    }


}




































