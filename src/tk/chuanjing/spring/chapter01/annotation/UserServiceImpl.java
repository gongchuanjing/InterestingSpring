package tk.chuanjing.spring.chapter01.annotation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//@Component("userService")
@Service("userService")
// <bean id="userService" class="cn.itheima.annotation.UserServiceImpl">
public class UserServiceImpl implements IUserService {
	
	@Value("张三")
	private String name;
	
	// @Autowired	//默认是按照类型来进行注入
	// @Qualifier("userDao")
	@Resource(name="userDao")
	private IUserDAO userDao;
	
	@Override
	public void add() {
		// System.out.println("userService add.." + name);
		userDao.add();
	}

//	@Value("李四")
	public void setName(String name) {
		this.name = name;
	}
}
