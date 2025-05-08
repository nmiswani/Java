package Tutorial8_291724;

import java.util.concurrent.atomic.AtomicInteger; // New modification
// AtomicInteger; Jaga nilai count dalam multithreading

class TestAtomicInteger1p {

    public static void main(String[] args) throws InterruptedException {

        CountProblem pt = new CountProblem();
        Thread t1 = new Thread(pt, "t1");
        Thread t2 = new Thread(pt, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count=" + pt.getCount());
    }
}

class CountProblem implements Runnable {

    // private int count;
    private AtomicInteger count = new AtomicInteger(0); // New modification
    // to prevent race condition bila 2 thread jalan serentak

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            processSomething(i);
            count.incrementAndGet(); // New modification // thread-safe version
        }
    }

    public int getCount() {
        return this.count.get(); // New modification
    }

    private void processSomething(int i) {
        try {
            Thread.sleep(i * 200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

