package java_util_function;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 자바에서 제공하는 함수형 인터페이스
		 * java.util.function 패키지
		 * 
		 * 					  파라미터			리턴
		 * Consumer  계열		O				X
		 * Supplier  계열		X				O
		 * Function  계열		O				O
		 * Operator  계열		O				O
		 * Predicate 계열		O				boolean
		 * 
		 * 3. Function 계열
		 * - 파라미터, 리턴 모두 존재
		 */
		
		FunctionTest ft = new FunctionTest();
		
		ft.addPerson((name, age) -> new Person(name, age), "홍길동", 20);
		
		ft.printPerson(name -> {
			if(ft.person.name.equals(name)) {
				return ft.person.toString();
			} else {
				return "unKnown user";
			}
		}, "홍길동");
		
		ft.printAge(name -> {
			if(ft.person.name.equals(name)) {
				return ft.person.age;
			} else {
				return 0;
			}
		}, "홍길동");
		
		System.out.println("------------------------------------------------------");
		
		// 위의 람다식 표현을 익명 내부클래스로 코딩
		// => 람다식 표현이 어려울 경우 new 연산자로 익명 구현 객체 코드부터 짜볼것
		FunctionTest ft2 = new FunctionTest();
		
		ft2.addPerson(new BiFunction<String, Integer, Person>() {

			@Override
			public Person apply(String t, Integer u) {
				return new Person(t, u);
			}
		}, "이순신", 44);
		
		ft2.printPerson(new Function<String, String>() {

			@Override
			public String apply(String t) {
				if(ft2.person.name.equals(t)) {
					return ft2.person.toString();
				} else {
				return "unKnown user";
			}

			}
		}, "이순신");
		
		ft2.printAge(new ToIntFunction<String>() {

			@Override
			public int applyAsInt(String value) {
				if(ft2.person.name.equals(value)) {
					return ft2.person.age;
				} else {
					return 0;
				}
			}
			
		}, "이순신");
	} // main() 메서드 끝

}

// Person 클래스 정의
class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

class FunctionTest {
	Person person;
	
	// String과 Integer를 매개변수로 받고 Person 객체를 리턴하는
	// BiFunction 타입에 String, Integer를 받는 메서드 apply() 활용
	public void addPerson(BiFunction<String, Integer, Person> function, String name, Integer age) {
		person = function.apply(name, age);
	}
	
	// String을 파라미터로 받고 String을 리턴하는
	// Function 타입에 String을 받는 메서드 apply() 활용
	public void printPerson(Function<String, String> function, String name) {
		System.out.println(function.apply(name));
	}
	
	// String을 파라미터로 받아 int를 리턴하는
	// ToIntFunction 타입에 메서드 applyAsInt() 활용
	public void printAge(ToIntFunction<String> function, String name) {
		System.out.println(name + "의 나이 : " + function.applyAsInt(name));
	}
}