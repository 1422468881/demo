import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//可重入锁案例
class Phone implements Runnable{
    public synchronized void sendSMS()throws Exception
    {
        System.out.println(Thread.currentThread().getId()+"\t invoked sendSMS()");
        sendEmail();
    }
    public synchronized void sendEmail()throws Exception
    {
        System.out.println(Thread.currentThread().getId()+"\t invoked sendEmail()");

    }
Lock lock = new ReentrantLock();
    @Override
    public void run() {
     get();
    }

    private void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+"\t invoked get()");
            set();
        }finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+"\t invoked set()");

        }finally {
            lock.unlock();
        }
    }
}

public class ReenterLockDemo {
    public static void main(String[] args) throws Exception{
        Phone phone =new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();
        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);

        t3.start();
        t4.start();
    }
}
