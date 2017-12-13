package tk.chuanjing.spring.chapter02.aspectj_annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ChuanJing
 * @date 2017年7月21日 下午5:27:28
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AspectAnnotationTest {

	@Autowired
	private ICustomerService customerService;
	
	@Test
	public void test1() {
//		customerService.save();
//		customerService.update();
		customerService.search();
	}
}
