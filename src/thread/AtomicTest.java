package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 不使用synchronize实现的同步
 */
public class AtomicTest {

    static AtomicInteger race = new AtomicInteger(0);

    private static final int THREADS_COUNT = 20;

    public static void increase() {
        race.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {

            System.out.println(Thread.activeCount());
            System.out.println(race);
        }
    }
}
