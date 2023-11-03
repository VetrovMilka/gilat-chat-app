package org.students.ninjas;

public class Main {
    public static void main(String[] args) {
        IncrementThread incrementThread = new IncrementThread();
        incrementThread.start();

        while (IncrementThread.getCounter().get() < 100) {
            System.out.println("Main thread incremented value: " + IncrementThread.getCounter().incrementAndGet());
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
