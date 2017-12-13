package tk.chuanjing.spring.chapter02.proxy;

public class UserServiceImpl implements IUserService {

	@Override
	public void login(String username,String password) {
		System.out.println("登录操作。。。");
	}

	@Override
	public void regist() {
		System.out.println("注册操作...");
	}

}
