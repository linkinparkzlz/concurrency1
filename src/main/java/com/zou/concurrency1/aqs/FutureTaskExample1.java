package com.zou.concurrency1.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample1 {


    public static void main(String[] args) throws InterruptedException, ExecutionException {


        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("do  something in callable");
                Thread.sleep(5000);

                return "Done";
            }
        });

        new Thread(futureTask).start();

        System.out.println("do  something main");

        Thread.sleep(1000);

        String result = futureTask.get();

        System.out.println(result);


    }


}




























