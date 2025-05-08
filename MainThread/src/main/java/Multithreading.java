public class Multithreading {
    public static void main(String[] args) {
        // System.out.println(Thread.currentThread().getName());
        // System.out.println(Thread.currentThread().getId());

        for (int i = 0; i < 5; i++) {
            MultithreadThing myThing = new MultithreadThing(i);
            myThing.start();
        }
    }
}
