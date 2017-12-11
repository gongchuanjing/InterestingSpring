package tk.chuanjing.spring.chapter01.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ChuanJing
 * @date 2017年7月20日 上午4:47:13
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)// spring整合junit4
@ContextConfiguration(locations = "classpath:applicationContext.xml")// 指spring配置文件位置
public class AnnotationTest {

	@Autowired
	private IUserService userService;
	
	// 测试@Component
	@Test
	public void test1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService userService = (IUserService) applicationContext.getBean("userService");
		userService.add();
	}
	
	@Test
	public void test2() {
		userService.add();
	}
}