package com.zou.concurrency1.aqs;

import java.util.concurrent.*;

public class FutureExample1 {

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(5000);
            return "Done";
        }
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {


        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> future = executorService.submit(new MyCallable());

        System.out.println("doSomething");

        Thread.sleep(1000);

        //获得执行结果
        String result = future.get();

        System.out.println(result);


    }


}
