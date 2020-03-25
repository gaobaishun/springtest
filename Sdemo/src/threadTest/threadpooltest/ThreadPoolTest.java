package threadTest.threadpooltest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author gaobaishun
 * @Date 2020-03-09 20:01
 * imformation：
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        RejectedExecutionHandler handler=new ThreadPoolExecutor.AbortPolicy();
        MyThreadPool myThreadPool = new MyThreadPool(2, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10),handler);


        for (int i = 0; i < 100000; i++) {
            myThreadPool.execute(new Task());

            System.out.println(myThreadPool.getWorkQueueTaskNumber()+"|"+myThreadPool.getPoolSize()+"|"+myThreadPool.getActiveCount()
            +"|");


        }

        Thread.currentThread().sleep(5000L);
        System.out.println(new TaskDetail().getI()+"--------------");



    }
}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("TaskDoing");
        TaskDetail td=new TaskDetail();
        try {
            td.doTask();

            Thread.currentThread().sleep(0L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
        //System.out.println("TaskDone,i="+td.getI());
    }
}

class TaskDetail{
    private static int i=0;

    public void doTask() {
        synchronized (TaskDetail.class) {
            int a = TaskDetail.i;
            a += 1;
            TaskDetail.i = a;
        }
    }

    public int getI(){
        return TaskDetail.i;
    }
}