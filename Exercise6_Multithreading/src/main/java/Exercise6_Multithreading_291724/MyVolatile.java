package Exercise6_Multithreading_291724;

import java.io.IOException;

class MyThread extends Thread {
    private volatile boolean run = true;

    public void run() {
        while (run) {
            System.out.println("Thread is running... press ENTER to stop");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread has been stopped.");
    }

    public void shutdown() {
        run = false;
    }
}

public class MyVolatile {
    public static void main(String[] args) throws IOException {
        MyThread thread = new MyThread();
        thread.start();

        System.out.println("Press ENTER anytime to stop the thread..");
        System.in.read(); // Waiting for ENTER key

        thread.shutdown();
    }
}

