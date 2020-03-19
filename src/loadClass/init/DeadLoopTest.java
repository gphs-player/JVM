package loadClass.init;

class DeadLoopTest {

    static class DeadLoop {
        static {
            if (true){

                System.out.println();
                while (true){

                }
            }
        }
    }


    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start");

                DeadLoop deadLoop = new DeadLoop();

                System.out.println(Thread.currentThread() + " end");
            }
        };
    }
}
