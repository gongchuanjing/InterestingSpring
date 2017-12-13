package tk.chuanjing.spring.chapter02.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ChuanJing
 * @date 2017年7月21日 上午4:15:00
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AopTest {

	@Autowired
//	@Qualifier("orderServiceProxy")	//配置DefaultAdvisorAutoProxyCreator后这行不用写了
	private IOrderService orderService;
	
//	@Autowired
//	@Qualifier("orderService")
//	private OrderServiceImpl orderService;
	
	@Test
	public void test1() {
		orderService.updateOrder();
	}
}
