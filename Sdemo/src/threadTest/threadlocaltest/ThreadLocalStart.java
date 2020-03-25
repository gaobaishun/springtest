package threadTest.threadlocaltest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author gaobaishun
 * @Date 2020-03-13 17:35
 * imformation：
 */
public class ThreadLocalStart {
    public static void main(String[] args) {
        for (int i=0;i<1;i++){
            final int t=i;
            threadLocalTest.fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String s = new threadLocalTest2().dateFormat(t);
                    System.out.println(s);
                }
            });
        }
        threadLocalTest.fixedThreadPool.shutdown();
//        ArrayList<Integer> list=new ArrayList<>();
//        list.forEach();


//        HashMap<Integer,String> hashMap=new HashMap<>();
//        hashMap.put(1,"11");
//        System.out.println(hashMap.size());
    }
}
