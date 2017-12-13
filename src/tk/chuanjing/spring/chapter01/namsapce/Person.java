package tk.chuanjing.spring.chapter01.namsapce;

public class Person {

	private String name;
	private int age;
	private Dog dog;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", dog=" + dog + "]";
	}

}
