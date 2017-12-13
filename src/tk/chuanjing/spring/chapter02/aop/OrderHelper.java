package tk.chuanjing.spring.chapter02.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @author ChuanJing
 * @date 2017年7月21日 上午3:49:11
 * @version 1.0
 */

// 通知(advice)
public class OrderHelper implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("前置通知...");
	}

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("后置通知...");
	}

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {

		System.out.println("环绕前....");
		Object value = mi.proceed();
		System.out.println("环绕后....");
		
		return value;
	}

}
