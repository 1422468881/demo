import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//集合类不安全的问题
public class ContainerNoSafeDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        //Collections.synchronizedList(new ArrayList<>());
        //new Vector<>();
        //ArrayList<>();

        for(int i= 1; i<=30;i++)
        {
            new  Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
