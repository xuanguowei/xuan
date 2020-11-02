package arr;


import java.util.LinkedList;
import java.util.Stack;

/**
 * ClassName:ItemTest
 * Package:arr
 * Description:
 *
 * @Date:2020/8/11 11:17
 * @Author:xuan
 */
public class ItemTest extends Stack {
    LinkedList<Hero> heros =new LinkedList<>();

    public void push(Hero h) {
        heros.addLast(h);
    }


    public Hero pull() {
        return heros.removeLast();
    }

    @Override
    public Hero peek() {
        return heros.getLast();
    }

    public static void main(String[] args) {
        ItemTest heroS= new ItemTest();
        for(int i=0;i<5;i++)
        {
            heroS.push(new Hero("hero name "+i));
        }
        System.out.println(heroS.peek());

        for(int i=0;i<5;i++)
        {
            System.out.println("依次取出对象"+heroS.pull());
        }

    }
}