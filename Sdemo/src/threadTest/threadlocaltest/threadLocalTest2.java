package threadTest.threadlocaltest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author gaobaishun
 * @Date 2020-03-13 17:33
 * imformation：利用threadlocal给每个线程分配dateformat
 */
public class threadLocalTest2 {
    public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

    public static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public String dateFormat(int time){
        Date date=new Date(time*1000);
        SimpleDateFormat simpleDateFormat= ThreadSafeFormat.dateFormatThreadLocal.get();

        return simpleDateFormat.format(date);
    }

}
class ThreadSafeFormat{
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal= new ThreadLocal<SimpleDateFormat>(){
        private int i=0;
        @Override
        protected SimpleDateFormat initialValue() {
            i++;
            System.out.println("执行initialValue："+i);
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };


}
