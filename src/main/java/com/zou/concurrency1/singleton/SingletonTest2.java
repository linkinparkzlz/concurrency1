package com.zou.concurrency1.singleton;

//懒汉单例  多线程环境下会有线程安全问题

import com.zou.concurrency1.annotions.NotThreadSafe;

@NotThreadSafe
public class SingletonTest2 {


    //私有构造方法
    private SingletonTest2() {

    }

    //单例对象
    private static SingletonTest2 instance = null;

    //静态工厂方法
    public static SingletonTest2 getInstance() {

        if (instance == null) {
            instance = new SingletonTest2();
        }

        return instance;
    }

}
