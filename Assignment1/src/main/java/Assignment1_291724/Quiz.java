package Assignment1_291724;

class Main implements Runnable {
    private final int number;

    public Main (int number) {
        this. number = number;
    }

    @Override
    public void run () {
        for (int i = 1; i <= 2; i++) {
            System.out.printf("%s: %d * %d = %d\n",
            Thread.currentThread().getName(), number, i, i * number) ;
        }
    }
}

public class Quiz {
    public static void main (String[] args){
        for (int i = 2; i <= 6; i += 2) {
            Thread thread = new Thread (new Main (i),
                    "Thread-" + i);
            thread.start();
        }
    }
}

