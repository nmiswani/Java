package Week_04;    //291724

class ThreadRunnable {

    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        System.out.println(t.getState());
    }
}