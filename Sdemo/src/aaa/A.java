package aaa;

/**
 * @Author gaobaishun
 * @Date 2020-03-09 20:14
 * imformation：
 */
public class A {
    protected String a="a";
    public A(){
        System.out.println("A-默认构造函数");
    }
    {
        System.out.println("A——普通代码块");
    }
    static {
        System.out.println("A-静态代码块");
    }


}
