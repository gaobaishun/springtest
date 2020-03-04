package threadTest;

public class EveryTaskOneThread {
    public static void main(String[] args) {
        Thread thread=new Thread(new tTask());
        thread.run();
    }

    public static class tTask implements Runnable{


        @Override
        public void run() {
            System.out.println("执行了任务");
        }

    }
}
