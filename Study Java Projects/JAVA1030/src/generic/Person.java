package generic;

public class Person { // Person extends Object
	// 멤버변수 선언
	String name;
	int age;
	
	// 파라미터 생성자 정의
	public Person(String name, int age) { 
		super();
		this.name = name;
		this.age = age;
	}

	// toString() 메서드 오버라이딩
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
