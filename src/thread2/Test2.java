package thread2;

/**
 * ClassName:Test2
 * Package:thread2
 * Description:
 *
 * @Date:2020/10/4 20:08
 * @Author:xuan
 */
public class Test2 {
	public static void main(String[] args) {


	Hero gareen = new Hero();
	Thread t1 = new Thread() {
		public void run() {

				gareen.a(gareen.a);
				//System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


		}
	};
        t1.start();

		Thread t2 = new Thread() {
			public void run() {


					gareen.b(gareen.a);
					//System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}


		};
		t2.start();
}
}
