package thread;

public class StrContact {
    public String contactStr(String s1,String s2,String s3){
        return s1+s2+s3;
    }
    public static void main(String [] args){
    
        
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

    }
}
