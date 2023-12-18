package java_util_function;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Ex2 {

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
		 * 2. Supplier 계열(공급자)
		 * - 파라미터를 받지 않음
		 * - 자체적으로 리턴할 값을 생성한다.
		 */
		
		System.out.println("============= Supplier<T> ===============");
		
		// 익명의 내부클래스 방식
		// <T>의 값이 return 타입을 결정함
		
		// 익명 객체를 통한 구현
		Supplier<String> supplier = new Supplier<String>() {
			
			// 익명의 내부클래스이므로 오버라이딩할 메서드가 존재!
			@Override
			public String get() {
				return "Hello";
			}
		};
		
		System.out.println(supplier.get());
		
		System.out.println("----------------------------------------------");

		// 위의 익명 객체를 통한 구현방식을 람다식으로 표현
		Supplier<String> supplier2 = () -> "Hello2";
		// 파라미터가 없으므로 소괄호() 생략 불가
		// 단순한 리턴문 1개 이므로 중괄호{} 생략 가능, return 생략 가능
		// <T>의 값이 return 타입을 결정함
		
		System.out.println(supplier2.get());
		
		// PSupplier
		// P : Boolean, Integer, Long, Double을 의미(Wrapper 클래스)
		
		System.out.println("============= PSupplier ===============");
		
		IntSupplier supplier3 = () -> {
			Random random = new Random();
			return random.nextInt(6) + 1;
		};
		
		System.out.println(supplier3.getAsInt());
		
	}

	
}
