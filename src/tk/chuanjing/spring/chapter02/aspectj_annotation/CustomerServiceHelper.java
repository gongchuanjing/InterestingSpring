package tk.chuanjing.spring.chapter02.aspectj_annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ChuanJing
 * @date 2017年7月21日 下午5:25:01
 * @version 1.0
 */

//通知
@Component
@Aspect		// 声明当前的bean就是一个切面
public class CustomerServiceHelper {
	
	@Pointcut("execution(* *.s*(..))")
	private void mypointcut(){}
	
	@Pointcut("execution(* *.update(..))")
	private void mypointcut2(){}

	// 前置通知
	@Before("mypointcut()||mypointcut2()")
	public void before() {
		System.out.println("前置通知...");
	}
	
	// 后置通知
	@AfterReturning(value="mypointcut()",returning="value")
	public void afterReturning(JoinPoint jp, Object value) {
		System.out.println("后置通知,目标方法的返回是" + value);
	}
	
	// 环绕通知
	@Around("mypointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕前...");
		Object value = pjp.proceed();
		System.out.println("环绕后");
		return value;
	}
	
	// 异常抛出通知
	@AfterThrowing(value="mypointcut()", throwing = "t")
	public void afterThrowing(JoinPoint jp, Throwable t) {
		System.out.println("异常抛出通知:" + t);
	}
	
	// 最终通知
	@After("mypointcut()")
	public void after() {
		System.out.println("最终通知");
	}
}
