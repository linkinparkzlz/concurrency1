package com.zou.concurrency1.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample2 {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {

            final int index = i;

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程：" + Thread.currentThread().getName() + "  " + index);
                }
            });
        }

        executorService.shutdown();


    }


}






























