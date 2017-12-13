package tk.chuanjing.spring.chapter01.ioc;
/**
 * @author ChuanJing
 * @date 2017年7月19日 下午11:59:02
 * @version 1.0
 */
public class UserServiceImpl implements IUserService {

	private String info;
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public void sayHello() {
		System.out.println("hello " + info);
	}

}
