package thread2;

/**
 * ClassName:Test
 * Package:thread2
 * Description:
 *
 * @Date:2020/8/19 16:25
 * @Author:xuan
 */
public class Test {
    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();
        new ProducerThread(stack, "Producer1").start();
        new ProducerThread(stack, "Producer2").start();
        new ConsumerThread(stack, "Consumer1").start();
        new ConsumerThread(stack, "Consumer2").start();
        new ConsumerThread(stack, "Consumer3").start();

    }
}
