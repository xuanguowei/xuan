package io;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * ClassName:Test
 * Package:io
 * Description:
 *
 * @Date:2020/8/2 13:37
 * @Author:xuan
 */
public class Test {



    public static void main(String[] args) {
        String str = null;

        try {
            str.toString();
        } catch (NullPointerException e) {
            System.out.println("捕捉到运行时异常: NullPointerException ");
        }

        StringBuffer sb = new StringBuffer("1234567890");
        try {
            for (int i = 0; i < 100; i++) {
                sb.append(sb.toString());
            }
        } catch (OutOfMemoryError e) {
            System.out.println("捕捉到内存用光错误:  OutOfMemoryError");
        }


    }
}
