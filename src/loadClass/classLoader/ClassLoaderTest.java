package loadClass.classLoader;

import loadClass.SubClass;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{

        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);

                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }

            }
        };

        Object obj = classLoader.loadClass("loadClass.SubClass").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof SubClass);

    }


}
