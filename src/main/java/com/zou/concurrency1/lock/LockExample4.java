package com.zou.concurrency1.lock;


import com.zou.concurrency1.annotions.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

@Slf4j
@NotThreadSafe
public class LockExample4 {


    //请求总数
    public static int clientAll = 5000;

    //并发数
    public static int threadAll = 200;


    private static int count = 0;

    private final static StampedLock lock = new StampedLock();

    public static void main(String[] args) throws InterruptedException {


        ExecutorService executorService = Executors.newCachedThreadPool();

        // 允许的并发数
        final Semaphore semaphore = new Semaphore(threadAll);

        final CountDownLatch countDownLatch = new CountDownLatch(clientAll);


        //放入线程池中执行
        for (int i = 0; i < clientAll; i++) {

            executorService.execute(() -> {

                try {
                    semaphore.acquire(); //是否允许执行
                    add();
                    semaphore.release();//执行完成后释放
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                countDownLatch.countDown();


            });
        }

        System.out.println(count);
        countDownLatch.await();

        executorService.shutdown();//使用完线程 池后关闭
    }


    private static void add() {

        long s = lock.writeLock();

        try {
            count++; //线程不安全写法
        } finally {
            // 需要手动进行释放
            lock.unlock(s);
        }

    }


}









