package com.zyq.concurrent_test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.zyq.concurrent_test.Food;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producer implements Runnable{
    private  Food foo;
    private  Semaphore mutex = null;
    private Semaphore empty=null;
    private  Semaphore full=null;

    public void produce(){
        try {
            while(true) {
                Thread.sleep(100);
                empty.acquire();
                mutex.acquire();
                foo.produceFood();
                System.out.println("Food produced, now " + Food.getFood() + " left!");
                mutex.release();
                full.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run(){
        produce();
    }
}
