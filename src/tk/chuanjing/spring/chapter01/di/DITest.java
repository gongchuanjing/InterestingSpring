package tk.chuanjing.spring.chapter01.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ChuanJing
 * @date 2017年7月20日 上午2:58:14
 * @version 1.0
 */
public class DITest {

	// 测试构造方法注入
	@Test
	public void test1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = (Car) applicationContext.getBean("Car");
		System.out.println(car.toString());
	}
	
	// 测试setter方法注入
	@Test
	public void test2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car car = (Car) applicationContext.getBean("Car1");
		System.out.println(car.toString());
	}
	
	@Test
	public void test3() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) applicationContext.getBean("Person");
		System.out.println(person.toString());
	}
	
	// 测试集合属性注入---List
	@Test
	public void test4() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionDemo cd = (CollectionDemo) applicationContext.getBean("CollectionDemo");
		System.out.println(cd.getList());
	}
	
	// 测试集合属性注入---Set
	@Test
	public void test5() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionDemo cd = (CollectionDemo) applicationContext.getBean("CollectionDemo");

		System.out.println(cd.getSet());
	}

	// 测试集合属性注入---Map
	@Test
	public void test6() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionDemo cd = (CollectionDemo) applicationContext.getBean("CollectionDemo");

		System.out.println(cd.getMap());
	}
	
	// 测试集合属性注入---Properties
	@Test
	public void test7() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		CollectionDemo cd = (CollectionDemo) applicationContext.getBean("CollectionDemo");

		System.out.println(cd.getProps());
	}
}
