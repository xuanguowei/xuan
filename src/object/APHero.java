package object;

import test.AD;

/**
 * ClassName:APHero
 * Package:object
 * Description:
 *
 * @Date:2020/8/13 17:10
 * @Author:xuan
 */
public class APHero extends Hero{


    public APHero(String name) {
        super(name);
    }

    public APHero() {

    }


    public static void main(String[] args) {

        String str = "999.a4";
        float i = Float.parseFloat(str);
        System.out.println(i);

    }

}