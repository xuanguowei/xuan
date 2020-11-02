package test;

/**
 * ClassName:LifePotion
 * Package:test
 * Description:
 *
 * @Date:2020/7/19 17:26
 * @Author:xuan
 */

public class LifePotion extends Item{

    public void effect(){
        System.out.println("血瓶使用后，可以回血");
        super.effect();
    }
    public static void battleWin(){
        System.out.println("ad hero battle win");
    }

    public static void main(String[] args) {
        LifePotion lifePotion = new LifePotion();
        LifePotion.battleWin();
        Item.battleWin();
        Item h = new LifePotion();
        h.battleWin();
        lifePotion.battleWin();

    }

}
