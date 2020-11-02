package proxy;

/**
 * ClassName:RealSubject
 * Package:proxy
 * Description:
 *
 * @Date:2020/10/9 11:40
 * @Author:xuan
 */
public class RealSubject implements RealSubjectInterface{
	@Override
	public String SayHello(String name) {

		return "hello, " + name;
	}

	@Override
	public String SayGoodBye() {

		return " good bye ";
	}
}
