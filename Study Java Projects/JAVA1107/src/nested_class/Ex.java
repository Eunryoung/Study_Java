package nested_class;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 중첩클래스(Nested Class)
		 * - 클래스 내에서 정의한 클래스
		 * - 중첩클래스를 사용하면 두 클래스의 멤버들을 서로 쉽게 접근할 수 있고,
		 *   외부에서는 불필요한 관계 클래스를 감춤으로써 코드의 복잡성을 줄일 수 있는 장점
		 * - 독립적인 일반 클래스 형태로 작성할 필요는 없지만,
		 *   나름대로 클래스 형태(멤버변수, 메서드, 생성자)를 갖춰야 할 때 사용
		 * - 보통, 자신의 클래스 내에서만 접근 가능하도록
		 *   전용 클래스로 정의할 때 사용
		 *   => 주로 GUI 구현 시 이벤트 처리를 위한 핸들러 클래스 정의 시 사용
		 * - 외부클래스(Outer Class)와 내부클래스(Inner Class)로 구분됨
		 * - 내부클래스는 클래스 정의 위치에 따라 구분되며
		 *   클래스 멤버로서 선언되는 중첩 클래스를 [멤버 클래스] 라고 하며,
		 *   생성자 또는 메서드 내부에서 선언되는 중첩 클래스를 [로컬 클래스] 라고 함.
		 * - 멤버클래스는 다시 객체를 생성해야만 하는 1) 인스턴스 멤버 클래스와 
		 *   클래스로 바로 접근할 수 있는 2) 정적 멤버 클래스로 구분할 수 있음.
		 *   
		 *  1) 인스턴스 멤버(내부) 클래스
		 *  - 멤버변수 및 메서드와 동일한 레벨에 정의한 클래스
		 *  - static 키워드를 지정하지 않은 클래스
		 *  - 인스턴스 멤버 변수(필드)와 메서드만 선언이 가능하고
		 *    정적 변수(필드)와 정적 메서드는 선언 불가
		 *  - 반드시 외부클래스 인스턴스 생성 후 접근 가능 
		 *  
		 *  2) 정적 멤버(내부) 클래스
		 *  - 멤버변수 및 메서드와 동일한 레벨에 정의한 클래스
		 *  - static 키워드를 지정한 클래스
		 *  - 모든 종류의 필드와 메서드를 선언 가능
		 *  - 외부클래스명만으로 접근 가능
		 *  
		 *  3) 로컬 멤버(내부) 클래스(= 로컬 클래스)
		 *  - 클래스 내의 메서드 내에서 정의한 클래스
		 *  
		 * < 중첩 클래스 기본 문법 >
		 * class 바깥쪽클래스명 {
		 * 		class 안쪽클래스명 {
		 * 
		 * 		}
		 * }
		 */
		
//		Inner inner = new Inner(); // 컴파일 에러 발생!
		// => Inner cannot be resolved to a type
		
		// 1. 인스턴스 멤버(내부) 클래스에 접근
		// => 반드시 외부클래스의 인스턴스 생성 후 참조변수를 통해
		//    내부클래스에 접근해야 한다!
		Outer outer = new Outer();
		
		// 외부클래스를 통해 내부클래스의 인스턴스 생성할 경우
		// 반드시 외부클래스명.내부클래스명 타입으로 변수를 지정하고
		// 외부클래스참조변수명.new 내부클래스명() 형태로 인스턴스 생성
		Outer.Inner inner = outer.new Inner();
		// => 참조변수 선언 시 외부클래스명.내부클래스명 타입으로도 선언이 가능함
		//    (또는 Change to 'nested_class.Outer.Inner' 처리해도 됨 => nested_class는 패키지명이므로 동일한 타입이다!)
		inner.innerMethod();
		System.out.println(inner.innerNum);
		
		// ----------------------------------------------------------------------
		// 2. 정적 내부 클래스에 접근
		// => 정적 내부 클래스는 static 키워드가 적용되어 있으므로
		//	  클래스가 메모리에 로딩될 때 정적 내부 클래스도 함께 로딩됨
		//	  따라서, 내부클래스 접근 문법은 외부클래스 인스턴스 생성 없이(Outer outer = new Outer(); 없어도 됨)
		//	  외부 클래스명만으로 접근 가능
		// => 외부클래스명.내부클래스명 참조변수명 = new 외부클래스명.내부클래스명();
		Outer.StaticInner staticInner = new Outer.StaticInner();
		
		System.out.println(staticInner.innerNum); // 참조변수명.변수명
		
	} // main() 메서드 끝

} // Ex 클래스 끝

