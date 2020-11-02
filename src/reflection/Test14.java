package reflection;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * ClassName:Test14
 * Package:reflection
 * Description:
 *
 * @Date:2020/9/4 18:27
 * @Author:xuan
 */
public class Test14 {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws Exception {

        //从spring.txt中获取类名称和方法名称
        File springConfigFile = new File("D:\\java\\java1.txt");
        Properties springConfig= new Properties();
        springConfig.load(new FileInputStream(springConfigFile));
        String className = (String) springConfig.get("class");
        String methodName = (String) springConfig.get("method");

        //根据类名称获取类对象
        Class clazz = Class.forName(className);
        //获取构造器
        Constructor c = clazz.getConstructor();
        //根据构造器，实例化出对象
        Object service = c.newInstance();

        // 根据方法名称，获取方法对象
        Method m = clazz.getMethod(methodName);
        //调用对象的指定方法

        m.invoke(service);

    }
}
