package multiplethread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args){
        //新建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
        //创建线程池(线程池保留的最少线程数，最大的线程数，存活的时间，时间单位，等待队列)
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,50, TimeUnit.MILLISECONDS,bqueue);
        //创建7个任务
        Runnable t1 = new TestRunnableDemo();
        Runnable t2 = new TestRunnableDemo();
        Runnable t3 = new TestRunnableDemo();
        Runnable t4 = new TestRunnableDemo();
        Runnable t5 = new TestRunnableDemo();
        Runnable t6 = new TestRunnableDemo();
        Runnable t7 = new TestRunnableDemo();
        //执行任务
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);
        //关闭线程池
        pool.shutdown();
    }
}

class TestRunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
