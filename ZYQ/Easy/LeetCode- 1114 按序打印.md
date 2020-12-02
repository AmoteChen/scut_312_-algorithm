### LeetCode- 1114 按序打印

初次见面：

认识一下古里八怪的信号量们。

1. Semaphore

   ```java
   import java.util.concurrent.Semaphore;
   class Foo {
       public  Semaphore mutex1= new Semaphore(0);
       public  Semaphore mutex2= new Semaphore(0);
   
       public Foo() {
           
       }
   
       public void first(Runnable printFirst) throws InterruptedException {
           
           // printFirst.run() outputs "first". Do not change or remove this line.
           printFirst.run();
           mutex1.release();
       }
   
       public void second(Runnable printSecond) throws InterruptedException {
           mutex1.acquire();
           // printSecond.run() outputs "second". Do not change or remove this line.
           printSecond.run();
           mutex2.release();
           
       }
   
       public void third(Runnable printThird) throws InterruptedException {
           mutex2.acquire();
           // printThird.run() outputs "third". Do not change or remove this line.
           printThird.run();
       }
   }
   ```

   

2. CountDownLatch

   ```java
   import java.util.concurrent.CountDownLatch;
   
   class Foo {
       private CountDownLatch second = new CountDownLatch(1);
       private CountDownLatch third = new CountDownLatch(1);
       public Foo() {
   
       }
   
       public void first(Runnable printFirst) throws InterruptedException {
   
           // printFirst.run() outputs "first". Do not change or remove this line.
           printFirst.run();
           second.countDown();
       }
   
       public void second(Runnable printSecond) throws InterruptedException {
   
           second.await();
           // printSecond.run() outputs "second". Do not change or remove this line.
           printSecond.run();
           third.countDown();
       }
   
       public void third(Runnable printThird) throws InterruptedException {
   
           third.await();
           // printThird.run() outputs "third". Do not change or remove this line.
           printThird.run();
       }
   }
   ```

   