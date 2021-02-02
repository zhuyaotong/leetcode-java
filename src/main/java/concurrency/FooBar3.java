package concurrency;

class FooBar3 {
    private int n;

    public FooBar3(int n) {
        this.n = n;
    }

    /* 此方法超出时间限制 */

    volatile boolean permitFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            if (permitFoo) {
                // printFoo.run() output "foo". Do not change or remove this line.
                printFoo.run();
                i++;
                permitFoo = false;
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            if (!permitFoo) {
                // printFoo.run() output "bar". Do not change or remove this line.
                printBar.run();
                i++;
                permitFoo = true;
            }
        }
    }
}
