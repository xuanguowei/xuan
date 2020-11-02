/**
 * ClassName:Test2
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2020/9/6 14:50
 * @Author:xuan
 */
public class Test2 {
    static {
        System.out.println("SuperClass init!");
    }
    public static int value = 1127;


    public static void main(String[] args) {
        Hero2 hero = new Hero3();
        hero.say();
    }
}

