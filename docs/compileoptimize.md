## 编译期的优化



#### 泛型擦除



#### 自动装箱拆箱



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

