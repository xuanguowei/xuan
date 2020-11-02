package mythread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName:Test2
 * Package:mythread
 * Description:
 *
 * @Date:2020/8/21 8:42
 * @Author:xuan
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicI =new AtomicInteger();
        int a = 10;
        a = atomicI.incrementAndGet();
        atomicI.incrementAndGet();
        System.out.println(atomicI.intValue());
        System.out.println(a);


    }

}