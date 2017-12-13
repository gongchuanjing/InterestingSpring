package tk.chuanjing.spring.chapter03.jdbctemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author ChuanJing
 * @date 2017年7月23日 上午8:46:29
 * @version 1.0
 */
public class JdbcTemplateTest1 {

	@Test
	public void test1() {

		// 1.创建一个数据库连接池
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		//2.设置datasource相关的属性(driverclass  url  username  password)
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/interestingssh");
		dataSource.setUsername("root");
		dataSource.setPassword("12345");
		
		//3.创建一个JdbcTemplate来完成操作
//		JdbcTemplate jdbcTemplate = new JdbcTemplate();
//		jdbcTemplate.setDataSource(dataSource);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("update users set username='spring_张三' where id=8");//execute方法可以执行任意sql
	}
}
