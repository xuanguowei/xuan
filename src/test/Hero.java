package test;

import sun.misc.PostVMInitHook;

public  class Hero {


public Hero(String name){
    this.name = name;
    System.out.println("Hero的构造方法");
}

    String name = "tm"; //姓名

    public Hero() {

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

    }



}