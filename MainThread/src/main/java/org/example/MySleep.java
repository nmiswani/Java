//public class MySleep extends Thread {
//    public static void main(String[] args) {
//        new Thread(new MySleep()).start();
//    }
//    @Override
//    public void run() {
//        try {
//            for (int x = 0; x < 1000; x++) {
//                System.out.println(x);
//                sleep(2000);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

package org.example;    //291724

public class MySleep extends Thread {
    public static void main(String[] args) {
        new Thread(new MySleep()).start();
    }

    @Override
    public void run() {
        final int count = 20;
        try {
            for (int i = 1; i <= count; i++) {
                RunThread thread = new RunThread(i);
                thread.start();
                thread.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class RunThread extends Thread {
        private final int id;

        public RunThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                print("ONE");
                sleep(200);
                print("TWO");
                sleep(200);
                print("THREE");
                sleep(200);
                print("xxxxxxxxxx");
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void print(String message) {
            System.out.format("Thread %d: %s%n", id, message);
        }
    }
}
