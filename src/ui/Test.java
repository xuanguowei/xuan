package ui;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassName:Test
 * Package:ui
 * Description:
 *
 * @Date:2020/8/31 9:38
 * @Author:xuan
 */
public class Test {
    public static void main(String[] args) {
        int x=400,y=400;
        // 主窗体
        JFrame f = new JFrame("LoL");

        Thread t = new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {
                        FileOutputStream out = new FileOutputStream("D:/java.txt");
                        String xx = f.getX() + "";
                        String yy = f.getY() + "";
                        out.write(new String(xx + "&&" + yy).getBytes());

                        Thread.sleep(100);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };


        t.start();


        try {
            FileInputStream in = new FileInputStream("D:/java.txt");

            //读进来
            byte[] b = new byte[512];
            in.read(b);
            //System.out.println(b);

            //转化
            String split = new String(b);
            //System.out.println(split);
            //分隔符
            String[] str = split.split("&&");
            //去除多余空格
            str[1] = str[1].trim();
            System.out.println(str[0]);
            System.out.println(str[1]);

            x = Integer.parseInt(str[0]);
            y = Integer.parseInt(str[1]);


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        // 主窗体设置大小
        f.setSize(400, 300);

        // 主窗体设置位置
        f.setLocation(x,y);

        // 主窗体中的组件设置为绝对定位
        f.setLayout(null);

        // 按钮组件
        JButton b = new JButton("一键秒对方基地挂");

        // 同时设置组件的大小和位置
        b.setBounds(50, 50, 280, 30);

        // 把按钮加入到主窗体中
        f.add(b);

        // 关闭窗体的时候，退出程序
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 让窗体变得可见
        f.setVisible(true);

    }
}