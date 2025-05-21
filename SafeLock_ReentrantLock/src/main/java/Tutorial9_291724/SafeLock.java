package Tutorial9_291724;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

public class SafeLock {

    // Class Friend - two friends trying to bow to each other
    static class Friend {
        private final String name;
        private final Lock lock = new ReentrantLock(); // Lock for (safe access)

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        // Try to obtain both locks
        public boolean impendingBow(Friend bower) {
            Boolean myLock = false;
            Boolean yourLock = false;
            try {
                myLock = lock.tryLock(); // Try lock for 'this'
                yourLock = bower.lock.tryLock(); // Try lock for 'bower'
            } finally {
                if (!(myLock && yourLock)) {
                    if (myLock) {
                        lock.unlock();
                    }
                    if (yourLock) {
                        bower.lock.unlock();
                    }
                }
            }
            return myLock && yourLock;
        }

        // Method bow — simulate bowing to another friend
        public void bow(Friend bower) {
            if (impendingBow(bower)) { // Continue if both locks diperoleh
                try {
                    System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
                    bower.bowBack(this); // Call bowBack
                } finally {
                    // Lepaskan lock after use
                    lock.unlock();
                    bower.lock.unlock();
                }
            } else {
                System.out.format("%s: %s started to bow to me, but saw that I was already bowing to him.%n",
                        this.name, bower.getName());
            }
        }

        // Method bowBack
        public void bowBack(Friend bower) {
            System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
        }
    }

    // Runnable class — loop bow between 2 friends in different thread
    static class BowLoop implements Runnable {
        private Friend bower;
        private Friend bowee;

        public BowLoop(Friend bower, Friend bowee) {
            this.bower = bower;
            this.bowee = bowee;
        }

        public void run() {
            Random random = new Random();
            for (;;) { // Loop infinity
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {}
                bowee.bow(bower); // 'bowee' cuba bow kepada 'bower'
            }
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        new Thread(new BowLoop(alphonse, gaston)).start();
        new Thread(new BowLoop(gaston, alphonse)).start();
    }
}
