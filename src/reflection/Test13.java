package reflection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Test13
 * Package:reflection
 * Description:
 *
 * @Date:2020/9/4 18:06
 * @Author:xuan
 */
public class Test13 {
    public static void main(String[] args) {
        try(
                FileReader fileReader=new FileReader("D:\\Java\\java.txt");
                BufferedReader br=new BufferedReader(fileReader);
        ){
            String data;
            List<String> lists=new ArrayList<>();
            while((data = br.readLine())!=null){
                lists.add(data);
            }
            Class c=Class.forName(lists.get(0));
            Hero hero=(Hero) c.newInstance();
            Field field=c.getDeclaredField("name");
            field.setAccessible(true);
            field.set(hero,lists.get(1));

            Class c2=Class.forName(lists.get(2));
            Hero hero2=(Hero) c2.newInstance();
            Field field2= c2.getDeclaredField("name");
            field2.setAccessible(true);
            field2.set(hero2,lists.get(3));

            Method method= c.getMethod("attackHero",Hero.class);
            method.invoke(hero,hero2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}