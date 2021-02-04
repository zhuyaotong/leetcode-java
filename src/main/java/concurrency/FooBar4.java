package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/* leetcode 第1115题-交替打印FooBar */

class FooBar4 {
    private int n;

    public FooBar4(int n) {
        this.n = n;
    }

    CyclicBarrier cb = new CyclicBarrier(2);
    volatile boolean fin = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!fin);
            // printFoo.run() output "foo". Do not change or remove this line.
            printFoo.run();
            fin = false;
            try {
                cb.await();
            } catch (BrokenBarrierException e) {}
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                cb.await();
            } catch (BrokenBarrierException e) {}
            // printFoo.run() output "bar". Do not change or remove this line.
            printBar.run();
            fin = true;
        }
    }
}
