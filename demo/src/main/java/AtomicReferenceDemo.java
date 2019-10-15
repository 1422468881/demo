
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;


@Getter
@ToString
@AllArgsConstructor
class User
{
    String userName;
    int age;
}
//原子引用
//用原子类包装可以参考这个方法
public class AtomicReferenceDemo {
    public  static void main(String[] args){
        User z3 =new User("z3",22);
        User li4=new User("li4",25);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3,li4)+"\t"+atomicReference.get().toString());
    }
}
