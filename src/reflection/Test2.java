package reflection;

/**
 * ClassName:Test2
 * Package:reflection
 * Description:
 *
 * @Date:2020/9/4 12:33
 * @Author:xuan
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Test2 test2 = new Test2();
        Thread t1= new Thread(){
            public void run(){
                //调用method1
                test2.method1();
            }
        };
        t1.setName("第一个线程");
        t1.start();

        //保证第一个线程先调用method1
        Thread.sleep(1000);

        Thread t2= new Thread(){
            public void run(){
                //调用method2
                test2.method2();
            }
        };
        t2.setName("第二个线程");
        t2.start();
    }

    public  synchronized void method1() {

        //synchronized (Test2.class) {
            // 对于method1而言，同步对象是TestReflection.class，只有占用TestReflection.class才可以执行到这里
            System.out.println( " 进入了method1方法");
            try {
                System.out.println("运行5秒");
                Thread.sleep(5000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

    }

    public  synchronized void method2() {
        // 对于mehotd2而言，必然有个同步对象，通过观察发现，当某个线程在method1中，占用了TestReflection.class之后
        // 就无法进入method2，推断出，method2的同步对象，就是TestReflection.class
        System.out.println(" 进入了method2方法");
        try {
            System.out.println("运行5秒");
            Thread.sleep(5000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }
}