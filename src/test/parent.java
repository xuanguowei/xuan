package test;

/**
 * ClassName:parent
 * Package:test
 * Description:
 *
 * @Date:2020/7/16 11:35
 * @Author:xuan
 */
class parent{
    private int num=10;
    parent(){
        System.out.println("parent is call");
        this.num=100;
    }
    protected int getNum() {
        return this.num;
    }
}