package com.zou.concurrency1.atomic;


import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 更新某个类的某个字段的值
 */

public class AtomicReferenceFieldUpdaterTest {


    private static AtomicIntegerFieldUpdater<AtomicReferenceFieldUpdaterTest> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicReferenceFieldUpdaterTest.class, "count");

    private volatile int count = 100;

    public int getCount() {
        return count;
    }

    private static AtomicReferenceFieldUpdaterTest atomicReferenceFieldUpdaterTest =
            new AtomicReferenceFieldUpdaterTest();

    public static void main(String[] args) {

        if (updater.compareAndSet(atomicReferenceFieldUpdaterTest, 100, 120)) {

            System.out.println("success, " + atomicReferenceFieldUpdaterTest.getCount());
        }

        if (updater.compareAndSet(atomicReferenceFieldUpdaterTest, 100, 120)) {

            System.out.println("success, " + atomicReferenceFieldUpdaterTest.getCount());
        } else {

            System.out.println("filed, " + atomicReferenceFieldUpdaterTest.getCount());
        }

    }


}
