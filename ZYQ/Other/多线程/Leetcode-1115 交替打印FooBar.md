### Leetcode-1115 交替打印FooBar



一开始以为是生产者消费者问题，乱用了四个信号量。虽然也AC了，但要是面试估计挂的惨不忍睹。

只需两个信号量，类似红绿灯问题。

一个信号量控制foo的打印，另一个信号量控制bar的打印。

只要初始时保证bar的初始量为0，就不会提前打印bar。

```java
class FooBar {
    private int n;
    private Semaphore bar = new Semaphore(0);
    private Semaphore foo = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            foo.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            foo.release();
        }
    }
}
```

