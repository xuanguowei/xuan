package arr;


import java.util.ArrayList;

/**
 * ClassName:Test
 * Package:arr
 * Description:
 *
 * @Date:2020/8/11 9:51
 * @Author:xuan
 */
public class Test {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        ArrayList heros = new ArrayList();

        // 初始化5个对象
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i));
        }
        Hero specialHero = new Hero("special hero");
        heros.add(specialHero);

        System.out.println(heros);
        System.out.println("specialHero所处的位置:"+heros.indexOf(specialHero));
        System.out.println("新的英雄，但是名字是\"hero 1\"所处的位置:"+heros.indexOf(new Hero("hero 1")));

    }
}