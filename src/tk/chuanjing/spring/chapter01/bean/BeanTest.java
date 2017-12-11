package tk.chuanjing.spring.chapter01.bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author ChuanJing
 * @date 2017年7月20日 上午12:43:34
 * @version 1.0
 */
public class BeanTest {

	// 使用BeanFactory来获取Bean1
	@Test
	public void test1() {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		Bean1 bean1 = (Bean1) factory.getBean("Bean1");
		bean1.show();
	}

	// 使用ClassPathXmlApplicationContext来获取Bean1
	@Test
	public void test2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean1 bean1 = (Bean1) applicationContext.getBean("Bean1");
		bean1.show();
	}

	// FileSystemXmlApplicationContext
	@Test
	public void test3() {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		Bean1 bean1 = (Bean1) applicationContext.getBean("Bean1");
		bean1.show();
	}

	// 静态工厂方法获取Bean
	@Test
	public void test4() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean2 bean2 = (Bean2) applicationContext.getBean("Bean2");
		bean2.show();
	}
	
	// 实例工厂方法获取Bean
	@Test
	public void test5() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean3 bean3 = (Bean3) applicationContext.getBean("Bean3");
		bean3.show();
	}
	
	// 测试bean的scope属性
	@Test
	public void test6() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean1 bean1 = (Bean1) applicationContext.getBean("Bean1");
		Bean1 bean11 = (Bean1) applicationContext.getBean("Bean1");
		// System.out.println(bean1 == bean11); //scope=singleton true
		// System.out.println(bean1 == bean11); //scope=prototype false
	}

	// 测试bean的生命周期
	@Test
	public void test7() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		BeanLifeCycle beanLife = (BeanLifeCycle) applicationContext.getBean("BeanLifeCycle");
		IBeanLifeCycle beanLife = (IBeanLifeCycle) applicationContext.getBean("BeanLifeCycle");
		beanLife.add();
		applicationContext.close();
	}
	
	//Bean的实例化方式3 :实例工厂
	//问题containsLocalBean("bean3")与containsBean("bean3")的区别
	@Test
	public void test8(){
		ClassPathXmlApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean3 bean3 = (Bean3) applicationContext.getBean("Bean3");
		Bean3 bean03 = (Bean3) applicationContext.getBean("Bean3");
		System.out.println("是否一样：" + (bean3==bean03));
		
		boolean containsBean = applicationContext.containsBean("Bean3");
		System.out.println("applicationContext关闭之前是否包含bean3"+"\t"+containsBean);
		
		boolean containsLocalBean = applicationContext.containsLocalBean("Bean3");
		System.out.println("containsLocalBean    "+containsLocalBean);
		applicationContext.close();
		
		// spring初始化Ioc容器很重要的一个方法是由ApplicationContext子接口ConfigurableApplicationContext提
		// 供的refresh(),这个方法的作用是创建加载Spring容器配置（包括.xml配置，property文件和数据库模式等）
//		applicationContext.refresh();
//		boolean containsBeanAfterClose = applicationContext.containsBean("Bean3");
//		System.out.println("applicationContext关闭之后 再refresh是否包含bean3    "+containsBeanAfterClose);
		System.out.println("后containsLocalBean:    "+applicationContext.containsLocalBean("Bean3"));
		System.out.println("后containsLocalBean:    "+applicationContext.containsLocalBean("environment"));
	}
	
	//问题containsLocalBean("bean3")与containsBean("bean3")的区别
	@Test
	public void test9(){
		ClassPathXmlApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("containsBean:    "+applicationContext.containsBean("systemProperties"));
		System.out.println("containsLocalBean:    "+applicationContext.containsLocalBean("systemProperties"));
	}
}
