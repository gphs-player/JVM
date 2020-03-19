package assign;

/**
 * 对象分配区域测试
 * 提前分配在Eden区域，待分配内存不足的时候通过担保机制分配给老年区域
 *
 * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * -XX:PretenureSizeThreshold 此参数可以直接分配大于此参数值的对象到老年区，但是区分虚拟机
 */
public class AssignTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        byte[] allocation1,allocation2,allocation3,allocation4;
//        allocation1 = new byte[2 * _1MB];
//        allocation2 = new byte[2 * _1MB];
//        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[7 * _1MB];

    }

}
