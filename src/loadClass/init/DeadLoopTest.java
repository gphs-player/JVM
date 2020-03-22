package loadClass.init;

class DeadLoopTest {

    static class DeadLoop {
        static {
            if (true) {
                System.out.println(Thread.currentThread()+"init DeadLoop");
                while (true) {

                }
            }
        }
    }


    public static void main(String[] args) {
        Runnable script = () -> {
            System.out.println(Thread.currentThread() + " start");
            //DeadLoop初始化被阻塞，两个线程都不会打印end
            DeadLoop deadLoop = new DeadLoop();

            System.out.println(Thread.currentThread() + " end");
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
