package thread;

import java.util.LinkedList;
import java.util.Random;

/**
 * ClassName:Test
 * Package:thread
 * Description:
 *
 * @Date:2020/8/15 22:12
 * @Author:xuan
 */
public class Test {
    public static void main(String[] args) {
        final int[] seconds = {0};

        Thread t1= new Thread(){
            public void run(){


                while(seconds[0]<5){
                    int a = 0;
                    try {
                        Thread.sleep(1000);
                        a = seconds[0];
                        System.out.println("a" + seconds[0]);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("a%d已经玩了LOL %d 秒%n", a,seconds[0]++);

                }
            }
        };
        Thread t2= new Thread(){
            public void run(){


                while(true){
                    int a = 0;
                    try {
                        Thread.sleep(1000);
                        a = seconds[0];
                        System.out.println("b" + seconds[0]);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("b %d已经玩了LOL %d 秒%n", a,seconds[0]++);

                }
            }
        };
        t2.setDaemon(true);
        t1.start();
        t2.start();

    }

}