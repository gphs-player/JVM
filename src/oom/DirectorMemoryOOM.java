package oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectorMemoryOOM {
    private static int _1M = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        while (true){
            unsafe.allocateMemory(_1M);
        }

    }
}
