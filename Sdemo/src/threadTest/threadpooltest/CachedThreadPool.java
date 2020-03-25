package threadTest.threadpooltest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author gaobaishun
 * @Date 2020-03-04 20:59
 * imformation：
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //executorService.execute();
        System.out.println();
    }
}
