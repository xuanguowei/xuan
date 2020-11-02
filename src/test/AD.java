package test;

/**
 * ClassName:AD
 * Package:test
 * Description:
 *
 * @Date:2020/7/19 14:55
 * @Author:xuan
 */
public interface AD {

    public  void physicAttack();
    default public void revive() {
        System.out.println("本英雄复活了");
    }
}
