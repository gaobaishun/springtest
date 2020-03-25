package threadTest.threadpooltest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author gaobaishun
 * @Date 2020-03-04 21:15
 * imformation：
 */
public class ScheduleThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        //scheduledExecutorService.schedule(new Ttask(),10L, TimeUnit.SECONDS);//延迟启动
        scheduledExecutorService.scheduleAtFixedRate(new Ttask(scheduledExecutorService),2L,10L,TimeUnit.SECONDS);//周期性
    }
}
