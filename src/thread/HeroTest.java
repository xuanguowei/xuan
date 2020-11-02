package thread;

/**
 * ClassName:HeroTest
 * Package:thread
 * Description:
 *
 * @Date:2020/8/16 10:58
 * @Author:xuan
 */
public class HeroTest {
    public String name;
    public float hp;

    public int damage;

    //回血
    public synchronized void recover(){
            hp=hp+1;

    }

    //掉血
    public synchronized void hurt(){
            hp=hp-1;

    }

    public void attackHero(Hero h) {
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }

    public boolean isDead() {
        return 0>=hp?true:false;
    }

}
