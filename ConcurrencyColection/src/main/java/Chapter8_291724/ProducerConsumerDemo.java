package Chapter8_291724;

public class ProducerConsumerDemo {

    static class SharedData {
        private boolean dataReady = false;
        private String data;

        // Producer method
        public synchronized void produce() {
            try {
                System.out.println("Producer: Preparing data...");
                Thread.sleep(1000); // Simulate time to produce data
                data = "Hello from producer";
                dataReady = true;
                System.out.println("Producer: Data is ready.");
                notifyAll(); // Notify all waiting threads
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Consumer method
        public synchronized void consume() {
            try {
                while (!dataReady) {
                    System.out.println(Thread.currentThread().getName() + ": Waiting for data...");
                    wait(); // Release lock and wait to be notified
                }
                System.out.println(Thread.currentThread().getName() + ": Received -> " + data);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        // Create multiple consumer threads
        Thread consumerThread1 = new Thread(() -> sharedData.consume(), "Consumer 1");
        Thread consumerThread2 = new Thread(() -> sharedData.consume(), "Consumer 2");
        Thread consumerThread3 = new Thread(() -> sharedData.consume(), "Consumer 3");

        // Create producer thread
        Thread producerThread = new Thread(() -> sharedData.produce());

        // Start consumers
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();

        // Delay starting the producer thread
        try {
            Thread.sleep(500); // Let the consumers start and wait
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        producerThread.start();
    }
}
