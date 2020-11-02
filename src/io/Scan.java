package io;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * ClassName:Scan
 * Package:io
 * Description:
 *
 * @Date:2020/8/10 21:17
 * @Author:xuan
 */
public class Scan {
    public static void main(String[] args) {
        String className;
        String propertyName;
        String propertyType;
        Scanner s = new Scanner(System.in);
        System.out.println("请输入类的名称：");
        className = s.nextLine();
        System.out.println("请输入属性名称：");
        propertyName = s.nextLine();
        System.out.println("请输入属性类型：");
        propertyType = s.nextLine();
        s.close();
        // 准备写入内容到字符串数组中
        String[] code = new String[9];
        code[0] = "public class " + className + " {";
        code[1] = "    " + propertyType + " String " + propertyName + ";";
        code[2] = "    public String get" + propertyName + "() {";
        code[3] = "        return this." + propertyName + ";";
        code[4] = "    }";
        code[5] = "    public void set" + propertyName + "(String " + propertyName + ") {";
        code[6] = "        this." + propertyName + " = " + propertyName + ";";
        code[7] = "    }";
        code[8] = "}";
        System.out.println("替换后的内容：");
        for (String str : code) {
            System.out.println(str);
        }
        // 将字符串数组写入文件中
        File file = new File("d:/test-01/test.java");
        try (FileWriter fw = new FileWriter(file); PrintWriter pw = new PrintWriter(fw);) {
            for (String each : code) {
                pw.println(each);// 将每行写入java文件中
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}