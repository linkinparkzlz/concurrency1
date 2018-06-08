package com.zou.concurrency1.publish;

import com.zou.concurrency1.annotions.NotThreadSafe;

import java.util.Arrays;

@NotThreadSafe
public class UnsafePublish {


    private String[] states = {"a", "b", "c"};

    //通过public修饰符发布了这个类的域
    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {

        UnsafePublish unsafePublish = new UnsafePublish();

        System.out.println(Arrays.toString(unsafePublish.getStates()));

        //修改
        unsafePublish.getStates()[0] = "d";

        System.out.println(Arrays.toString(unsafePublish.getStates()));

    }


}
