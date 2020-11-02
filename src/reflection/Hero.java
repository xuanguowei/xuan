package reflection;

public  class Hero {
    public String name;
    public float hp;
    public int damage;
    public int id;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Hero(){

    }
    public Hero(String string) {
        name =string;
    }

    @Override
    public String toString() {
        return "Hero [name=" + name + "]";
    }
    public boolean isDead() {
        // TODO Auto-generated method stub
        return false;
    }
    public void mothod(){
        System.out.println("Hero1");
    }
    public void attackHero(Hero h2) {
        System.out.println(this.name+ " 正在攻击 " + h2.getName());
    }

    public static void main(String[] args) {
    /*    String s1 = new String("he");
       *//* String s2 = new String("he") + new String("llo");
        s2.intern();
            String s3 = "hello";*//*
        String s5="he";
           // System.out.println(s2 == s3);  //true
        System.out.println("he" == s5);
        System.out.println("he" == s1);

        System.out.println("he".hashCode());
        System.out.println(s5.hashCode());
        System.out.println(s1.hashCode());
        *//*System.out.println(s1.hashCode());
        System.out.println(s5.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s2.hashCode());*/

        String s3 = new String("1") + new String("1");//11在堆中,不在常量池中
       // String S6 = s3.intern();//把11对象的引用放到常量池中
        String s4 = "11";//在常量池找到11对象的引用,并返回给s4
        //s3和s4都指向堆中的11,常量池里只有11的引用,而没有11这个对象
        String s5 = new String("11");
       // System.out.println(s3 == S6);
        System.out.println(s3 == s4);
        System.out.println(s3 == s5.valueOf("11"));//true
        System.out.println(s4 == s5.valueOf("11"));



    }

}