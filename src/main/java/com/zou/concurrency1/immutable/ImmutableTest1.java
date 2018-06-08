package com.zou.concurrency1.immutable;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

public class ImmutableTest1 {


    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {

        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);


    }

    public static void main(String[] args) {

        map.put(1, 3); //  会抛出异常,不可变的map
        System.out.println(map.get(1));

    }

}
