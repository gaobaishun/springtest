package threadTest.threadlocaltest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author gaobaishun
 * @Date 2020-03-13 17:33
 * imformation：测试threadlocal
 */
public class threadLocalTest {
    public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

    public static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

    public String dateFormat(int time){
        Date date=new Date(time*1000);
        String format;
        synchronized (threadLocalTest.class) {
             format= simpleDateFormat.format(date);
        }
        return format;
    }

}
