import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("come in Callable");
        return 1024;
    }
}
//一个futureTask只计算一次，第一个线程调用完了，第二个线程只是复用不会再计算一次。要想多算要用多个futureTask
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        Thread t1 = new Thread(futureTask,"AA");
        t1.start();

        int result01 = 100;
//类似自旋锁
//        while (!futureTask.isDone()){

//        }
        int result02 = futureTask.get();//要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致堵塞，值得计算完成

        System.out.println("result:"+(result01+result02));
    }
}
