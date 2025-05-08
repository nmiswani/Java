package Exercise6_Multithreading_291724;

class MultiplicationThread extends Thread {
    private final int number;

    public MultiplicationThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + number + " * " + i + " = " + (number * i));
        }
    }
}

public class Multiplication {
    public static void main(String[] args) {
        Thread t1 = new MultiplicationThread(1);
        Thread t2 = new MultiplicationThread(2);
        Thread t3 = new MultiplicationThread(3);

        t1.start();
        t2.start();
        t3.start();
    }
}

