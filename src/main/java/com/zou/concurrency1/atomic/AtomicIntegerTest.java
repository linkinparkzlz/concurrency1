package com.zou.concurrency1.atomic;


import com.zou.concurrency1.annotions.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
@NotThreadSafe
public class AtomicIntegerTest {


    //请求总数
    public static int clientAll = 5000;

    //并发数
    public static int threadAll = 200;


    private static LongAdder count = new LongAdder();

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

        count.increment(); //线程不安全写法
    }


}









