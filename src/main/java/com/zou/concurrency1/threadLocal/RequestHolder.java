package com.zou.concurrency1.threadLocal;

public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();


    //添加数据
    public static void add(Long id) {

        requestHolder.set(id);
    }

    public static Long getId() {

        return requestHolder.get();
    }

    // 移除
    public static void remove() {

        requestHolder.remove();
    }




}














































