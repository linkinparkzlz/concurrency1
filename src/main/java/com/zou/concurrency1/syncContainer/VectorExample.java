package com.zou.concurrency1.syncContainer;


import com.zou.concurrency1.annotions.NotThreadSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@NotThreadSafe
public class VectorExample {


    //请求总数
    public static int clientAll = 5000;

    //并发数
    public static int threadAll = 200;

    private static Vector<Integer> list = new Vector<>();


    public static void main(String[] args) throws InterruptedException {


        ExecutorService executorService = Executors.newCachedThreadPool();

        // 允许的并发数
        final Semaphore semaphore = new Semaphore(threadAll);

        final CountDownLatch countDownLatch = new CountDownLatch(clientAll);


        //放入线程池中执行
        for (int i = 0; i < clientAll; i++) {
            final int count = i;

            executorService.execute(() -> {

                try {
                    semaphore.acquire(); //是否允许执行
                    update(count);
                    semaphore.release();//执行完成后释放
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                countDownLatch.countDown();
                System.out.println(list.size());


            });
        }

        countDownLatch.await();

        executorService.shutdown();//使用完线程 池后关闭
    }


    private static void update(int i) {

        list.add(i);

    }


}



































