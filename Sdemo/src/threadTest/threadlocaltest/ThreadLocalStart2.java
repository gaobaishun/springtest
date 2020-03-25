package threadTest.threadlocaltest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author gaobaishun
 * @Date 2020-03-15 01:20
 * imformation：
 */
public class ThreadLocalStart2 {

    public static ThreadLocal<Counter> threadLocal=new ThreadLocal<Counter>(){

        @Override
        protected Counter initialValue() {
            System.out.println("执行初始化initialValue");
            return new Counter();
        }
    };

    public static ThreadLocal<Counter> threadlocal2=new ThreadLocal<>();
    public static List<Integer> list=new  ArrayList<>();
    public static ExecutorService executorService=Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        ThreadLocalStart2 threadLocalStart2 = new ThreadLocalStart2();
        //测试初始化了几次，共创建了多少个对象
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
//                    Counter counter=threadLocal.get();
//
//                    int i1 = counter.hashCode();
//                    //System.out.println(i1+"{}");
//                    if(!list.contains(i1)){
//                        System.out.println(i1+"-hashCode");
//                        list.add(i1);
//                    }
//                    counter.doSomeThing();
                    threadLocalStart2.preService();
                }
            });
        }
        try {
            Thread.currentThread().sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("共创建了-"+list.size()+"-个对象,初始化执行了-"+Counter.pcount);
        System.out.println(list.toString());

        //new ThreadLocalStart2().test();
    }

    public void test(){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            adds(list);
        }

        System.out.println(list.size());
    }
    private void adds(List list){
        Counter counter=new Counter();
        Integer io=null;
        if(!list.contains(io)){
            list.add(io);
        }
    }

    public void preService(){
        Counter counter=new Counter();
        threadLocal.set(counter);
        System.out.println(Thread.currentThread().getName()+"在执行preservice"+"counter目前为："+counter.getCount());
        service1();

    }

    public void service1(){
        System.out.println();
        Counter counter=threadLocal.get();
        counter.add();
        System.out.println(Thread.currentThread().getName()+"在执行service1"+"counter目前为："+counter.getCount());
        service2();
    }

    public void service2(){
        System.out.println();
        Counter counter=threadLocal.get();
        counter.add();
        System.out.println(Thread.currentThread().getName()+"在执行service2"+"counter目前为："+counter.getCount());
    }
}

