package threadTest;

import java.util.concurrent.Executors;

public class EveryTaskOneThreadFor {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(new tTask());
            thread.run();
        }
        Executors.defaultThreadFactory();
    }

    public static class tTask implements Runnable{


        @Override
        public void run() {
            System.out.println("执行了任务");
            System.out.println(this.hashCode());
        }

    }
}
