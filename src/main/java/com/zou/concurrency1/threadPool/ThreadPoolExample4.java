package com.zou.concurrency1.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample4 {


    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

//        for (int i = 0; i < 10; i++) {
//
//            final int index = i;
//
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("线程：" + Thread.currentThread().getName() + "  " + index);
//                }
//            });
//        }

        executorService.schedule(() -> System.out.println("schedule  run..."),300, TimeUnit.MILLISECONDS);

        executorService.scheduleAtFixedRate(() -> System.out.println(),1,3,TimeUnit.SECONDS);

        executorService.shutdown();


    }


}






























