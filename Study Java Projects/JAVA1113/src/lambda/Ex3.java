package lambda;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 함수형 인터페이스(functional interface) 또는 타겟타입(target type)
		 * - 람다식은 결과적으로 "인터페이스의 클래스를 손쉽게 구현하는 방법"
		 * - 반드시 하나의 abstract 메서드만 존재
		 * - 만약 abstract 메서드가 없거나 두 개 이상 존재한다면 람다식으로 대체할 수 없다!
		 * - 함수형 인터페이스 @FunctionalInterface 어노테이션 선언
		 */
		
		// static 처리가 되어있고 자기 자신의 클래스 내부에서 생성된 useFIMethodA() 메서드 호출
		// => 매개변수로 MyFunc1 타입의 변수가 들어갈 수 있으므로 new 키워드를 사용해 
		//    일회성으로 사용할 익명 구현 객체를 매개변수로 대입
		useFIMethodA(new MyFunc1() {
			@Override
			public void methodA() {
				System.out.println("익명 내부 클래스 형태!");
			}
		});
		
		System.out.println("--------------------------------------------------------------");
		
		// 1. 파라미터와 리턴타입이 없는 람다식 표현(파라미터 : X, 리턴타입 : X)
		System.out.println("(파라미터 : X, 리턴타입 : X)");
		// 정적 메서드 useFIMethodA()의 파라미터가 MyFunc1의 인터페이스 타입이므로
		// 람다식으로 만들어지는 익명 객체가 파라미터로 사용됨
		
		// 표현방식 1
		useFIMethodA( () -> { 
			System.out.println("람다식1");
		}); // 매개변수가 없으므로 소괄호 안을 비워둔다(소괄호 생략 불가!)
		
		// 표현방식 2
		useFIMethodA( () -> System.out.println("람다식2") ); // 명령줄이 하나일 경우 중괄호{}와 세미콜론 생략 가능!
		
		System.out.println("------------------------------------------------------------------------------");
		
		// 2. 파라미터가 있는 람다식(파라미터 : O)
		// => 파라미터에 익명구현객체 대신 람다식을 바로 대입
		System.out.println(" (파라미터 : O) ");
		
		// 표현방식1
		useFIMethodB((String msg) -> { 
			System.out.println("람다식1 : " + msg);
		});
		
		// 표현방식2
		useFIMethodB( msg -> System.out.println("람다식1 : " + msg) );
		// 매개변수 하나이므로 소괄호 생략
		// 명령줄이 하나이므로 중괄호{}와 세미콜론 생략
		
		System.out.println("------------------------------------------------------------------------------");
		
		// 3. 리턴타입이 있는 람다식 (파라미터 : O, 리턴타입 : O)

		System.out.println("(리턴타입 : O)");
		
		// 표현방식 1
		String result = useFiMethodC( (String msg) -> { return "람다식1 : " + msg; } );
		
		// 표현방식 2
		System.out.println(useFiMethodC( msg -> "람다식2 : " + msg ));
		System.out.println(result);
		// 실행문이 단순히 리턴문 하나로 표현되는 경우 표현식만 사용할수있고리턴문 생략시 중괄호 세미콜론 생략
		
	} // main() 메서드 끝

	// 1. 파라미터와 리턴타입이 없는 람다식(파라미터 : X, 리턴타입 : X)
	public static void useFIMethodA(MyFunc1 fi) {
		fi.methodA();
	}
	
	// 2. 파라미터가 있는 람다식(파라미터 : O)
	public static void useFIMethodB(MyFunc2 fi) {
		fi.methodB("홍길동");
	}
	
	// 3. 리턴타입이 있는 람다식 (파라미터 : O, 리턴타입 : O)
	public static String useFiMethodC(MyFunc3 fi) {
		return fi.methodC("이순신");
	}
	
} // Ex3 클래스 끝


// 함수형 인터페이스를 사용하는 람다식 유형
// 1. 파라미터와 리턴타입이 없는 람다식 (파라미터 : X, 리턴타입 : X)
@FunctionalInterface
interface MyFunc1 {
	// 함수형 인터페이스 어노테이션(@FunctionalInterface) 선언 시 에러 발생!
	// => 함수형 인터페이스는 반드시 하나의 추상메서드(abstract method)를 가져야 함
	public void methodA();
//	public void methodB(); // 두 개의 추상메서드 선언 시 에러 발생! -> 주석 처리
}

// 2. 파라미터가 있는 람다식 (파라미터 : O)
@FunctionalInterface
interface MyFunc2 {
	public void methodB(String msg);
}

// 3. 리턴타입이 있는 람다식 (파라미터 : O, 리턴타입 : O)
@FunctionalInterface
interface MyFunc3 {
	public String methodC(String msg);
}