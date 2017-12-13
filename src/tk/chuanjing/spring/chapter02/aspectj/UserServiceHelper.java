package tk.chuanjing.spring.chapter02.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author ChuanJing
 * @date 2017年7月21日 下午3:31:27
 * @version 1.0
 */

//advice 通知
public class UserServiceHelper {

	// 前置通知
	public void before(JoinPoint jp) {
		System.out.println("前置通知,拦截的目标类:"+jp.getSignature().getDeclaringTypeName()+",拦截的方法名称:"+jp.getSignature().getName());
	}
	
	// 前置通知
	public void before1() {
		System.out.println("前置通知1111");
	}
	
	// 后置通知
	public void afterReturning(JoinPoint jp, Object val) {
		System.out.println("后置通知,拦截的目标方法返回值"+val);
	}
	
	// 环绕通知
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕前....");
		
		Object value = pjp.proceed(); // 执行目标行为

		System.out.println("环绕后....");

		return value;
	}
	
	// 异常抛出通知
	public void afterThrowing(JoinPoint jp, Throwable t) {
		System.out.println("发现了异常。。。。" + t);
	}
	
	// 最终通知
	public void after(JoinPoint jp) {
		System.out.println("最终通知:"+jp.getSignature().getName());
	}
}
