package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 不会通过编译的，虽然虚拟机验证方法的重载会考虑返回值，但是编译器不允许
 */
public class GenericTypes {

    public static String method(List<String> list ){
        System.out.println("invoke method List<String>");
        return "";
    }

//    public static int method(List<Integer> list ){
//        System.out.println("invoke method List<Integer>");
//        return 0;
//    }
    public static void main(String [] args){

        method(new ArrayList<String>());
//        method(new ArrayList<Integer>());

    }
}
