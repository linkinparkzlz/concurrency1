package com.zou.concurrency1.commonUnsafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class DateFormatExample1 {


    //不是线程安全的
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");


    //请求总数
    public static int clientAll = 5000;

    //并发数
    public static int threadAll = 200;


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
                    update();
                    semaphore.release();//执行完成后释放
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                countDownLatch.countDown();


            });
        }

        countDownLatch.await();

        executorService.shutdown();//使用完线程 池后关闭
    }


    private static void update() {

        try {
            simpleDateFormat.parse("20180208");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}




































