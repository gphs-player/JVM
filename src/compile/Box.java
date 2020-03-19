package compile;

public class Box {

    public static void main(String [] args){
        //(-128,127] 取值范围不需要new Integer对象



        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;

        Long g = 3L;



        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println("c == d ? " + (c == d));
        System.out.println("e == f ? " + (e == f));
        //装箱的==运算在不遇到算术运算的情况下不会自动拆箱
        System.out.println("c = a + b ? " + (c == (a + b)));
        System.out.println("g = a + b ? " + (g == (a + b)));
        System.out.println("c equals a + b ? " + (c.equals(a + b)));
        //装箱类型不处理数据类型转换的问题
        System.out.println("g equals a + b ? " + (g.equals(a + b)));

    }


}
