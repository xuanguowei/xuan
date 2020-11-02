package io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * ClassName:Str
 * Package:io
 * Description:
 *
 * @Date:2020/8/9 22:57
 * @Author:xuan
 */
public class Str {
    public static void main(String[] args) {
        write();
        read();
    }

    private static void read() {
        File f =new File("d:/test-01/test.txt");
        try (
                FileInputStream fis  = new FileInputStream(f);
                DataInputStream dis =new DataInputStream(fis);
        ){

            String str = dis.readUTF();


            System.out.println("读取到字符串:"+str);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void write() {
        File f =new File("d:/test-01/test.txt");
        try (
                FileOutputStream fos  = new FileOutputStream(f);
                DataOutputStream dos =new DataOutputStream(fos);
        ){

            dos.writeUTF("123 this is gareen");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}