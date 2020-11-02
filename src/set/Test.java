package set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * ClassName:Test
 * Package:set
 * Description:
 *
 * @Date:2020/8/12 9:52
 * @Author:xuan
 */
public class Test {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<Integer>();

        for (int i = 0; i < 20; i++) {
            numbers.add(i);
        }

        //Set不提供get方法来获取指定位置的元素
        //numbers.get(0)


        //或者采用增强型for循环
        for (Integer i : numbers) {
            System.out.println(i);
        }

    }
}
