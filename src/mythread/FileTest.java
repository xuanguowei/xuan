package mythread;

import java.io.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:FileTest
 * Package:mythread
 * Description:
 *
 * @Date:2020/8/20 9:14
 * @Author:xuan
 */
public class FileTest {
    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,
            15,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>());

    public static void search(String FileFolder, String search){
        File file = new File(FileFolder);
        if (file.isDirectory()){ //是文件夹
            File[] files = file.listFiles();
            if (files != null){
                for (File f: files){ //遍历所有文件
                    if (f.isDirectory())
                        search(f.getPath(), search);  //递归调用，继续查找
                    if (f.isFile() && f.getName().endsWith(".java")){  //是java文件

                        threadPool.execute(
                                new Runnable() {    //创建一个查找文件的任务，把这个任务扔进线程池去执行
                                    @Override
                                    public void run() {
                                        try (BufferedReader br = new BufferedReader(new FileReader(f))){
                                            String line;
                                            //读取一行
                                            while ((line = br.readLine()) != null){
                                                //查找到目标字符串
                                                if (line.contains(search)){
                                                    System.out.println("查找到文件：" + f.getName() + ", 路径: " + f);
                                                    break;
                                                }
                                            }
                                        } catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        //new SearchThread(f.getName(), f, search).start();
                                    }
                                });
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        search("D:\\test-01", "return");
    }
}
