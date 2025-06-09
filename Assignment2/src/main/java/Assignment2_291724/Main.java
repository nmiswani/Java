package Assignment2_291724;

public class Main {
    public static void main(String[] args) {
        // Set initial balance 500
        BankAccountWithLock account = new BankAccountWithLock(500);

        // Thread for read balance
        Runnable reader = () -> {
            // Loop to read balance 3 times
            for (int i = 0; i < 3; i++) {
                account.getBalance();  // Read balance using readLock()
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Thread for deposit money
        Runnable depositor = () -> {
            // Loop to deposit twice
            for (int i = 0; i < 2; i++) {
                account.deposit(300); // Deposit 300 with writeLock()
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Thread for withdraw money
        Runnable withdrawer = () -> {
            // Loop to withdraw twice
            for (int i = 0; i < 2; i++) {
                account.withdraw(500); // Withdraw 500 with writeLock()
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Create threads for each task
        Thread t1 = new Thread(reader, "Reader");
        Thread t2 = new Thread(depositor, "Depositor");
        Thread t3 = new Thread(withdrawer, "Withdrawer");

        // Start to run concurrently
        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads to finish before exiting main thread
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
