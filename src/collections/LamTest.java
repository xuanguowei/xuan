package collections;

import java.util.*;

/**
 * ClassName:LamTest
 * Package:collections
 * Description:
 *
 * @Date:2020/8/13 8:47
 * @Author:xuan
 */
public class LamTest {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }

        System.out.println("初始化集合后的数据 (最后一个数据重复)：");
        System.out.println(heros);

        //传统方式
        Collections.sort(heros,new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return (int) (o2.hp-o1.hp);
            }
        });

        Hero hero = heros.get(2);
        System.out.println("通过传统方式找出来的hp第三高的英雄名称是:" + hero.name);

        //聚合方式
        String name =heros
                .stream()
                .sorted((h1,h2)->h1.hp>h2.hp?-1:1)
                .skip(2)
                .map(h->h.getName())
                .findFirst()
                .get();

        System.out.println("通过聚合操作找出来的hp第三高的英雄名称是:" + name);

    }
}
