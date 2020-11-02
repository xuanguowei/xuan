package arr;

/**
 * ClassName:Hero
 * Package:arr
 * Description:
 *
 * @Date:2020/8/11 9:53
 * @Author:xuan
 */
public class Hero {
    public String name;
    public int Hp = 100;
    public Hero(){}
    public Hero(String name)
    {
        this.name = name;
    }
    public String toString(){
        return name +" "+ Hp;
    }
}
