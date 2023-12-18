package lambda;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 람다식(Lambda Expressions)
		 * - 자바 8에 추가된 가장 큰 특징
		 * - "함수형" 프로그래밍 형태를 받아들인 결과
		 * 
		 * 함수형 프로그램이란? (함수형 vs 객체지향)
		 * - 함수형 : 1950년대, 객체지향 : 1990년대 (역사가 더 오래되었음)
		 * - 기능 위주의 프로그래밍 기법
		 * - 매개변수만을 사용하여 만드는 함수(순수 함수, pure function) 를 구현하고 호출함으로써 
		 *   외부 자료에 부수적인 영향을 주지 않도록 구현하는 방식
		 * - 객체 지향 : 객체를 기반으로 구현, 클래스에 속성과 기능을 정의
		 *   함수형 : 함수를 기반으로 자료를 입력받아 구현, 기능 즉 함수가 따로 존재
		 * 
		 * - 함수 이름이 없는 익명 함수를 만드는 것
		 *   메서드의 이름과 리턴타입을 빼고 '->'를 활용하여 람다식을 구현
		 *   e.g. int add(int x, int y) {
		 *   		return x + y;
		 *   	  }
		 *   	  의 메서드를 람다식으로 표현하면
		 *   	  (int x, int y) -> { return x + y; }  
		 * 
		 * < 람다식 기본 문법 >
		 * (데이터타입 매개변수, ...) -> { 실행문, ... }
		 * 
		 * 1. 기본형
		 * (int x) -> { System.out.println(x); }
		 * 
		 * 2. 매개변수의 타입을 추론할 수 있는 경우에는 타입 생략 가능
		 * (x) -> { System.out.println(x); }
		 * 
		 * 3. 매개변수나 실행문이 하나라면 소괄호() 와 중괄호 {} 를 생략할 수 있음
		 *    (이 때, 세미콜론(;)은 생략!)
		 * x -> System.out.println(x)
		 * 주의! 매개변수가 두 개 이상인 경우 소괄호() 를 생략할 수 없다!
		 * 
		 * 4. 매개변수가 없을 경우 소괄호() 를 사용한다. (생략 불가!)
		 * () -> System.out.println(x)
		 * 
		 *			public void XXX() {
		 * 					System.out.println(x);
		 * 			}  => 와 동일한 식!
		 *
		 * 5. 리턴이 필요한 경우 return 키워드를 사용
		 * (x, y) -> { return x + y; }
		 * 주의! return 문은 중괄호를 생략할 수 없다!
		 * (한 줄이더라도 return 키워드 명시할 경우 반드시 중괄호 사용!)
		 * 
		 * 6. 실행문이 단순히 return 문 하나로 표현되는 경우
		 *    표현식만 사용할 수 있으며, 이 때 리턴값은 표현식의 결과값이 됨
		 *    (주의! 이 때, 세미콜론을 붙이지 않는다!)
		 * (x, y) -> return x + y
		 */
		
		// MaxPrintNumber 클래스 활용
		MaxPrintNumber mpn = new MaxPrintNumber();
		System.out.println(mpn.maxNum(10, 20));
		
		System.out.println("-----------------------------");
		
		// 구현클래스를 활용한 getMax 메서드 호출
		MyNumber max = new MyNumberClass(); // 업캐스팅
		System.out.println(max.getMax(10, 20));
		
		// 람다식 구현과 호출
		MyNumber max2 = (x, y) -> (x >= y) ? x : y; 
		// => 람다식을 인터페이스형 max2 변수에 대입
		System.out.println(max2.getMax(10, 20)); // 인터페이스형 변수로 메서드 호출
		
	}

}

//=================================================================
//두 수를 입력받아 큰 수를 출력하는 메서드를 가진 클래스 정의
class MaxPrintNumber {
	public int maxNum(int num1, int num2) {
		if(num1 >= num2) {
			return num1;
		} else {
			return num2;
		}
	}
}

// ===========================================================
// MyNumberClass에서 구현하는 인터페이스 정의
// interface MyNumber {
//	 int getMax(int num1, int num2); // 추상메서드 선언
// }

// MyNumber 인터페이스를 구현한 MyNumberClass 정의
class MyNumberClass implements MyNumber {
	
	// 두 수를 입력받아 둘 중 큰 숫자를 리턴하는 getMax() 메서드 정의
	@Override
	public int getMax(int num1, int num2) {
		if(num1 >= num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
}

// 위의 getMax() 메서드를 람다식으로 표현하기 위해 
// 함수형 인터페이스 선언하기
// => 자바에서는 참조변수 없이 메서드를 호출할 수 없음
// => 람다식을 구현하기 위해 함수형 인터페이스를 만들고, 
//    인터페이스에 람다식으로 구현할 메서드를 선언하는 형태로 사용
// => 주의! 람다식은 하나의 메서드를 구현하여 인터페이스형 변수에 대입하므로
//	  인터페이스가 두 개 이상의 메서드를 가지면 안된다!
@FunctionalInterface // 함수형 인터페이스 용도로 사용됨을 알림(추상메서드를 하나만 쓰기 위함)
interface MyNumber {
	int getMax(int num1, int num2); // 추상메서드 선언
//	int add(int num1, int num2); // 추상메서드 두 개 선언 시 오류 발생해 주석 처리
}
// => Invalid '@FunctionalInterface' annotation; MyNumber is not a functional interface
// => 함수형 인터페이스 어노테이션이 명시되어 있으나 
//    두 개의 메서드가 선언되어있으므로 함수형 인터페이스가 될 수 없다! (메서드 하나 주석 처리)
