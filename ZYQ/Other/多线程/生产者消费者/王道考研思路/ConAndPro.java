package com.zyq.concurrent_test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConAndPro {
    public static void main(String[] args) {
        // 王道考研思路实现生产者消费者。
        Food foo = new Food();
        Semaphore mutex = new Semaphore(1);
        Semaphore full = new Semaphore(foo.getFood());
        Semaphore empty= new Semaphore(10);
        Consumer con = new Consumer(foo,mutex,empty,full);
        Producer pro = new Producer(foo,mutex,empty,full);

        for(int i=0;i<3;i++){
            Thread th = new Thread(pro);
            th.start();
        }
        for(int j=0;j<3;j++){
            Thread th = new Thread(con);
            th.start();
        }

    }
}
