package oom.limit;

import java.util.Map;
import java.util.Random;

/**
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
 *
 * -Xmx50m
 * -XX:+UseParallelGC
 *
 * -XX:-UseGCOverheadLimit  这个参数就可以暂时避免错误，但是强烈不建议
 */
public class Wrapper {

    public static void main(String [] args){
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "valuevaluevalue");
        }
    }

}
