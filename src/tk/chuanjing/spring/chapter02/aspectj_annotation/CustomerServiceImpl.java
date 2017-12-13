package tk.chuanjing.spring.chapter02.aspectj_annotation;

import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void save() {
		System.out.println("customerService  save...");
	}

	@Override
	public void search() {
		System.out.println(10/0);
		System.out.println("customerService  search...");
	}

	@Override
	public int update() {
		System.out.println("customerService  update...");
		
		return 10;
	}
}