package tk.chuanjing.spring.chapter02.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ChuanJing
 * @date 2017年7月20日 下午4:45:41
 * @version 1.0
 */

//创始一个使用jdk的proxy完成动态代理工具
public class JDKProxyFactory implements InvocationHandler{
	
	private Object target;

	public JDKProxyFactory(Object target) {
		this.target = target;
	}

	// 创建代理对象
	public Object createProxy() {
		
		// 使用Proxy完成代理对象创建
		// 1.得到目标对象的ClassLoader
		ClassLoader classLoader = target.getClass().getClassLoader();
		
		// 2.得到目标对象的实现接口的Class[]
		Class<?>[] interfaces = target.getClass().getInterfaces();
		
		// 3.第三个参数需要一个实现了InvocationHandler接口的对象
		Object proxyInstance = Proxy.newProxyInstance(classLoader, interfaces, this);
		
		return proxyInstance;
	}

	// 在代理实例上处理方法调用并返回结果。
	// 参数1 就是代理对象，一般不使用
	// 参数2它调用的方法的Method对象
	// 参数3调用的方法的参数
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		// 功能增强操作
		System.out.println("日志操作……");
		
		Object invoke = method.invoke(target, args);
		return invoke;
	}
}
