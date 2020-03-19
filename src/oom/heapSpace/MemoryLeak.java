package oom.heapSpace;

import java.util.HashMap;
import java.util.Map;

/**
 * 内存泄漏
 * java.lang.OutOfMemoryError: Java heap space
 */
class MemoryLeak {
    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                return ((Key) obj).id.equals(id);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Map<Object, Object> m = new HashMap<>();
        while (true) {

//            for (int loop = 0; loop < 10; loop++) {
                for (int i = 0; i < 10; i++) {
                    if (!m.containsKey(new Key(i))) {
                        m.put(new Key(i), "Number:" + i);
                    }
                }
//            }
        System.out.println("----------");
        System.out.println(m.size());//真实数量会是多少
        System.out.println("----------");
        }
    }
}
