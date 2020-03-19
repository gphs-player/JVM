package loadClass;

/**
 * 类初始化,被动引用测试一
 * 这个地方会触发父类的初始化，但是不会触发子类的初始化
 */
public class InitTest {

    public static void main(String[] args) {
        System.out.println("------ "+SubClass.value);
    }

}
