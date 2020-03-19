package oom.heapSpace;

/**
 * 访问量激增
 * java.lang.OutOfMemoryError: Java heap space
 * -Xmx12m
 */
public class HeapSpace {

    static final int SIZE = 20 * 1024 * 1024;

    public static void main(String[] a) {
        int[] i = new int[SIZE];
    }
}
