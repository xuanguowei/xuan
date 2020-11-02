package hash;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Test1
 * Package:hash
 * Description:
 *
 * @Date:2020/8/12 21:35
 * @Author:xuan
 */
public class Test1 {
    public static void main(String[] args) {
        int a1=0;
        int a2=0;
        ArrayList<Hero> ar=new ArrayList<>();
        for(int i=0;i<100000;i++) {
            int random=(int)(Math.random()*9000+1000);
            Hero h=new Hero("hero-"+random);
            ar.add(h);
        }
        long start=System.currentTimeMillis();
        for(Hero h:ar) {
            if(h.name.equals("hero-5555"))
                a1++;
        }
        long end=System.currentTimeMillis();
        System.out.println("遍历完毕，总共有"+a1+"个名称是hero-5555的英雄对象，用时"+(end-start)+"毫秒");
        System.out.println("接下来借助MyHashMap，找出结果，并统计花费的时间");
        MyHashMap mh=new  MyHashMap();
        long start1=System.currentTimeMillis();
        for(Hero h:ar) {
            //h=ar.next();
            List<Hero> list= (List<Hero>) mh.get(h.name);
            if(list==null)
            {
                list=new ArrayList<>();
                mh.put(h.name, list);
            }
            list.add(h);//里面是链表,一个挂一个
        }

        List<Hero>l=(List<Hero>)mh.get("hero-5555");
        a2=l.size();
        long end1=System.currentTimeMillis();
        System.out.println("遍历完毕，总共有"+a2+"个名称是hero-5555的英雄对象，用时"+(end1-start1)+"毫秒");
    }
}
