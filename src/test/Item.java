package test;

/**
 * ClassName:Item
 * Package:test
 * Description:
 *
 * @Date:2020/7/19 17:25
 * @Author:xuan
 */

public class Item {
    public Item(){

    }
    String name;
    private int id = 1;
    int price;

    public void buy(){
        System.out.println("购买");
    }
    public void effect() {
        System.out.println(id+"物品使用后，可以有效果");
    }
    public static void battleWin(){
        System.out.println("hero battle win");
    }

}
