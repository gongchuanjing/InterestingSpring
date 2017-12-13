package tk.chuanjing.spring.chapter02.aspectj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AspectJTest {

	@Autowired
	private IUserService userService;

	@Test
	public void test1() {
//		userService.add();
		userService.del();
	}
}
