package threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author gaobaishun
 * @Date 2020-03-04 19:35
 * imformation：测试线程池
 */
public class FixThreadPoolTest {
    public static void main(String[] args) {
        //固定线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 100; i++) {
            //executorService.execute(new Ttask());
        }


    }
}
class Ttask implements  Runnable{
    ScheduledExecutorService s=null;
    int times=0;
    public Ttask(ScheduledExecutorService s){
        this.s=s;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(50);
            times++;
            System.out.println(Thread.currentThread().getName()+"----"+times+"||_"+Thread.currentThread().hashCode());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
