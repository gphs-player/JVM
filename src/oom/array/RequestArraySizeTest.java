package oom.array;

/**
 * “java.lang.OutOfMemoryError: Requested array size exceeds VM limit”
 *
 *
 *
 * java.lang.OutOfMemoryError: Java heap space
 at oom.array.RequestArraySizeTest.main(RequestArraySizeTest.java:11)
 java.lang.OutOfMemoryError: Java heap space
 at oom.array.RequestArraySizeTest.main(RequestArraySizeTest.java:11)
 java.lang.OutOfMemoryError: Requested array size exceeds VM limit
 at oom.array.RequestArraySizeTest.main(RequestArraySizeTest.java:11)
 java.lang.OutOfMemoryError: Requested array size exceeds VM limit
 at oom.array.RequestArraySizeTest.main(RequestArraySizeTest.java:11)
 *
 *
 * Java 的数组是以int为索引的，Java中int的最大值“ 2^31 – 1 = 2,147,483,647”
 */
public class RequestArraySizeTest {

    public static void main(String[] args) {
        for (int i = 3; i >= 0; i--) {
            try {
                int[] arr = new int[Integer.MAX_VALUE - i];
                System.out.format("Successfully initialized an array with %,d elements.\n", Integer.MAX_VALUE - i);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

}