class Outer { // 외부클래스(= 바깥쪽 클래스)
	private int num = 10; // 인스턴스 멤버변수
	int num2 = 20; // 인스턴스 멤버변수
	static int num3 = 30; // 정적 멤버변수(= 클래스 멤버)
	
	public void method() { // 인스턴스 멤버메서드
		// 인스턴스 멤버메서드 내에서는 인스턴스 멤버변수 및 메서드에 대해
		// 자유롭게 접근이 가능
		System.out.println("인스턴스 멤버변수 num = " + num);
		method2(); // 일반 인스턴스 멤버 메서드 호출 가능
	} 
	
	
	public void method2() { // 인스턴스 멤버메서드
		System.out.println("인스턴스 메서드 method2()");
	}
	
	public static void method3() { // 정적 멤버메서드
		// 정적 메서드 내에서는 인스턴스 멤버에 대한 접근 불가
//		System.out.println("인스턴스 멤버변수 num = " + num); // 접근 불가!
		// => Cannot make a static reference to the non-static field num
		
		System.out.println("정적 멤버변수 num3 = " + num3); // 정적 멤버는 접근 가능
		
	}
	
	// ------------------------------------------------------------------------------
	// 인스턴스 멤버(내부) 클래스
	class Inner { // 중첩클래스(인스턴스 멤버 클래스) => new 키워드로 인스턴스 생성시 만들어짐
		// 인스턴스 멤버 내부클래스에서는 외부클래스의 멤버에 자유롭게 접근 가능
		// => 인스턴스 멤버 메서드의 접근 범위와 동일함

		int innerNum = 100;
		
//		static int innerNum2 = 200;
		// => The field innerNum2 cannot be declared static in a non-static inner type, 
		// 	  unless initialized with a constant expression
		// => static 변수를 선언할 수 없다!
		
		public void innerMethod() {
			System.out.println("외부 클래스의 인스턴스 멤버변수 num = " + num);
			// => 외부클래스의 멤버변수 접근 가능
			method2(); //  외부 클래스의 메서드도 호출 가능
		}
		
//		public static void innerStaticMethod() {}
		// => The method innerStaticMethod cannot be declared static;
		// 	  static methods can only be declared in a static or top level type
		// => static 메서드를 정의할 수 없음!
		
	} // Inner 인스턴스 멤버(내부) 클래스 끝
	
	// ---------------------------------------------------------------------------
	// 정적 멤버 내부클래스 정의
	static class StaticInner {
		int innerNum = 100;
		
		static int innerStaticNum = 200;

		// 정적 멤버 내부클래스에서는 외부클래스의 인스턴스 멤버에 접근 불가!
		// => 메모리 로딩 시점이 다르기 때문(= 정적 메서드와 동일한 규칙 적용)
		public void innerMethod() {
//			System.out.println("외부클래스의 인스턴스 멤버변수 num = " + num);
			// => 외부클래스의 멤버변수 접근 불가능
//			method2(); // 외부클래스의 멤버메서드도 호출 불가능
		}
		
		public static void innerStaticMethod() {
//			System.out.println("내부클래스의 인스턴스 멤버변수 innerNum = " + innerNum); // 접근 불가!
			// => Cannot make a static reference to the non-static field innerNum
			System.out.println("내부클래스의 정적 멤버변수 innerStaticNum = " + innerStaticNum); 
			// => static 멤버 변수에는 접근 가능!
			
		}
	}
	
} // Outer 클래스(= 외부클래스) 끝