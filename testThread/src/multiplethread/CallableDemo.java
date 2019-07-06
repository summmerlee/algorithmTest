package multiplethread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            Future<String> future = executorService.submit(new TaskWithResult(i));
            list.add(future);
        }
        for(Future<String> each:list){
            try{
                while(!each.isDone());//Future返回如果没有完成，则一直循环等待，直到Future返回完成
                System.out.println(each.get());     //打印各个线程（任务）执行的结果
            }catch(InterruptedException e){
                e.printStackTrace();
            }catch(ExecutionException e){
                e.printStackTrace();
            }finally{
                //启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                executorService.shutdown();
            }

        }
    }
}

class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id){
        this.id =id;
    }
    @Override
    public String call() throws Exception {
        System.out.println("call()方法被调用了"+Thread.currentThread().getName());
        return "当前的线程是"+id+ " "+ Thread.currentThread().getName();
    }
}
