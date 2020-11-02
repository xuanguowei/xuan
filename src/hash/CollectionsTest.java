package hash;

import java.util.*;

/**
 * ClassName:CollectionsTest
 * Package:hash
 * Description:
 *
 * @Date:2020/8/12 10:53
 * @Author:xuan
 */
public class CollectionsTest {
    public static void main(String[] args) {

        HashMap<String,Hero> heroMap = new HashMap<String,Hero>();
        heroMap.hashCode();
        for (int j = 0; j < 2000000; j++) {
            Hero h = new Hero("Hero " + j);
            heroMap.put(h.name, h);
        }
        System.out.println("数据准备完成");

        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();

            //查找名字是Hero 1000000的对象
            Hero target = heroMap.get("Hero 1000000");
            System.out.println("找到了 hero!" + target.name);

            long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("一共花了：" + elapsed + " 毫秒");

        }

    }
}