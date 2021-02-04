package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* leetcode 第1115题-交替打印FooBar */

class FooBar2 {
    private int n;

    public FooBar2(int n) {
        this.n = n;
    }

    /* 此方法超出时间限制 */

    Lock lock = new ReentrantLock();
    volatile boolean permitFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n;) {
            lock.lock();
            try {
                if (permitFoo) {
                    // printFoo.run() output "foo". Do not change or remove this line.
                    printFoo.run();
                    i++;
                    permitFoo = false;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n;) {
            lock.lock();
            try {
                if (!permitFoo) {
                    // printFoo.run() output "bar". Do not change or remove this line.
                    printBar.run();
                    i++;
                    permitFoo = true;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
