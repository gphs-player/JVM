package oom.permgen;

//import javassist.ClassPool;

/**
 * -XX:MaxPermSize=8m   但是已经被废弃了
 *
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=1M; support was removed in 8.0
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=1M; support was removed in 8.0
 */
public class MicroGenerator {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100_000_000; i++) {
            generate("eu.plumbr.demo.Generated" + i);
        }
    }

    public static Class generate(String name) throws Exception {
//        ClassPool pool = ClassPool.getDefault();
//        return pool.makeClass(name).toClass();
        return null;
    }
}
