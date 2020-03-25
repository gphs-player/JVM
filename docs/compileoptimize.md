## 编译期早期的优化



#### 泛型类型擦除

虚拟机中不存在泛型。

#### 自动装箱拆箱

```java
        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=321;
        Integer f=321;
        Long g=3L;
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));

//        Integer var1 = Integer.valueOf(1);
//        Integer var2 = Integer.valueOf(2);
//        Integer var3 = Integer.valueOf(3);
//        Integer var4 = Integer.valueOf(3);
//        Integer var5 = Integer.valueOf(321);
//        Integer var6 = Integer.valueOf(321);
//        Long var7 = 3L;
//        System.out.println(var3 == var4);
//        System.out.println(var5 == var6);
//        System.out.println(var3.intValue() == var1.intValue() + var2.intValue());
//        System.out.println(var3.equals(var1.intValue() + var2.intValue()));
//        System.out.println(var7.longValue() == (long)(var1.intValue() + var2.intValue()));
//        System.out.println(var7.equals(var1.intValue() + var2.intValue()));
```

Integer有一个IntegerCache缓存池，-128~127，超出范围的对象会在堆上产生。

Integer的equals方法

```java
public boolean equals(Object obj) {
    if (obj instanceof Integer) {
        return value == ((Integer)obj).intValue();
    }
    return false;
}
```

Long的equals方法

```java
public boolean equals(Object obj) {
    if (obj instanceof Long) {
        return value == ((Long)obj).longValue();
    }
    return false;
}
```

#### 条件编译

```java
public class ConditionTest {
    public static void main(String [] args){
        if (true){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
```

上述代码编译优化之后就是

```java
public class ConditionTest {
    public ConditionTest() {
    }
    public static void main(String[] var0) {
        System.out.println("true");
    }
}
```

```java
if (false){
    System.out.println("");
}
```

编译之后就会忽略这段代码。

而下面代码，编译器拒绝编译“Unreachable statement”

```java
while (false){
    System.out.println("");
}
```

