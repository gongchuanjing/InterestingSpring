package tk.chuanjing.spring.chapter02.aspectj;

public class UserServiceImpl implements IUserService {

	@Override
	public void add() {
		System.out.println("userService add...");
	}

	@Override
	public void update() {
		System.out.println("userService update...");
	}

	@Override
	public String del() {
//		System.out.println(10 / 0); // 一定会抛出异常
		System.out.println("userService del...");

		return "hello world";
	}

	@Override
	public void search() {
		System.out.println("userService search...");
	}

}
