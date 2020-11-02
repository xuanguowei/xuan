/**
 * ClassName:HeroBoy
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2020/7/16 10:34
 * @Author:xuan
 */
public class HeroBoy  {


    public static void main(String[] args) {
       Hero hero1 = Hero.getHero1();
       Hero hero2 = Hero.getHero1();
        System.out.println(hero1.hashCode());
        System.out.println(hero2.hashCode());

    }
}
