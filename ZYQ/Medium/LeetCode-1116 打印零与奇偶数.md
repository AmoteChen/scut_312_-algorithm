### LeetCode-1116 打印零与奇偶数

#### [1116. 打印零与奇偶数](https://leetcode-cn.com/problems/print-zero-even-odd/)

多消费者问题情景1 打印奇偶数

```java
class ZeroEvenOdd {
    private int n;
    Semaphore zeroSemaphore = new Semaphore(1);
    Semaphore evenSemaphore = new Semaphore(0);
    Semaphore oddSemaphore = new Semaphore(0);
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0;i<n;i++){
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if((i&1)==0)
            evenSemaphore.release();
            else oddSemaphore.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i+=2){
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
        
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i+=2){
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }
}
```

