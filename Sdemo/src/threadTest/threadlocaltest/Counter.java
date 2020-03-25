package threadTest.threadlocaltest;

/**
 * @Author gaobaishun
 * @Date 2020-03-15 01:20
 * imformation：
 */
public class Counter {
    private int count=0;
    public static int pcount=0;
    public Counter(){
        synchronized (Counter.class){
            pcount++;
        }
        System.out.println("线程："+Thread.currentThread().getName()+"初始化了Counter");
    }
    public void add(){

        count++;
    }
    public void doSomeThing(){

        System.out.println("做某些事");
    }

    public int getCount(){
        return count;
    }

}
