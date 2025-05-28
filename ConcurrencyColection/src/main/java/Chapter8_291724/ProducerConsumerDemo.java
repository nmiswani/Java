package Chapter8_291724;

public class ProducerConsumerDemo {
    static class SharedData {
        private boolean dataReady = false;
        private String data;

        // Producer thread
        public synchronized void produce() {
            try {
                System.out.println("Producer: Preparing data...");
                Thread.sleep(1000); // Simulate time to produce data data =
                data = "Hello from producer";
                dataReady = true;
                System.out.println("Producer: Data is ready.");
                notify();
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Consumer thread
        public synchronized void consume() {
            try {
                while (!dataReady) {
                        System.out.println("Consumer: Waiting for data...");
                        wait(); // Release lock and wait to be notified
                }
                System.out.println("Consumer: Received -> " + data);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

