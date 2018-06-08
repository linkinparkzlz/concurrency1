package com.zou.concurrency1.singleton;



import com.zou.concurrency1.annotions.NotThreadSafe;

@NotThreadSafe
public class SingletonTest3 {


    //私有构造方法
    private SingletonTest3() {

    }

    //单例对象
    private static SingletonTest3 instance = null;

    //静态工厂方法
    public static SingletonTest3 getInstance() {

        if (instance == null) {
            instance = new SingletonTest3();
        }

        return instance;
    }

}
