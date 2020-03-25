package threadTest.threadpooltest;

import java.util.concurrent.*;

/**
 * @Author gaobaishun
 * @Date 2020-03-09 19:45
 * imformation：
 */
public class MyThreadPool extends ThreadPoolExecutor {
    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    public int getWorkQueueTaskNumber(){
        return getQueue().size();
    }

    @Override
    public void afterExecute(Runnable r, Throwable t) {

//        if(null==t){
//            System.out.println("没有异常");
//        }else{
//            System.out.println("exception message:"+t.getMessage());
//        }
        super.afterExecute(r, t);
         if (t != null && r instanceof Future<?>) {
            try {
              Object result = ((Future<?>) r).get();
                System.out.println("对对对");
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset
            }
          }
          if (t != null)
            System.out.println(t);
    }

}
