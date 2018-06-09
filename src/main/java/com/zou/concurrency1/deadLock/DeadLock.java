package com.zou.concurrency1.deadLock;


public class DeadLock implements Runnable {


    public static void main(String[] args) {

        DeadLock deadLock1 = new DeadLock();

        DeadLock deadLock2 = new DeadLock();

        deadLock1.flag = 1;
        deadLock2.flag = 0;

        new Thread(deadLock1).start();
        new Thread(deadLock2).start();
    }


    private static Object object1 = new Object();

    private static Object object2 = new Object();

    public int flag = 1;


    @Override
    public void run() {

        if (flag == 1) {
            synchronized (object1) {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (object2) {
                    System.out.println("flag == 1");
                }
            }
        }

        if (flag == 0) {
            synchronized (object2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("flag == 0");
                }
            }

        }

    }


}




































