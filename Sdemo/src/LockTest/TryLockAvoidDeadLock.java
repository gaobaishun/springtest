package LockTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author gaobaishun
 * @Date 2020-03-25 11:18
 * imformation：
 */
public class TryLockAvoidDeadLock {
    public static void main(String[] args) {
        Lock lock1=new ReentrantLock();
        Lock lock2=new ReentrantLock();
        Runnable task1=new Task(lock1,lock2);
        Runnable task2=new Task(lock2,lock1);

        Thread t1=new Thread(task1);
        Thread t2=new Thread(task2);

        t1.start();
        t2.start();


    }

}
class Task implements Runnable{
    public Lock lock1;
    public Lock lock2;
    public  boolean pos=true;

    public Task(Lock lock1,Lock lock2){
        this.lock1=lock1;
        this.lock2=lock2;
    }
    @Override
    public void run() {
//        lock1.lock();
//        System.out.println(Thread.currentThread().getName()+"获得锁"+lock1.hashCode());
//        lock2.lock();
//        System.out.println(Thread.currentThread().getName()+"获得锁"+lock2.hashCode());
//        System.out.println("正在做些事");
//        lock2.unlock();
//        System.out.println(Thread.currentThread().getName()+"释放锁"+lock2.hashCode());
//        lock1.unlock();
//        System.out.println(Thread.currentThread().getName()+"释放锁"+lock1.hashCode());

        while(pos){
            Random random=new Random(System.currentTimeMillis());
            try {
                if(lock1.tryLock(random.nextInt(2000), TimeUnit.MILLISECONDS)){
                    try{
                        System.out.println(Thread.currentThread().getName()+"获得锁"+lock1.hashCode());

                        if (lock2.tryLock(random.nextInt(3000), TimeUnit.MILLISECONDS)){
                            System.out.println(Thread.currentThread().getName()+"获得锁"+lock2.hashCode());
                            System.out.println("正在做业务。。。。。");
                            //Thread.sleep(50L);
                            System.out.println("业务做完了");
                            pos=false;
                            lock2.unlock();

                        }else{
                            System.out.println(Thread.currentThread().getName()+"没有获得锁"+lock2.hashCode()+"继续重试");
                        }
                    }catch (Exception e){

                    }finally {
                        lock1.unlock();

                    }
                }else{
                    System.out.println(Thread.currentThread().getName()+"没有获得锁"+lock1.hashCode()+"继续重试");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}