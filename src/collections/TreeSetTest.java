package collections;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * ClassName:TreeSetTest
 * Package:collections
 * Description:
 *
 * @Date:2020/8/13 8:30
 * @Author:xuan
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Comparator<Integer>C=new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<=o2)
                    return 1;
                else
                    return -1;
            }

        };
        TreeSet<Integer>t=new TreeSet<Integer>(C);
        for (int i = 0; i < 10; i++) {
            t.add(i);
        }
        System.out.println(t);

    }

}