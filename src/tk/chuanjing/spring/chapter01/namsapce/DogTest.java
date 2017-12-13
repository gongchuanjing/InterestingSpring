package tk.chuanjing.spring.chapter01.namsapce;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ChuanJing
 * @date 2017年7月20日 上午4:02:33
 * @version 1.0
 */
public class DogTest {

	@Test
	public void test1() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Dog dog1=(Dog) context.getBean("Dog");
		System.out.println(dog1);
	}
	
	@Test
	public void test2() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Dog dog2=(Dog) context.getBean("Dog2");
		System.out.println(dog2);
	}
	
	@Test
	public void test3() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person=(Person) context.getBean("PersonSpace");
		System.out.println(person);
	}
	
	//测试spel表达式
	@Test
	public void test4(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person=(Person) context.getBean("PersonSpace2");
		System.out.println(person);
	}
}
