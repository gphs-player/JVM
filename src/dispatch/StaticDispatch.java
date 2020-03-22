package dispatch;

/**
 * 静态分派
 */
public class StaticDispatch {

    static abstract class Human{

    }
    static class Man extends Human{

    }

    static class Women extends Human{

    }


    public void sayHello(Human human){
        System.out.println("hello guy");
    }

    public void sayHello(Man man){
        System.out.println("hello man");
    }

    public void sayHello(Women women){
        System.out.println("hello women");
    }

    public static void main(String [] args){
        Human man = new Man();
        Human woman = new Women();

        StaticDispatch overLoad = new StaticDispatch();
        //两个方法只会打印 hello guy
        overLoad.sayHello(man);
        overLoad.sayHello(woman);
        //hello man
        //hello women
        overLoad.sayHello((Man) man);
        overLoad.sayHello((Women)woman);

    }

}

