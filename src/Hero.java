public class Hero<l> {

    private Hero() {

    }
    private static Hero hero1 ;
    public static Hero getHero1(){
        if (hero1 == null)
        {
            hero1 = new Hero();
        }
            return hero1;
    }
        private String name = "tm"; //姓名
    static int number ;
    static void st(){
        System.out.println(number);
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
        System.out.println(this.name);
    }

    protected float hp = 100; //血量

    float armor; //护甲

    int moveSpeed = 325; //移动速度

    protected String getName(){
        return name;
    }
    protected void  setName(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        Hero hero1 = new Hero();
        System.out.println(hero.equals(hero1));
        System.out.println(hero.getClass());
        System.out.println(hero.toString());
    }


}