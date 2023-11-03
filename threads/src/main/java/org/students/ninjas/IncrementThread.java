package org.students.ninjas;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementThread extends Thread {
    private static final AtomicInteger counter = new AtomicInteger(0);

    public void run() {
        while (counter.get() < 100) {
            System.out.println("Incremented value: " + counter.incrementAndGet());
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static AtomicInteger getCounter() {
        return counter;
    }
}
