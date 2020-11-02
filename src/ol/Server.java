package ol;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ClassName:Server
 * Package:ol
 * Description:
 *
 * @Date:2020/9/1 9:48
 * @Author:xuan
 */
public class Server extends Thread {
    public static void main(String[] args) {
        try {

            ServerSocket ss = new ServerSocket(8888,2,null);

            System.out.println("监听在端口号:8888");
            Socket s = ss.accept();
            System.out.println(1);
            //启动发送消息线程
            new SendThread(s).start();
            //启动接受消息线程
            new RecieveThread(s).start();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
