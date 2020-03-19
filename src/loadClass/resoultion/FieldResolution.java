package loadClass.resoultion;

public class FieldResolution {


    interface InterFace0{
        int A = 0;
    }

    interface InterFace1 extends InterFace0{
        int A = 1;
    }
    interface InterFace2{
        int A = 2;
    }

    static class Parent implements InterFace1{
        public static int A = 3;
    }

    static class Sub extends Parent implements InterFace2{
        public static int A = 4;
    }

    public static void main(String [] args){
        System.out.println(Sub.A);
    }

}
