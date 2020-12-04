package com.zyq.concurrent_test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer implements  Runnable{
    protected Food foo;
    private Semaphore mutex = null;
    private Semaphore empty=null;
    private  Semaphore full = null;

    public void comsume(){
        try {
            while(true) {
                Thread.sleep(100);
                full.acquire();
                mutex.acquire();
                foo.comsumeFood();
                System.out.println("Food Consumed, now " + Food.getFood() + " left!");
                mutex.release();
                empty.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run(){
        comsume();
    }
}
