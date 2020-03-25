package thread;

import java.util.Vector;

/**
 * Vector线程安全的测试
 */
public class VectorTest {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("removeThread删除");
                vector.add(i);
            }


            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println("removeThread删除");
                            vector.remove(i);
                        }
                    }
                }
            });


            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println("removeThread删除");
                            System.out.println(vector.get(i));
                        }
                    }
                }
            });


            removeThread.start();
            printThread.start();

            while (Thread.activeCount() > 30) {
                //不要产生过多的线程
            }
        }

    }
}
