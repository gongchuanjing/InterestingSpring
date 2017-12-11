package tk.chuanjing.spring.chapter01.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("userDao")
@Scope("singleton")
public class UserDAOImpl implements IUserDAO {

	@Override
	public void add() {
		System.out.println("userDao add...");
	}
	
	//初始化配置  init-method
	@PostConstruct
	public void myInit() {
		
	}

	//销毁操作 destroy-method，只用当Scope为"singleton"时才有效
	@PreDestroy
	public void myDestroy() {
		
	}
}
