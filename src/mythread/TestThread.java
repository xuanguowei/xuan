package mythread;

/**
 * ClassName:TestThread
 * Package:mythread
 * Description:
 *
 * @Date:2020/8/19 17:22
 * @Author:xuan
 */
public class TestThread {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        int sheep = 1000;
        while(true){
            pool.add(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
