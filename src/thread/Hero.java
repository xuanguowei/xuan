package thread;

/**
 * ClassName:Hero
 * Package:thread
 * Description:
 *
 * @Date:2020/8/15 19:49
 * @Author:xuan
 */
public class Hero {
    public String name;
    public float hp;

    public int damage;

    public void attackHero(Hero h) {
       /* try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);

        if(h.isDead())
            System.out.println(h.name +"死了！");
    }

    public boolean isDead() {
        return 0>=hp?true:false;
    }

}
