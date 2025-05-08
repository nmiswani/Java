package org.example;

public class ThreadExample2{
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread Running");
            System.out.println("MyThread Finished");
        }
    }
    public static void main (String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
