package test;

import java.util.Date;

/**
 * ClassName:ADHero
 * Package:test
 * Description:
 *
 * @Date:2020/7/19 14:57
 * @Author:xuan
 */
public class ADHero  extends Hero {


    public ADHero(String name) {
        super(name);
    }

    public ADHero() {
        super();
    }


    public static void main(String[] args) {

        String str = "999.a4";
        float i = Float.parseFloat(str);
        System.out.println(i);

    }

}
