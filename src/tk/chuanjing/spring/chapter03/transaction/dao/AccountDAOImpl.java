package tk.chuanjing.spring.chapter03.transaction.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author ChuanJing
 * @date 2017年7月23日 上午11:43:33
 * @version 1.0
 */
public class AccountDAOImpl extends JdbcDaoSupport implements IAccountDAO {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	// 转出
	@Override
	public void accountOut(String outname, double money) {
		String sql = "update account set money = money - ? where name = ?";
		Object[] args = {money, outname};
//		jdbcTemplate.update(sql, args);
		this.getJdbcTemplate().update(sql, args);
	}

	// 转入
	@Override
	public void accountIn(String inname, double money) {
		String sql = "update account set money = money + ? where name = ?";
		Object[] args = {money, inname};
//		jdbcTemplate.update(sql, args);
		this.getJdbcTemplate().update(sql, args);
	}

}
