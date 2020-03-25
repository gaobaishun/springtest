package LockTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author gaobaishun
 * @Date 2020-03-23 14:26
 * imformation：
 */
public class SynchronizeTest {
    public static void main(String[] args) {
        ExecutorService e= Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            e.execute(new Runnable() {
                @Override
                public void run() {
                    new TestFunction().stest4();
                }
            });
        }
        try {
            Thread.currentThread().sleep(15000L);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        e.shutdown();
        System.out.println(TestFunction.i);
    }
}
class TestFunction{
    public static int i=0;
    public synchronized void stest(){
        System.out.println(Thread.currentThread().getName()+"进入此方法");

        int p=i+1;
        try {
            Thread.currentThread().sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i=p;
    }
    public synchronized static void stest2(){
        System.out.println(Thread.currentThread().getName()+"进入此方法");

        int p=i+1;
        try {
            Thread.currentThread().sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i=p;
    }
    public  void stest3(){
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "进入此方法");

            int p = i + 1;
            try {
                Thread.currentThread().sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = p;
        }
    }

    public  void stest4(){
        synchronized (TestFunction.class) {
            System.out.println(Thread.currentThread().getName() + "进入此方法");

            int p = i + 1;
            try {
                Thread.currentThread().sleep(10L);
                Object o=null;
                o.hashCode();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e){
                System.out.println("出现异常");
            }

            System.out.println("出现异常后继续执行");
            i = p;
        }
    }

}