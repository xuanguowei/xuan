package thread2;

/**
 * ClassName:PoolTest
 * Package:thread2
 * Description:
 *
 * @Date:2020/10/5 22:31
 * @Author:xuan
 */
public class PoolTest {
	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool();

		for (int i = 0; i < 500; i++) {
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println("执行任务");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//任务可能是打印一句话
					//可能是访问文件
					//可能是做排序
				}
			};

			pool.add(task);

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}