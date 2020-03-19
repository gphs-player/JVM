package stack;

public class StackSOF {

    public int stackLength =1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
}
