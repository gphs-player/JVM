

定义一个简单的类

```java
public class ClassTest {
    private int m;
    public int inc(){
        return m+1;
    }
}
```

编译之后查看,通过命苦命令`xxd clazz/ClassTest.class`

```
00000000: cafe babe 0000 0034 0013 0a00 0400 0f09  .......4........
00000010: 0003 0010 0700 1107 0012 0100 016d 0100  .............m..
00000020: 0149 0100 063c 696e 6974 3e01 0003 2829  .I...<init>...()
00000030: 5601 0004 436f 6465 0100 0f4c 696e 654e  V...Code...LineN
00000040: 756d 6265 7254 6162 6c65 0100 0369 6e63  umberTable...inc
00000050: 0100 0328 2949 0100 0a53 6f75 7263 6546  ...()I...SourceF
00000060: 696c 6501 000e 436c 6173 7354 6573 742e  ile...ClassTest.
00000070: 6a61 7661 0c00 0700 080c 0005 0006 0100  java............
00000080: 0f63 6c61 7a7a 2f43 6c61 7373 5465 7374  .clazz/ClassTest
00000090: 0100 106a 6176 612f 6c61 6e67 2f4f 626a  ...java/lang/Obj
000000a0: 6563 7400 2100 0300 0400 0000 0100 0200  ect.!...........
000000b0: 0500 0600 0000 0200 0100 0700 0800 0100  ................
000000c0: 0900 0000 1d00 0100 0100 0000 052a b700  .............*..
000000d0: 01b1 0000 0001 000a 0000 0006 0001 0000  ................
000000e0: 0003 0001 000b 000c 0001 0009 0000 001f  ................
000000f0: 0002 0001 0000 0007 2ab4 0002 0460 ac00  ........*....`..
00000100: 0000 0100 0a00 0000 0600 0100 0000 0700  ................
00000110: 0100 0d00 0000 0200 0e                   .........
```



[class文件的常量池标记对照表](https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html)

| Constant Kind                 | Tag  | Section                                                      |
| ----------------------------- | ---- | ------------------------------------------------------------ |
| `CONSTANT_Class`              | 7    | [§4.4.1](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.1) |
| `CONSTANT_Fieldref`           | 9    | [§4.4.2](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.2) |
| `CONSTANT_Methodref`          | 10   | [§4.4.2](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.2) |
| `CONSTANT_InterfaceMethodref` | 11   | [§4.4.2](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.2) |
| `CONSTANT_String`             | 8    | [§4.4.3](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.3) |
| `CONSTANT_Integer`            | 3    | [§4.4.4](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.4) |
| `CONSTANT_Float`              | 4    | [§4.4.4](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.4) |
| `CONSTANT_Long`               | 5    | [§4.4.5](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.5) |
| `CONSTANT_Double`             | 6    | [§4.4.5](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.5) |
| `CONSTANT_NameAndType`        | 12   | [§4.4.6](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.6) |
| `CONSTANT_Utf8`               | 1    | [§4.4.7](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.7) |
| `CONSTANT_MethodHandle`       | 15   | [§4.4.8](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.8) |
| `CONSTANT_MethodType`         | 16   | [§4.4.9](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.9) |
| `CONSTANT_Dynamic`            | 17   | [§4.4.10](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.10) |
| `CONSTANT_InvokeDynamic`      | 18   | [§4.4.10](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.10) |
| `CONSTANT_Module`             | 19   | [§4.4.11](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.11) |
| `CONSTANT_Package`            | 20   | [§4.4.12](https://docs.oracle.com/javase/specs/jvms/se14/html/jvms-4.html#jvms-4.4.12) |



参考

https://docs.oracle.com/javase/specs/jvms/se14/html/index.html

