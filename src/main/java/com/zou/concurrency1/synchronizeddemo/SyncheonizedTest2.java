package com.zou.concurrency1.synchronizeddemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncheonizedTest2 {


    public static void test1() {


        //修饰一个类
        synchronized (SyncheonizedTest2.class) {

            for (int i = 0; i < 10; i++) {

                System.out.println(i);
            }
        }
    }

    //修饰一个静态方法
    public  static synchronized void test2() {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

    }


    public static void main(String[] args) {


        SyncheonizedTest2 syncheonizedTest1 = new SyncheonizedTest2();

        SyncheonizedTest2 syncheonizedTest11 = new SyncheonizedTest2();

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




































