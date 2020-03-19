package loadClass;

public class LoadingTest {
    public static void main(String [] args){
        //这里也不会初始化SuperClass，因为实例化的是"SuperClass"的数组
        SuperClass[] superClasses = new SuperClass[10];
    }
}
