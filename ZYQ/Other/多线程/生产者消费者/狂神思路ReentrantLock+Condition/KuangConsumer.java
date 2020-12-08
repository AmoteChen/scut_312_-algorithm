package com.zyq.concurrent_test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KuangConsumer {
    public static void main(String[] args) {
        Data  data = new Data();
         new Thread(()->{for (int i = 0; i <10 ; i++) data.printA();}).start();
         new Thread(()->{for (int i = 0; i <10 ; i++) data.printB();}).start();
         new Thread(()->{for (int i = 0; i <10 ; i++) data.printC();}).start();
    }
}
class Data{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printA()  {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            System.out.println("A");
            number =2;
            condition2.signal();
        }
        catch (InterruptedException  e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            System.out.println("B");
            number = 3;
            condition3.signal();
        }
        catch (InterruptedException  e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            System.out.println("C");
            number = 1;
            condition1.signal();
        }
        catch (InterruptedException  e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}
