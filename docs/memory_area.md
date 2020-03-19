## JVM-内存区域

### 运行时数据区域

<Img src="./pics/runtimearea.png" width=400 align=left>

* 蓝色为线程共享区域
* 灰色为线程私有区域

#### 1.方法区

线程共享，存放已被虚拟机加载的类信息、常量、静态变量等数据。

* 运行时常量池，字面常量和符号引用

#### 2.虚拟机栈

线程私有，声明周期和线程同步，描述JAVA方法执行时候的内存模型。方法执行的时候创建栈帧，存储**局部变量**、方法出口等。

* 线程请求的栈的深度大于虚拟机允许的深度，抛出StackOverFlow
* 虚拟机动态扩展无法申请到足够内存，抛出OOM

#### 3.本地方法栈

和虚拟机栈作用类似，但是为Native方法服务

#### 4.程序计数器

当前线程所执行的字节码的行号指示器，字节码解释器通过改变计数器的值选取下一条执行的指令。

* 某一时刻，处理器只会执行一个线程的某条指令，在多线程的切换之后，为了恢复到正确位置，每个线程都有一个独立的计数器

#### 5.堆

所有线程共享。唯一目的就是存放对象实例，是JVM管理的最大的一块内存。

* 也被称为GC堆，因为是垃圾收集器管理的主要区域。

#### 6.对象访问示例

`Object obj = new Object();`

* `Object obj` 作为一个reference类型反映到虚拟机栈的本地变量表
* `new Object()`反应到Java堆
* 堆中包含`Object`的对象类型数据（对象类型、父类、接口信息），这些信息存放在方法区域

reference访问对象的方式主流两种

* 句柄方式访问

  会在堆中创建句柄池，reference指向的是句柄，句柄包含指向对象实例和类型的信息

  优点在于，对象改变的时候不需要改动reference

  <Img src="./pics/reference_a.png" height=300 align=left>

* 直接指针方式

  reference指向的就是对象

  优点在于节省一次指针定位的开销，积少成多

<Img src="./pics/reference_b.png" height=300 align=left>





### 实战OOM

#### 1.堆溢出

```java
/**
 * -verbose:gc
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -XX:+PrintGCDetails
 * -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject{}
    public static void main(String [] args){
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
```

#### 2.虚拟机栈本地方法栈

这里抛出的异常是`StackOverflowError`，并不是OOM，在栈中两种异常有重叠情况。

```java
//  -Xss128k
public class StackSOFTest {
    public static void main(String[] args) {
        StackSOF stackSOF = new StackSOF();
        try {
            stackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length :" + stackSOF.stackLength);
            e.printStackTrace();
        }
    }
}
public class StackSOF {
    public int stackLength =1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
}
```

#### 3.运行时常量池

虚拟机参数PermSize已经被废弃了，改为MetaspaceSize

```java
//-XX:MetaspaceSize=500k -XX:MaxMetaspaceSize=500k
public class RuntimeConstansPoolOOM {
    public static void main(String [] args){

        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
```