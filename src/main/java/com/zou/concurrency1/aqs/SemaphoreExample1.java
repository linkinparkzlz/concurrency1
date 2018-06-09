package com.zou.concurrency1.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample1 {


    //假设一共20个线程执行
    private final static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        // 每次最多同时执行三个
        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {

            final int threadNum = i;
            executorService.execute(() -> {

                try {
                    //申请许可
                    semaphore.acquire();
                    //执行
                    test(threadNum);
                    //释放
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

        }

        //关闭线程池
        executorService.shutdown();


    }

    private static void test(int threadNum) throws InterruptedException {

        System.out.println(System.currentTimeMillis()+ "    "  +Thread.currentThread().getName()+"   " +threadNum);
        Thread.sleep(1000);
    }


}


















