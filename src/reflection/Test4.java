package reflection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * ClassName:Test4
 * Package:reflection
 * Description:
 *
 * @Date:2020/9/4 16:35
 * @Author:xuan
 */
public class Test4 {
    //配置文件获取对象
    public static void main(String[] args) {
        String fileName = "D:\\java\\java.txt";//文件的路径
        String fileStr = readFileContent(fileName);
        System.out.println(getHero(fileStr));

    }

    public static Hero getHero(String fileStr){
        Hero hero = null;
        try{
            Class zClass = Class.forName(fileStr);
            Constructor c = zClass.getConstructor();
            hero = (Hero) c.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return hero;
    }


    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try{
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while(null != (tempStr = reader.readLine()) ){
                sbf.append(tempStr);
            }
            reader.close();
            System.out.println(sbf);
            return sbf.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != reader){
                try{
                    reader.close();
                }catch (IOException e2){
                    e2.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

}
