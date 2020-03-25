package aaa;

/**
 * @Author gaobaishun
 * @Date 2020-03-09 20:15
 * imformation：
 */
public class B extends A{
    public void print(){
        System.out.println(a);
    }

    public B(){
        System.out.println("B-构造函数");
    }
    {
        System.out.println("B——普通代码块");
    }
    static {
        System.out.println("B-静态代码块");
    }
}
