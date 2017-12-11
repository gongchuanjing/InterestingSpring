package tk.chuanjing.spring.chapter01.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author ChuanJing
 * @date 2017年7月20日 上午1:48:19
 * @version 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("第五步:beanPostProcessor的before方法");
		System.out.println("处理的bean是" + bean + " 它的名称是" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
		System.out.println("第八步:beanPostProcessor的after方法");
		
		Object proxy = bean;
		if("BeanLifeCycle".equals(beanName)) {
			// 使用动态代理可以处理bean的功能增强
			proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					if("add".equals(method.getName())) {
						
						long startTime = System.currentTimeMillis();
						Object invoke = method.invoke(bean, args);
						long endTime = System.currentTimeMillis();
						System.out.println("执行add方法耗时：" + (endTime - startTime));
						return invoke;
						
					} else {
						return method.invoke(bean, args);
					}
				}
			});
		}
		
//		return bean;
		return proxy;
	}
}
