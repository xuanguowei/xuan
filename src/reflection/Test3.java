package reflection;

import java.lang.reflect.Constructor;

/**
 * ClassName:Test3
 * Package:reflection
 * Description:
 *
 * @Date:2020/9/4 16:26
 * @Author:xuan
 */
public class Test3 {
    public static void main(String[] args) {
        //传统的使用new的方式创建对象
        Hero h1 =new Hero();
       // h1.name = "teemo";
        System.out.println(h1);

        try {
            //使用反射的方式创建对象
            String className = "reflection.Hero";
            //类对象
            Class pClass=Class.forName(className);
            System.out.println(pClass);
            //构造器
            Constructor c= pClass.getConstructor();
            System.out.println(c);
            //通过构造器实例化
            Hero h2= (Hero) c.newInstance();
           // h2.name="gareen";
            System.out.println(h2);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
