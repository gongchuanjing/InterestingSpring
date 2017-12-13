package tk.chuanjing.spring.chapter03.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ChuanJing
 * @date 2017年7月23日 上午8:46:29
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class JdbcTemplateTest3 {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 测试修改
	@Test
	public void test1() {
		jdbcTemplate.update("update users set sex=? where id=?", "女", 8);
	}
	
	// 测试添加
	@Test
	public void test2() {
		jdbcTemplate.update("insert into users values(null, ?, ?, ?, null, ?, ?, null)",
							"spring_孙八", "123", "spring_sb", "男", 70);
	}
	
	// 测试删除
	@Test
	public void test3() {
		jdbcTemplate.update("delete from users where id = ?", 9);
	}
	
	// 测试返回简单数据类型
	@Test
	public void test4() {
		String name = jdbcTemplate.queryForObject("select username from users where id=?", String.class, 1);
		System.out.println(name);
	}
	
	// 测试返回简单数据类型
	@Test
	public void test5() {
		int count = jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
		System.out.println(count);
	}
	
	// 测试返回一个复杂的数据类型 User
	@Test
	public void test6() {
		String sql = "select * from users where id=?";
		Object[] args = {1};
		
		User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// 完成结果集封装成user对象操作
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				return user;
			}
		}, args);
		
		System.out.println(user);
	}
	
	// 测试返回一个复杂的数据类型 List<User>
	@Test
	public void test7() {
		String sql = "select * from users";
		List<User> list = jdbcTemplate.query(sql, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// 完成结果集封装成user对象操作
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				return user;
			}
		});
		
		System.out.println(list);
	}
	
	// 使用BeanPropertyRowMapper来完成结果集到Bean封装
	@Test
	public void test8() {
//		String sql = "select * from users where id=?";
//		Object[] args = {1};
//		User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), args);
//		System.out.println(user);
		
		
		String sql = "select * from users";
		List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		System.out.println(list);
	}
}