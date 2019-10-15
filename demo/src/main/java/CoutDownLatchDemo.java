import java.util.concurrent.CountDownLatch;
//闭锁
public class CoutDownLatchDemo
{
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 国，被灭");
                countDownLatch.countDown();
            },CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 秦国，统一华夏");

    }
//    public static void closerDoor()throws Exception{
//        CountDownLatch countDownLatch = new CountDownLatch(6);
//        for (int i = 0; i <6 ; i++) {
//            new Thread(()->{
//                System.out.println(Thread.currentThread().getName()+"\t 上完自习，离开教室");
//                countDownLatch.countDown();
//            },CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
//        }
//        countDownLatch.await();
//        System.out.println(Thread.currentThread().getName()+"\t 班长锁门离开");
//    }
}
