package mythread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:Test
 * Package:mythread
 * Description:
 *
 * @Date:2020/8/20 8:51
 * @Author:xuan
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        while (true) {
            threadPool.execute(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    System.out.println(this.toString()+"执行任务1");
                }

            });

        }
    }

}
