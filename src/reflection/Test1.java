package reflection;

/**
 * ClassName:Test1
 * Package:reflection
 * Description:
 *
 * @Date:2020/9/4 10:25
 * @Author:xuan
 */
public class Test1 {
    public static void main(String[] args) {
        String className = "reflection.Hero";
        try {
            Class pClass1=Class.forName(className);
            Class pClass2=Hero2.class;
            System.out.println(pClass2);
            Class pClass3=new Hero().getClass();
            //System.out.println(pClass1==pClass2);
            //System.out.println(pClass1==pClass3);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}