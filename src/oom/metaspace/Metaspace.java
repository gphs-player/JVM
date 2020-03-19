package oom.metaspace;

/**
 * -XX:MaxMetaspaceSize=10m
 * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
 */
public class Metaspace {
//    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String[] args) throws Exception {
        for (int i = 0; ; i++) {
//            Class c = cp.makeClass("eu.plumbr.demo.Generated" + i).toClass();
        }
    }
}
