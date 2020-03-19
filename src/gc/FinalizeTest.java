package gc;

/**
 * 对象进行可达性分析之后，如果没有引用链。
 *该对象会被做一次标记并进行筛选，筛选的依据就是是否有必要执行finalize方法，
 * 当对象没有覆写此方法或者已经调用过一次了，那么就被视为"没有必要执行"
 * 如果对象被判定为有必要执行finalize方法之后，会被扔进F-QUEUE中，稍后虚拟机会触发这个方法，
 * （虚拟机不会等待方法结束）。
 * finalize方法是对象逃脱死亡的最后一次机会。GC对F-Queue中的对象进行第二次标记，如果对象要存活，
 * 那么重新引用对象关联即可。这是它就会被移除出"即将回收"集合，如果找对象还没有逃脱，就会被回收。
 */
public class FinalizeTest {

    public static FinalizeTest SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes , I'm still alive");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize execute .....");
        //拯救它一次
        SAVE_HOOK = this;
    }

    public static void main(String [] args) throws InterruptedException {


        SAVE_HOOK = new FinalizeTest();
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);

        if (SAVE_HOOK !=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("SAVE_HOOK is dead");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);

        if (SAVE_HOOK !=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("SAVE_HOOK is dead");
        }


    }

}
