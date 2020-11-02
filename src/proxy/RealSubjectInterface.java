package proxy;

/**
 * ClassName:RealSubjectInterface
 * Package:proxy
 * Description:
 *
 * @Date:2020/10/9 11:40
 * @Author:xuan
 */
/**
 * 真实对象的实现接口:需要动态代理的接口
 */
public interface RealSubjectInterface {
	/**
	 *定义方法
	 */
	public String SayHello(String name);

	public String SayGoodBye();

}