package com.zou.concurrency1.singleton;


public class SingletonTest2 {


    //私有构造方法
    private SingletonTest2() {

    }

    //单例对象
    private static volatile SingletonTest2 instance = null;

    //静态工厂方法
    public static SingletonTest2 getInstance() {

        if (instance == null) { //双重检测机制
            synchronized (SingletonTest1.class) {

                if (instance == null) {
                    instance = new SingletonTest2();
                }

            }

        }

        return instance;
    }

}
