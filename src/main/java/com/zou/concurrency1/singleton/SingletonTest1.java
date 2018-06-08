package com.zou.concurrency1.singleton;


import com.zou.concurrency1.annotions.ThreadSafe;

/**
 * 饿汉单例
 * 单例在类装载时进行创建
 */
@ThreadSafe
public class SingletonTest1 {


    //私有构造方法
    private SingletonTest1() {

    }

    //单例对象
    private static SingletonTest1 instance = new SingletonTest1();

    //静态工厂方法
    public static SingletonTest1 getInstance() {


        return instance;
    }

}
