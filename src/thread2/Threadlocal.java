package thread2;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * ClassName:Threadlocal
 * Package:thread2
 * Description:
 *
 * @Date:2020/10/20 21:28
 * @Author:xuan
 */
public class Threadlocal {
	public static void main(String[] args) {
		ThreadLocal<String> local = new ThreadLocal<>();
		Random random = new Random();
		IntStream.range(0,5).forEach(a-> new Thread(()->{
			local.set(a+ " "+random.nextInt(10));
			local.set("b"+ " "+random.nextInt(10));
			System.out.println("值为"+local.get());
			try {
				TimeUnit.SECONDS.sleep(1);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}).start());

		System.out.println(local.get());

	}
}
