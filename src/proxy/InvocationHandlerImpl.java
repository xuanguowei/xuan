package proxy;

/**
 * ClassName:InvocationHandlerImpl
 * Package:proxy
 * Description:
 *
 * @Date:2020/10/9 11:41
 * @Author:xuan
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *调用处理器实现类（有木有感觉这里就是传说中的AOP啊）
 * 每次生成动态代理类对象的时候都需要指定一个实现了该接口的调用处理器类
 *  */

public class InvocationHandlerImpl implements InvocationHandler {
	/**
	 * 我们要代理的真实对象
	 */
	private Object realSubject;//为了new InvocationHandlerImpl(realSubject);传参名一致

	/**
	 * 构造函数，为真实对象赋初值
	 */
	public InvocationHandlerImpl(Object realSubject){
		this.realSubject =realSubject;
	}
	/**
	 * invoke方法负责处理动态代理类中所有方法调用
	 * 调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//在代理真实对象前可以添加额外操作
		System.out.println("在用代理对象调用真实对象的方法之前，类似AOP的Before()，自己的操作：");
		System.out.println("其调用的方法Method:"+method);

		//当代理对象调用真实对象的方法时，其会自动跳转到代理对象关联的handler对象的invoke方法来进行调用
		Object returnValue=method.invoke(realSubject,args);

		//在代理真实对象之后可以添加额外操作
		System.out.println("在用代理对象调用真实对象的方法之后，但是返回值returnValue之前，自己的操作?");

		return returnValue;
	}
}