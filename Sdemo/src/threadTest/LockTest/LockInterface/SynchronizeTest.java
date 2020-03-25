package threadTest.LockTest.LockInterface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author gaobaishun
 * @Date 2020-03-17 11:19
 * imformation：
 */
public class SynchronizeTest {

    boolean throwE=true;

    public void doSomethind(){
        synchronized (SynchronizeTest.class){
            System.out.println(Thread.currentThread().getName()+"在执行");
            //try {
                if (throwE) {
                    throwE=Boolean.FALSE;
                    //throw new Exception();
                    Ex();
                } else {
                    throwE = Boolean.TRUE;
                }
                System.out.println("要休眠了");
                //Thread.currentThread().sleep(5000);
//            }catch (Exception e){
//                System.out.println("捉到异常");
//            }
            System.out.println(Thread.currentThread().getName()+"执行完毕");
        }

    }
    public void Ex(){
        String s=null;
        s.charAt(1);
    }
    public static void main(String[] args) {
        ExecutorService service= Executors.newFixedThreadPool(5);
        SynchronizeTest synchronizeTest=new SynchronizeTest();
        for (int i = 0; i < 5; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    synchronizeTest.doSomethind();
                }
            });
        }
        test();
    }

    static  void  test(){
        test();
    }
}
