import java.util.concurrent.TimeUnit;

/*
  死锁是指两个或者两个以上的进程在执行过程中，
  因争夺资源而造成的一种互相等待的现象，若无外力干涉那它们都将无法推进下去。
 */
class HoldLockThread implements Runnable{
    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    private String lockA;
    private String lockB;
    @Override
    public void run() {
          synchronized (lockA)
          {
              System.out.println(Thread.currentThread().getName()+"\t 自己持有：" + lockA+"\t 尝试获得："+lockB);
              try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
              synchronized (lockB){
                  System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockB+"\t 尝试获得："+lockA);
              }
          }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
         String lockA = "lockA";
         String lockB = "lockB";
         new Thread(new HoldLockThread(lockA,lockB),"AAA").start();
         new Thread(new HoldLockThread(lockB,lockA),"BBB").start();
    }
}
