package dispatch;

/**
 * 静态分派
 */
public class OverLoad {


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

        OverLoad overLoad = new OverLoad();
        overLoad.sayHello(man);
        overLoad.sayHello(woman);

    }

}

