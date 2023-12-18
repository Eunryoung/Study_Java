package java_util_function;

import java.util.function.Consumer;

public class Ex {

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
		 * 
		 * 1. Consumer 계열(소비자)
		 * - 파라미터를 받아서 소비한다
		 * - 리턴하지 않음		
		 */
		
		// 익명의 내부 클래스 방식
		Consumer<String> consumer = new Consumer<String>() {
			
			// 익명의 내부클래스이므로 오버라이딩할 메서드가 존재!
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		
		consumer.accept("Hello");
		
		System.out.println("----------------------------------------------");
		
		// 람다식 형태
//		Consumer<String> consumer2 = (String x) -> { System.out.println(x); };
		Consumer<String> consumer2 = x ->  System.out.println(x); // 위와 형태는 다르나 동일한 식
		consumer2.accept("Hello2");
		
		System.out.println("----------------------------------------------");
		
		Student s1 = new Student("홍길동", 80);
		
		// 람다식은 심플하게 표현될 때 주로 사용하므로
		// 보통 한 줄로 표기 가능할 때 사용됨
		
		// 한 줄씩 표현하는 형태
		printStudent(s1, s -> System.out.println(s.name) );
		printStudent(s1, s -> System.out.println(s.score *= 1.5) );
		printStudent(s1, s -> System.out.println(s.name + ", " + s.score) );
		
		// 여러 줄로 표현하는 형태
		printStudent(s1, s -> {
			System.out.println(s.name);
			s.score *= 1.5;
			System.out.println(s.name + ", " + s.score);
		});
		
	} // main() 메서드 끝

	
	// 학생을 출력하려고 하는데 방식은 아직 미정
	// 출력방식 전달받을 경우 Consumer<Student> printer 형태를 사용
	public static void printStudent(Student s, Consumer<Student> printer) {
		printer.accept(s);
	}
	
	
} // Ex 클래스 끝

class Student {
	
	// 멤버변수 선언
	String name;
	double score;
	
	public Student(String name, double score) { // 파라미터 생성자 호출
		super();
		this.name = name;
		this.score = score;
	}
	
	
}