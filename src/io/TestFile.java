package io;

import java.io.*;
import java.util.Date;

/**
 * ClassName:TestFile
 * Package:io
 * Description:
 *
 * @Date:2020/8/4 22:02
 * @Author:xuan
 */
public class TestFile {
    public static void main(String[] args){
        String path = "d:/test-01/test.txt";
        File file1 = new File(path);
        FileReader fs = null;
        FileWriter fis = null;
        try {
            String data = "adbd";
            fs = new FileReader(file1);
            fis = new FileWriter(file1);
            char[] all = new char[2];
            char[] cs = data.toCharArray();
            fis.write(cs);



        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
