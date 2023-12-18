package interface_;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 인터페이스(Interface)
		 * - 클래스가 아니므로 선언 시 class 키워드를 사용하지 않고
		 * 	 interface 키워드를 사용하여 정의
		 * - 인터페이스는 상수와 추상메서드만 가질 수 있다!
		 * 	 => 모든 멤버변수는 public static final이 붙은 상수로 취급됨
		 * 		(public static final 생략 가능)
		 * 		(final로 인해 값 변경 불가,
		 * 		 static으로 인해 클래스명만으로 접근 가능,
		 * 		 public으로 인해 누구나 접근 가능)
		 *   => 모든 메서드는 public abstract가 붙은 추상메서드로 취급됨
		 *   	(public abstract 생략 가능)
		 *   	(메서드 바디를 가질 수 없으며, public으로 인해 누구나 접근 가능)
		 * - 추상클래스와 마찬가지로 추상메서드를 포함하므로 객체 생성 불가능
		 * 	 => 단, 참조변수 타입으로는 사용 가능(= 다형성을 활용한 업캐스팅 가능)
		 * - 서브클래스(구현클래스)에서 인터페이스를 상속받아 구현해야하는 경우
		 * 	 extends 키워드 대신 implements 키워드를 사용
		 * 	 => 클래스는 상속받아 확장(extends)의 개념이 강하지만,
		 * 		인터페이스는 상속받아 추상메서드들을 구현(implements)의 개념이 강함
		 * - 클래스는 서브클래스에서 다중 상속이 불가능하지만,
		 * 	 인터페이스는 서브클래스에서 다중 상속(구현)이 가능하다!
		 * 	 => implements 키워드 뒤에 복수개의 인터페이스 지정 가능
		 * - 인터페이스끼리 상속받을 경우 implements가 아닌 extends로 상속
		 * 	 => 추상메서드는 구현(implements)하지 못하기 때문
		 * 
		 * < 인터페이스 정의 기본 문법 >
		 * [접근제한자] interface 인터페이스명 {
		 *			// 상수
		 *			// 추상메서드 
		 * }
		 * 
		 * < 인터페이스를 상속받는(= 구현하는) 서브클래스(= 구현클래스) 정의 문법 >
		 * [접근제한자] class 클래스명 implements 인터페이스명 {}
		 */
		
		// 추상클래스는 인스턴스 생성이 불가능!
		// => Cannot instantiate the type MyClass
		// => 생성자가 있지만 추상메서드를 가지고 있으므로
		// 	  (= 메서드 실행 코드(= 바디)가 없으므로) 외부에서 호출할 수 없음
//		MyClass mc = new MyClass();
		
		// 인터페이스도 인스턴스 생성이 불가능!(상수, 추상메서드만 가질 수 있다!)
		// => Cannot instantiate the type MyExInterface
		// => 생성자 자체가 존재하지 않음
//		MyExInterface mi = new MyExInterface();
		
		// 인터페이스를 구현한 서브클래스(구현체클래스) 인스턴스 생성
		MySubClass msc = new MySubClass();
		msc.method1();
		msc.method2();
		msc.method3();
		
		// 인터페이스 내의 모든 변수는 상수이므로 값 변경 불가
		// => 구현체 클래스도 동일한 상수가 상속됨
//		MyExInterface.NUM1 = 99; // 변경 불가!
//		MySubClass.NUM1 = 99; // 변경 불가!
//		msc.NUM1 = 99; // 변경 불가!
		
		System.out.println("===============================================");
		
		// 인터페이스는 인스턴스 생성은 불가능하지만 참조변수 타입으로 사용 가능
		// => 구현체 클래스의 인스턴스를 인터페이스 타입으로 업캐스팅 가능
		//	  = 다형성 활용 가능
		MyExInterface mi2 = new MySubClass(); // 업캐스팅
		// 업캐스팅 후에는 참조 영역이 축소되므로 상속된 메서드만 호출 가능
		// => 인터페이스의 추상메서드를 모두 오버라이딩 했기 때문에
		//	  인터페이스가 가진 모든 메서드를 참조 영역 축소 후에도 호출 가능!
		mi2.method1();
		mi2.method2();
		mi2.method3();
		
		// 상수도 인터페이스에서 선언했으므로 업캐스팅 후에도 접근 가능
		System.out.println(mi2.NUM1);
		System.out.println(mi2.NUM2);
		
		// 상수는 인스턴스를 통한 접근보다 클래스 또는 인터페이스명으로 접근
		System.out.println(MyExInterface.NUM1);
		System.out.println(MyExInterface.NUM2);
		

	} // main() 메서드 끝

} // Ex 클래스 끝

