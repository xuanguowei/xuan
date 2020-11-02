package exception;

/**
 * ClassName:Hero
 * Package:exception
 * Description:
 *
 * @Date:2020/8/4 20:48
 * @Author:xuan
 */
public class Hero {
    public String name;
    protected float hp;

    public void attackHero(Hero h) throws EnemyHeroIsDeadException{
        if(h.hp == 0){
            throw new EnemyHeroIsDeadException(h.name + " 已经挂了,不需要施放技能" );
        }
    }

    public String toString(){
        return name;
    }


    public static void main(String[] args) {

        Hero garen =  new Hero();
        garen.name = "盖伦";
        garen.hp = 616;

        Hero teemo =  new Hero();
        teemo.name = "提莫";
        teemo.hp = 0;

        try {
            garen.attackHero(teemo);

        } catch (EnemyHeroIsDeadException e) {
            // TODO Auto-generated catch block
            System.out.println("异常的具体原因:"+e.getMessage());
            e.printStackTrace();

        }

    }
}
