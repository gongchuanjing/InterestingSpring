package tk.chuanjing.spring.chapter03.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tk.chuanjing.spring.chapter03.transaction.service.IAccountService;

/**
 * @author ChuanJing
 * @date 2017年7月23日 下午12:51:22
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class AccountServiceImplTest {

	@Autowired
	private IAccountService accountService;
	
	@Test
	public void testAccount() {
		accountService.account("张森", "凤姐", 100);
	}

}
