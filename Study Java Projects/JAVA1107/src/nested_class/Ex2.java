package nested_class;

public class Ex2 {

	public static void main(String[] args) {
		Outer2 out = new Outer2(); // 기본생성자 호출
		out.method();
	} // main() 메서드 끝

} // Ex2 클래스 끝

class Outer2 {
	private int num = 10; // 인스턴스 멤버변수
	
	public void method() { // 인스턴스 멤버메서드
		// 인스턴스 멤버메서드 내에서는 인스턴스 멤버변수 및 메서드에 대해
		// 자유롭게 접근이 가능
		System.out.println(num);

		// 로컬 내부 클래스에 접근하기 위해서는
		// 클래스 선언부보다 아래쪽에 위치해야 함!
//		LocalInner localInner = new LocalInner(); // 기본생성자 호출 시 컴파일 에러 발생!
		// => LocalInner cannot be resolved to a type
		// => 아직 존재하지 않는 클래스!
		
//		public int num2 = 20; // 컴파일 에러 발생
		// => Illegal modifier for parameter num2; only final is permitted
		// => 로컬(지역) 변수(메서드 내의 변수)에서는 접근제한자를 사용할 수 없다!
		//    => 메서드가 호출되지 않으면 어차피 외부에서 접근이 불가능하므로 접근제한자 의미가 없기 때문
		
//		static int num2 = 20; // 컴파일 에러 발생
		// => Illegal modifier for parameter num2; only final is permitted
		// => 로컬(지역) 변수(메서드 내의 변수)에서는 static 키워드를 사용할 수 없다!
		
		
		// 로컬 내부클래스 정의 : 생성자, 메서드 블럭 안에 클래스 키워드가 나올 시
		// => 메서드 내에서 정의하며, 특정 메서드에서만 사용 가능한 클래스
		// => 로컬 변수와 마찬가지로 접근제한자, static 키워드 사용 불가
//		public class LocalInner { // 클래스 선언시 접근제한자 사용할 시 컴파일 에러 발생!
		// => Illegal modifier for the local class LocalInner; only abstract or final is permitted
//		static class LocalInner { // 클래스 선언시 static 키워드 사용할 시 컴파일 에러 발생!
			// => Illegal modifier for the local class LocalInner; only abstract or final is permitted
		
		class LocalInner { // 클래스 선언부
			String name = "LocalInnerClass"; // 로컬(지역) 내부 클래스의 인스턴스 변수
			
//			static int staticMember;
			// => 로컬 내부클래스에서는 static 변수를 사용할 수 없음!
			// => The field staticMember cannot be declared static in a non-static inner type,
			// 	  unless initialized with a constant expression
			
//			public static void staticMethod() { }
			// => 마찬가지로 로컬 내부클래스에서는 static 메서드를 사용할 수 없음
			// => The method staticMethod cannot be declared static; 
			//    static methods can only be declared in a static or top level type
			
			public LocalInner() { // 생성자 정의
				System.out.println("LocalInner() 생성자 호출됨!");
			}
			
			public void print() {
				System.out.println("로컬 내부클래스의 인스턴스 멤버 메서드!");
			}
			
			
		} // 로컬 내부 클래스인 LocalInner 클래스 끝
		
		// 로컬 내부클래스의 인스턴스 생성(일반 클래스처럼 사용 가능)
		// => 로컬 내부클래스는 메서드 내에서 객체를 생성하고 사용해야 한다!
		LocalInner localInner = new LocalInner(); // 기본생성자 호출
		System.out.println(localInner.name);
		
	} // method() 끝
	
} // Outer2 클래스 끝