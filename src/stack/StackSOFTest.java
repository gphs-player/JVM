package stack;


import java.lang.ref.PhantomReference;

/**
 * VM Args: -Xss160k
 * 模拟栈溢出StackOverflowError
 */
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

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
