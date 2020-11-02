package ol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * ClassName:Client
 * Package:ol
 * Description:
 *
 * @Date:2020/9/1 9:49
 * @Author:xuan
 */
public class Client {
    public static void main(String[] args) {

        try {
            Socket s = new Socket("127.0.0.1", 8888);

            // 启动发送消息线程
            new SendThread(s).start();
            // 启动接受消息线程
            new RecieveThread(s).start();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}