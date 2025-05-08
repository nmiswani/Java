package Week_04;    //291724

class ThreadStatesInJava {

    public static void main(String[] args) {
        Thread.State[] states = Thread.State.values();

        for (Thread.State state : states) {
            System.out.println(state);
        }
    }
}