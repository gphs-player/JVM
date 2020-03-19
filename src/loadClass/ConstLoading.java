package loadClass;

public class ConstLoading {

    static {

        System.out.println("ConstLoading init !!!");

    }

    public static final String HELLO ="HELLO";

}
class NotInit{
        public static void main(String [] args){

            //也不会实例化ConstLoading,编译阶段的优化，常量已经传输到了此类的常量池，编译完成之后，两个类就不存在联系了
            System.out.println(ConstLoading.HELLO);
        }

}




