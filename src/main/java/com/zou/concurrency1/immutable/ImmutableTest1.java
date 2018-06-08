package com.zou.concurrency1.immutable;

import com.google.common.collect.Maps;

import java.util.Map;

public class ImmutableTest1 {


    private final static Integer a = 1;

    private final static String b = "2";

    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {

        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);

    }

    public static void main(String[] args) {

        // a = 2; //不允许
        //  map = Maps.newHashMap(); //不允许

    }

}
