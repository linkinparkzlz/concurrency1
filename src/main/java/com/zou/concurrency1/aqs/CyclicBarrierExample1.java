package com.zou.concurrency1.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample1 {


    // 5个线程进行同步等待
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        // 10个请求
        for (int i = 0; i < 10; i++) {

            final int threadNum = i;

            try {
                Thread.sleep(1000);  //  延迟1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            executorService.execute(() -> {

                try {
                    race(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            });
        }
    }


    private static void race(int threadNum) throws InterruptedException, BrokenBarrierException {

        Thread.sleep(1000);
        System.out.println("ready:   " + threadNum);
        cyclicBarrier.await();
        System.out.println("continue");
    }


}



























