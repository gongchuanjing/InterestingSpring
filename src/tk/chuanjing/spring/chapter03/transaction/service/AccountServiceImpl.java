package tk.chuanjing.spring.chapter03.transaction.service;

import org.springframework.transaction.annotation.Transactional;

import tk.chuanjing.spring.chapter03.transaction.dao.IAccountDAO;

/**
 * @author ChuanJing
 * @date 2017年7月23日 上午11:44:02
 * @version 1.0
 */
public class AccountServiceImpl implements IAccountService {

	private IAccountDAO accountDAO;
	
	public IAccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(IAccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}


	// 转账操作的方法
	@Override
	@Transactional()	//注解使用事务
	public void account(String outname, String inname, double money) {
		
		// 从outname转出money
		accountDAO.accountOut(outname, money);
		
//		int a = 10 / 0; // 一定会抛出异常
		
		// 向inname转入money
		accountDAO.accountIn(inname, money);
	}

}
