package lambda;


public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 익명 객체를 생성하는 람다식
		 * - 자바는 객체 지향 언어로 객체 없이 메서드를 호출할 수 없다.
		 * - 람다식은 객체 없이 인터페이스의 구현만으로 메서드를 호출할 수 있는데
		 *   그 이유는 익명 내부 클래스에 있다.
		 * - 익명 내부 클래스는 클래스 이름 없이 인터페이스 자료형 변수에 바로 메서드 구현부를 생성하여 대입할 수 있음
		 * - 즉, 람다식으로 메서드를 구현해서 호출하면 컴퓨터 내부에서는 
		 *   익명클래스가 생성되고 이를 통해 익명 객체가 생성되는 것
		 *     
		 */
		
		StringConcat concat3 = new StringConcat() {
			
			@Override
			public void makeString(String s1, String s2) {
				System.out.println(s1 + "," + s2);
			}
		};
		// => 내부적으로 익명 구현 객체가 생성되어 메서드를 호출할 수 있게 됨
		
		concat3.makeString("Hello", "World");
		
		System.out.println("-------------------------------------------------------------------");
		
		/*
		 * 람다식에서 사용하는 지역 변수
		 * - 람다식 코드에서는 외부 메서드의 지역 변수를 수정할 수 엇음
		 *   그 이유는 지역 변수는 메서드 호출이 끝나면 메모리에서 사라지기 때문에
		 *   익명 내부 클래스에서 사용하는 경우에는 지역 변수가 상수로 변하기 때문
		 */

		int i = 100; // main() 메서드의 지역 변수
		
		StringConcat concat2 = (s, v) -> { // 매개변수의 데이터타입을 알고있다는 전제 하에 생략 가능(현재 경우는 String)
//			i = 200; // main() 메서드의 지역변수 i는 상수(final) 이므로 값 변경 불가!
			// => Local variable i defined in an enclosing scope must be final or effectively final
			System.out.println(i); // 값 변경은 불가능하지만 가져다 쓸 수는 있음(출력 가능)
			System.out.println(s + "," + v);
		};
		// => 람다식을 쓴다는건 따로 new 키워드를 쓰지않아도 내부적으로 익명 구현 객체가 만들어진다는걸 뜻한다
		//    (자바가 익명 구현객체를 new 키워드로 만들어줌 => @FunctionalInterface 어노테이션 선언을 해놓았으므로!)
		//    함수형 인터페이스에 메서드가 두 개 이상 존재할 경우 오류 발생!(연결할 메서드가 두 개 이상이 되므로)
		
		concat2.makeString("itwill", "busan");
		//	  람다식 내부에서 따로 makeString() 메서드를 오버라이딩 하지 않았지만
		//    매개변수 두개를 전달 시 concat2 참조변수를 통해 itwill,busan 출력됨 

	}

}

@FunctionalInterface
interface StringConcat {
	public void makeString(String s1, String s2);
}

