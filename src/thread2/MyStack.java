package thread2;

import java.util.LinkedList;

/**
 * ClassName:MyStack
 * Package:thread2
 * Description:
 *
 * @Date:2020/8/19 16:34
 * @Author:xuan
 */
public class MyStack<T> {
    LinkedList<T> values = new LinkedList<T>();

    public synchronized void push(T t) {
        while(values.size()>=200){
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("增加重复全部唤醒");
        this.notifyAll();
        values.addLast(t);

    }

    public synchronized T pull() {
        while(values.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("删除重复全部唤醒");
        this.notifyAll();
        return values.removeLast();
    }

    public T peek() {
        return values.getLast();
    }
}

