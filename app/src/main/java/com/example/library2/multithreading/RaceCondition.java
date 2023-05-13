package com.example.library2.multithreading;

import java.io.Console;

public class RaceCondition implements Runnable {
    private int count;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100L);
                ++count;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        RaceCondition r = new RaceCondition();
        Thread t1 = new Thread(r);
        t1.start();


        Thread t2 = new Thread(r);
        t2.start();

       /* Thread t3 = new Thread(r);
        t3.start();*/
        t1.join();
        t2.join();


        System.out.println("Count" + r.count);

    }
}
