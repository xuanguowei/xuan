package proxy;

/**
 * ClassName:DynamicProxyDemonstration
 * Package:proxy
 * Description:
 *
 * @Date:2020/10/9 11:41
 * @Author:xuan
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理测试
 */
public class DynamicProxyDemonstration {
	public static void main(String[] args) {
		//创建要被代理的真实对象
		RealSubjectInterface realSubject=new RealSubject();

		/**
		 * InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
		 * 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用.
		 * 即：要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法
		 */
		InvocationHandler handler =new InvocationHandlerImpl(realSubject);
		//得到类加载器
		/*首先，调bai用对象的getClass()方法是获得对象当前的类类型，这部分数据存在方法法区中，
		而后在类类型dao上调用getClassLoader()方法是得到当前类型的类加载器，我们知道在Java中所有的类都是通过加载器加载到虚拟机中的，
		而且类加载器之间存在父子关系，就是子知道父，父不知道子，这样不同的子加载的类型之间是无法访问的（虽然它们都被放在方法区中），
		所以在这里通过当前类的加载器来加载资源也就是保证是和类类型同一个加载器加载的。*/
		ClassLoader loader=realSubject.getClass().getClassLoader();
		System.out.println(loader);
		//被代理类的接口,用数组存起来
		Class []interfaces=realSubject.getClass().getInterfaces();

		/**
		 * Proxy.newProxyInstance该方法用于为指定类加载器，一组接口，调用处理器生成动态代理类对象
		 */
		//loader:被代理类,interfaces:被代理类的接口,handler:处理器实现类(代理的实现)。
		/*realSubjectProxy：JDK生成的最终真正的代理类（动态代理类）的一个实现类，继承自Proxy并实现了我们定义的RealSubjectInterface 接口，
		在实现RealSubjectInterface 接口方法的内部，通过反射调用了InvocationHandlerImpl 的invoke方法。
		*/
		RealSubjectInterface realSubjectProxy = (RealSubjectInterface) Proxy.newProxyInstance(loader,interfaces,handler);

		System.out.println("动态代理对象的类型："+realSubjectProxy.getClass().getName());

		//用动态代理类对象 调用 真实对象的方法，就是调用我们定义的InvocationHandlerImpl的 invoke方法
		System.out.println(realSubjectProxy.SayHello("Jason zhang"));

		//System.out.println("/*************************************/");

		// System.out.println(realSubjectProxy.SayGoodBye());
		/*
		1.通过实现 InvocationHandler 接口创建自己的调用处理器类；
		2.通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
		3.通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
		4.通过构造函数创建动态代理类实例，构造时调用处理器对象（handler）作为参数被传入。
		*/
		/*
		1.创建被代理的类（委托类、真实类）（RealSubject）及其接口（RealSubjectInterface）
		2.创建一个实现接口InvocationHandler的类（InvocationHandlerImpl），它必须实现接口的invoke方法
		3.通过Proxy的静态方法newProxyInstance（）， 创建一个代理对象（realSubjectProxy），
		RealSubjectInterface realSubjectProxy= (RealSubjectInterface) Proxy.newProxyInstance(loader,interfaces,handler);
		4.通过代理对象（realSubjectProxy）调用 委托类对象（ realSubject）的方法
		*/


	}

}
