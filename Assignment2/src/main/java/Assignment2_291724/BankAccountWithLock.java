package Assignment2_291724;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

public class BankAccountWithLock {
    private double balance;
    // Lock used to prevent race condition
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public BankAccountWithLock(double initialBalance) {
        this.balance = initialBalance;
    }

    // Read balance (shared lock)
    public double getBalance() {
        readLock.lock();
        try {
            System.out.printf("%s reads balance: RM%.2f%n", Thread.currentThread().getName(), balance);
            return balance;
        } finally {
            readLock.unlock();
        }
    }

    // Deposit money (exclusive lock)
    public void deposit(double amount) {
        writeLock.lock();
        try {
            System.out.printf("%s deposits: RM%.2f%n", Thread.currentThread().getName(), amount);
            balance += amount;
        } finally {
            writeLock.unlock();
        }
    }

    // Withdraw money (exclusive lock)
    public void withdraw(double amount) {
        writeLock.lock();
        try {
            if (balance >= amount) {
                System.out.printf("%s withdraws: RM%.2f%n", Thread.currentThread().getName(), amount);
                balance -= amount;
            } else {
                System.out.printf("%s insufficient funds for: RM%.2f%n", Thread.currentThread().getName(), amount);
            }
        } finally {
            writeLock.unlock();
        }
    }
}
