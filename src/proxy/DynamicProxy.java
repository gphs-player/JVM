package proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }


    static class DynamicHello implements InvocationHandler {

        Object obj;

        Object bind(Object origin) {
            this.obj = origin;
            return Proxy.newProxyInstance(origin.getClass().getClassLoader(), origin.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome ");
            return method.invoke(obj, args);
        }
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        IHello hello = (IHello) new DynamicHello().bind(new Hello());
        hello.sayHello();

    }

}
