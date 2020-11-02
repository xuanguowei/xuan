package mythread;

import java.util.LinkedList;

/**
 * ClassName:ThreadPool
 * Package:mythread
 * Description:
 *
 * @Date:2020/8/19 17:03
 * @Author:xuan
 */
public class ThreadPool {
    // 线程池大小
    int threadPoolSize;

    // 任务容器
    LinkedList<Runnable> tasks = new LinkedList<Runnable>();

    // 试图消费任务的线程

    public ThreadPool() {
        threadPoolSize = 5;

        // 启动10个任务消费者线程
        synchronized (tasks) {
            for (int i = 0; i < threadPoolSize; i++) {
                new TaskConsumeThread("任务消费者线程 " + i).start();
            }
        }
    }

    public void add(Runnable r) {
        synchronized (tasks) {
            tasks.add(r);
            // 唤醒等待的任务消费者线程
            tasks.notifyAll();
        }
    }

    class TaskConsumeThread extends Thread {
        public TaskConsumeThread(String name) {
            super(name);
        }

        Runnable task;

        public void run() {
            System.out.println("启动： " + this.getName());
            while (true) {
                synchronized (tasks) {
                    //System.out.println("aa");
                    while (tasks.isEmpty()) {
                        //System.out.println(tasks);
                        try {
                           // System.out.println("bb");
                            tasks.wait();
                           // System.out.println(1);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    //System.out.println("cc");
                    task = tasks.removeLast();
                    System.out.println(task);
                    // 允许添加任务的线程可以继续添加任务
                    tasks.notifyAll();

                }
                System.out.println(this.getName() + " 获取到任务，并执行");
                task.run();
            }
        }
    }

}
