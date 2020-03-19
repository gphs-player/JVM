package oom.thread;

/**
 * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 at java.lang.Thread.start0(Native Method)
 at java.lang.Thread.start(Thread.java:714)
 at oom.thread.ThreadLimitTest.main(ThreadLimitTest.java:15)

 */
public class ThreadLimitTest {


    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(10000000);
                    } catch (InterruptedException e) {
                    }
                }
            }).start();
        }
    }

}
