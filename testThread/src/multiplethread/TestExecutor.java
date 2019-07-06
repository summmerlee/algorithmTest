package multiplethread;

import charactor.Hero;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutor {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            executorService.execute(new TestRunnable());
            System.out.println("************* a" + i + " *************");
        }
        executorService.shutdown();
    }

}

class TestRunnable implements Runnable{
    public void run(){
        System.out.print(Thread.currentThread().getName()+"线程被调用了");
    }
}
