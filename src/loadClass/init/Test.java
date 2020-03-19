package loadClass.init;

public class Test {

    static {
        i = 1;
        //不允许访问，只能访问定义在它之前的变量，可以赋值。
//        System.out.println(i);
    }

    static int i = 4;
}
