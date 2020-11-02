package thread2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName:Hero
 * Package:thread2
 * Description:
 *
 * @Date:2020/8/19 10:48
 * @Author:xuan
 */
public class Hero {
    public String name;
    int a;
    public int damage;
    public static AtomicInteger hp = new AtomicInteger();
    //public float hp = atomicInteger.incrementAndGet();
    public synchronized void a(int a)
    {
        for (int i = 1000; i>0; i--)
            System.out.println("a"+hp);
    }
    public void b(int a)
    {
        for (int i = 1000; i>0; i--)
            System.out.println("b"+hp);
    }public synchronized void recover(){
        //hp = hp +1;
        System.out.println(hp);
        hp .incrementAndGet();
        System.out.println(hp);
        System.out.printf("%s 回血1点,增加血后，%s的血量是%d%n", name, name, hp.intValue());
        // 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
        this.notify();
        System.out.println("增加");
    }

    public synchronized void hurt(){
        System.out.println("减少");
        System.out.println(hp);
        if (hp .intValue()== 1) {

            try {
                // 让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
                System.out.println("1减少");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //hp = hp - 1;
        hp.decrementAndGet();
        System.out.println(hp);
        if (hp .intValue()== 0) {

            try {
                // 让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
                System.out.println("2减少");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.printf("%s 减血1点,减少血后，%s的血量是%d%n", name, name, hp.intValue());
    }

    public void attackHero(Hero h) {
        h.hp.addAndGet(0-damage);
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp.intValue());
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }
    public boolean isDead() {
        return 0>=hp.intValue()?true:false;
    }



}
