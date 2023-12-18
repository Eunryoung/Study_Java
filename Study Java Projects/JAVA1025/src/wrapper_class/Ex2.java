package wrapper_class;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 오토 박싱(Auto Boxing)
		 * - 기본 데이터타입 -> Wrapper 클래스타입의 객체로 자동으로 변환하는 기능
		 *   (ex. int -> Integer, char -> Character) 
		 * 
		 * 오토 언박싱(Auto Unboxing)
		 * - Wrapper 클래스 타입 객체 -> 기본 데이터타입으로 자동으로 변환하는 기능
		 *   (ex. Integer -> int, Character -> char)
		 */
		
		// 기본 데이터타입 변수 선언
		int num1 = 10; // 정수 데이터 10을 기본 데이터타입 변수 num1에 저장
		int num2;
		
		// 기본 데이터타입 변수는 그대로 출력하면 저장된 정수데이터가 출력됨
		// => 즉, 변수에 저장된 데이터가 실제 사용하는 데이터
		System.out.println("기본 데이터타입 변수 num1 의 값 = "+ num1);
		
		// Integer 참조타입 변수 선언
		Integer n1;
//		Integer n2 = new Integer(20); 
		// @deprecated => 취소선 처리 => 자바에서는 이 내용이 보안적으로 좋지않거나 잘 쓰이지않고 
		//                               다른 형태로 사용하고자 한다면 취소선 처리를 한다.
		// The constructor Integer(int) has been deprecated since version 9 and marked for removal
		// => Integer(int) 형태는 자바9버전부터 취소되었다.
		
		
		Integer n2 = new Integer("20"); // 문자열로 된 정수를 실제 정수로 변환
		// => 실제 넣은 값과 상관없이 ()앞에 붙은 생성자를 보고 int 로 판단하고 자동으로 변환한다.
		// => 정수 20을 갖는 인스턴스를 생성하고 해당 주소값을 Integer 타입 참조변수 n2에 저장
		
		// 참조 데이터타입 변수는 그대로 출력하면 원래 주소값이 출력되어야 하지만
		// Wrapper 클래스에서는 toString() 메서드가 오버라이딩 되어 있으므로
		// 객체가 저장한 값을 문자열로 리턴하므로 데이터 출력 가능함
		System.out.println("참조타입 변수 n2의 값 = " + n2); // toString() 생략됨
		
		System.out.println("-----------------------------------------------");
		
		// 기본 데이터타입은 Stack 공간에 실제 데이터 형태를 직접 관리하지만
		// 객체는 Heap 공간에 실제 데이터가 저장되고,
		// 해당 주소값을 Stack 공간에서 관리함
		// 따라서, 기본데이터타입 변수와 참조데이터타입 변수는 호환이 불가능!
		// 기존(자바 1.5버전 이전)에는 기본데이터타입 <-> 참조데이터타입 변환 시 메서드 등을 활용해야 했음
		
		n1 = Integer.valueOf(num1);
		// => int형 데이터를 Integer 타입 객체로 변환하여 저장
		// => num1 변수를 valueOf() 메서드를 사용하여 감싸주면
		//    Integer 참조타입으로 변환된다.
		
		// => n1 참조변수는 Heap 메모리 영역의 객체를 참조하고 있지만
		//    valueOf() 메서드 사용시 파라미터로 전달한 값을 가진
		//    새로운 객체가 생성되고 해당 객체를 새로 참조하게 된다.
		
		System.out.println(num1 + ", " + n1); // 10, 10
		
		// Java 1.5 부터 기본형 -> Wrapper 클래스타입으로 변환 시
		// 메서드를 호출하는 변환 과정을 생략해도 자동으로 변환을 수행하도록 변경됨
		// => 즉, 대입연산자를 통해 직접 대입이 가능하도록 바뀜
		n1 = num1; // 기본 데이터를 자동으로 Integer 타입으로 변환하여 저장
		// => 오토 박싱(Auto Boxing)
		System.out.println(num1 + ", " + n1); // 10, 10
		
		// Heap 공간에 생성된 Wrapper 클래스타입 객체를 기본형 변수에 저장할 경우
//		num2 = n2.intValue(); // Integer 객체 -> int 타입으로 변환하는 메서드
		// => 오토 언박싱을 활용할 경우 자동으로 변환을 수행해준다!
		num2 = n2; // Integer 객체 -> 기본 데이터타입으로 자동 변환
		// 오토 언박싱(Auto Unboxing)
		
		System.out.println(num2 + ", " + n2); // 20, 20
		
		System.out.println("------------------------------------");
		
		int num3 = 10;
		Integer n3 = 20;
		System.out.println(num3 + n3);
		// => 기본 데이터타입과 Wrapper 클래스타입 간의 연산을 수행할 경우
		//    Wrapper 클래스타입 객체를 오토 언박싱 후 연산을 수행함(Integer 객체 -> int 타입)
		//	  Integer 참조 타입 변수 n3을 int 타입으로 오토 언박싱
		
		System.out.println("------------------------------------");
		
		// Object 타입 변수에 기본 데이터타입 저장 가능하다.
		// => 단, 기본데이터타입 -> Wrapper 클래스 타입으로 오토박싱 후
		//    다시 Wrapper 클래스타입 객체 -> Object 타입으로 업캐스팅 일어남
		Object o = 10;
//		 < 변환 과정 > 
//		 Object o = int 10; 를 수행해야 하므로
//		 1. int -> Integer 변환 : 10을 자동으로 박싱하는 과정(= 오토박싱)
//		 2. Object o = new Integer(10); => Integer -> Object 타입으로 업캐스팅
		System.out.println(o); // toString() 메서드 호출 생략
		
		
	}

}
















