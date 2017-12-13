package tk.chuanjing.spring.chapter02.proxy;

import org.junit.Test;

/**
 * @author ChuanJing
 * @date 2017年7月20日 下午4:51:40
 * @version 1.0
 */
public class ProxyTest {

	// 测试jdk的动态代理
	@Test
	public void text1() {
		// 1.创建目标对象
		IUserService us = new UserServiceImpl();
//		us.login("tom", "123");
		
		// 2.通过JKDProxyFactory完成代理对象创建
		JDKProxyFactory factory = new JDKProxyFactory(us);
		IUserService proxy = (IUserService) factory.createProxy();
		proxy.login("tom", "123");
	}
	
	//测试cglib动态代理
	@Test
	public void test2(){
		//创建目标对象
		IUserService us = new UserServiceImpl();
		
		//2.使用CglibProxyFactory创建代理对象
		CglibProxyFactory factory = new CglibProxyFactory(us);
		
//		UserServiceImpl proxy = (UserServiceImpl) factory.createProxy();
		IUserService proxy = (IUserService) factory.createProxy();
		
		proxy.regist();
	}
}
