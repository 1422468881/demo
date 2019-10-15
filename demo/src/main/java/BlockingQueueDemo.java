import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
       //增加元素，当满的时候会报异常
       // System.out.println(blockingQueue.add("a"));
        //检查队列空不空，队首元素是什么
        //System.out.println(blockingQueue.element());
        //从队首开始移除，先进先出。一个remove方法移除一个元素
        //System.out.println(blockingQueue.remove());
        //插入元素成功返回true，失败返回false
        //System.out.println(blockingQueue.offer("a"));
        //取元素，当无元素是为null
       // System.out.println(blockingQueue.poll());
        //如果队列已满则等候两秒插入，如果两秒后仍然满则返回false
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
    }
}
