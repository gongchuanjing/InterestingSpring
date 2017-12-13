package tk.chuanjing.spring.chapter02.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author ChuanJing
 * @date 2017年7月20日 下午5:23:05
 * @version 1.0
 */
public class CglibProxyFactory implements MethodInterceptor {

	// 得到目标对象
	private Object target;

	// 使用构造方法传递目标对象
	public CglibProxyFactory(Object target) {
		this.target = target;
	}
	
	// 创建代理对象
	public Object createProxy() {
		// 1.创建Enhancer
		Enhancer enhancer = new Enhancer();
		
		// 2.传递目标对象的Class
		enhancer.setSuperclass(target.getClass());
		
		// 3.设置回调操作 (相当于InvocationHandler)
		enhancer.setCallback(this);
		
		Object proxy = enhancer.create();
		
		return proxy;
	}

	// 相当于InvocationHandler中的invoke
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// 功能增强操作
		System.out.println("日志操作……");
		
		Object invoke = method.invoke(target, args);// 与jdk的proxy中操作类似
//		Object invoke = methodProxy.invoke(target, args);
		return invoke;
	}
}
