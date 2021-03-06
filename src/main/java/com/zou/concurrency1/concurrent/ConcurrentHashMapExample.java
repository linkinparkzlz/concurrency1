package com.zou.concurrency1.concurrent;


import com.zou.concurrency1.annotions.NotThreadSafe;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@NotThreadSafe
public class ConcurrentHashMapExample {


    //请求总数
    public static int clientAll = 5000;

    //并发数
    public static int threadAll = 200;

    private static Map<Integer,Integer> map = new ConcurrentHashMap<>();


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
                System.out.println(map.size());


            });
        }

        countDownLatch.await();

        executorService.shutdown();//使用完线程 池后关闭
    }


    private static void update(int i) {

        map.put(i,i);

    }


}



