// 추상클래스 정의(인터페이스와 비교)
abstract class MyClass {
	// 클래스 내의 모든 멤버변수는 상수가 아니며, 선언 방법에 따라 달라짐
	public static final int NUM1 = 10; // 상수
	public int num2 = 20; // 인스턴스 멤버변수(상수 X) -> 값 변경 가능
	
	public MyClass() {} // 생성자
	// => 추상클래스는 생성자를 가질 수 있다!
	// => 다만, 추상메서드를 가지고 있어 메서드 실행 코드(= 바디)가 없으므로 외부에서 호출할 수 없다!
	
	public abstract void method1(); // 추상메서드
	// => 추상메서드를 갖는 클래스는 반드시 추상클래스로 선언해야 한다!
	
	public void method2() {} // 일반메서드
	// => 추상클래스는 일반메서드도 가질 수 있다!
	
}


// 인터페이스 정의
// => 클래스 내부에서도 인터페이스를 정의할 수 있음!
// => class 키워드 대신 interface 키워드를 사용하여 정의
interface MyExInterface {
	// 인터페이스 내의 모든 멤버변수는 상수(public static final) 이다!
//	public static final int NUM1; // 상수 표기 : 대문자 + 언더스코어
	// => 인터페이스는 반드시 선언 시 초기화를 수행해야 한다!
	// => 인터페이스는 생성자가 존재하지 않으므로 생성자에서 상수를 초기화 할수 없기 때문!
	public static final int NUM1 = 10; // 상수
	int NUM2 = 20; // 상수(public static final이 생략되어 있더라도 상수로 취급됨)
	
	// 인터페이스는 생성자를 가질 수 없다!(상수, 추상메서드만 가질 수 있다!)
//	public MyExInterface() {} // 컴파일 에러 발생!
	// => Interfaces cannot have constructors
	
	// 인터페이스 내의 모든 메서드는 추상메서드(public abstract)이다!
	public abstract void method1(); // 추상메서드
	
//	public void method2() {} // 일반메서드처럼 구현 시 컴파일 에러 발생!
	// => Abstract methods do not specify a body
	// => abstract 키워드 없이 정의해도 인터페이스 내라면 추상메서드로 취급됨
	// => 추상메서드여야 하므로 메서드 바디{} 를 가질 수 없다!
	public void method2(); // abstract 키워드가 생략되어 있어도 추상메서드로 취급됨
	
	void method3(); // public abstract 생략되어 있어도 추상메서드로 취급됨
	
}

// 인터페이스를 상속 받아 구현하는 서브클래스(구현클래스) MySubClass 정의
// => 서브클래스 정의 시 클래스명 뒤에 implements 키워드를 쓰고 인터페이스명 지정
class MySubClass implements MyExInterface { 
	// => 추상메서드 오버라이딩을 실행해야 오류 해결!
	
	// 추상메서드 오버라이딩 작업 수행
	@Override
	public void method1() {
		System.out.println("서브클래스에서 구현한 추상메서드 method1()");
	}

	@Override
	public void method2() {
		System.out.println("서브클래스에서 구현한 추상메서드 method2()");
	}

	@Override
//	private void method3() {
		// 만약, 접근제한자 public 쓰지 않을 경우 에러 발생!
		// => Cannot reduce the visibility of the inherited method from MyExInterface
		// 인터페이스에서 method3() 메서드 정의 시 접근제한자를 생략했지만
		// 인터페이스 내의 모든 메서드는 public 접근제한자를 가지므로
		// 오버라이딩을 통한 구현 시 무조건 public 접근제한자만 사용 가능
		// (메서드 오버라이딩 규칙 상 접근제한자는 같거나 넓은 범위로만 변경 가능 = 좁아질 수 없다!)
	public void method3() {
		System.out.println("서브클래스에서 구현한 추상메서드 method3()");
	}
	
}