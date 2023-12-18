package String;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * StringBuffer와 StringBuilder
		 * - String 클래스는 한 번 생성되면 그 내부의 문자열이 변경되지 않음.
		 * - String 클래스를 사용하여 문자열을 계속 연결하거나 변경하는 프로그램을
		 * 	 사용하면 메모리 낭비가 심함
		 * - 이 때, StringBuffer 또는 StringBuilder를 활용하여 문자열을 변경하거나 연결.
		 * - 두 클래스는 크게 차이가 없으며
		 * 	 스레드가 동작하는 멀티스레드 프로그램이라면 문자열의 안전한 변경을 보장하는
		 * 	 StringBuffer 클래스를 사용하고,
		 *   스레드가 동작하지 않는 프로그램(단일스레드, 싱글스레드)이라면 실행 속도가 좀 더 빠른
		 *   StringBuilder 클래스를 사용 
		 */
		
		String str = new String("Java");
		
//		System.out.println("str 문자열 주소 : " + str); // Java => str.toString()와 동일한 출력결과!
//		System.out.println("str 문자열 주소 : " + str.toString()); 
		// => String 클래스에서 오버라이딩한 toString() 메서드가 동작
		// => 주소값을 표현하는 것이 아니라 안에 있는 문자열을 출력
		
		// 주소값을 알고싶을때는 System.identityHashCode()를 사용한다!
		System.out.println("str 문자열 주소 : " + System.identityHashCode(str));
		// => 인스턴스가 처음 생성될 때 메모리 주소 : 1023487453
		
		System.out.println(str); // Java
		// => System.out.println(str.toString());
		
		str = str + " and";
		System.out.println(str); // Java and
		System.out.println("str 문자열 주소 : " + System.identityHashCode(str));
		// => str 문자열 주소 : 1651191114 (변경됨!)
		// => "Java and"의 문자열을 갖는 메모리 영역이 새로 생성되었음을 알 수 있음.
		// => 기존의 "Java" 문자열을 갖는 메모리영역은 참조하는 변수가 없을 경우
		//	  자바에서 제공하는 가비지 컬렉터에 의해서 자동으로 사라짐
		
		str = str + " JSP";
		System.out.println(str); // Java and JSP
		System.out.println("str 문자열 주소 : " + System.identityHashCode(str));
		// => str 문자열 주소 : 1586600255 (새롭게 생성된 문자열!)
		
		str = str + " Programming is fun!";
		System.out.println(str); // Java and JSP Programming is fun!
		System.out.println("str 문자열 주소 : " + System.identityHashCode(str));
		// => str 문자열 주소 : 474675244
		
		System.out.println("----------------------------------------------------");
		
		String str2 = new String("Java");
		
		StringBuilder buffer = new StringBuilder(str2);
		// => StringBuilder 메모리 공간 생성(str2의 인스턴스의 "Java" 문자열을 가져와 초기값으로 지정)
		
		System.out.println("연산 전 buffer 메모리 주소 : " + System.identityHashCode(buffer));
		// => 연산 전 buffer 메모리 주소 : 932583850

		buffer.append(" and"); 
		// StringBuilder 클래스의 append() 메서드 호출
		System.out.println("연산 후 buffer 메모리 주소 : " + System.identityHashCode(buffer));
		// => 연산 후 buffer 메모리 주소 : 932583850 (동일한 주소값)
		
		buffer.append(" JSP"); 
		System.out.println("연산 후 buffer 메모리 주소 : " + System.identityHashCode(buffer));
		// => 연산 후 buffer 메모리 주소 : 932583850 (동일한 주소값)

		buffer.append(" Programming is fun!"); 
		System.out.println("연산 후 buffer 메모리 주소 : " + System.identityHashCode(buffer));
		// => 연산 후 buffer 메모리 주소 : 932583850 (동일한 주소값)
		
		// toString() 를 통해 String 클래스로 변환
		str2 = buffer.toString(); // StringBuilder에 오버라이딩 된 toString()
		// 지금까지 buffer에 저장되어있는 문자열을 toString() 메서드를 호출하여 String 타입 변수 str2에 주소값을 저장
		
		System.out.println(str2);
		System.out.println("새로 만들어진 str2 문자열 주소 : " + System.identityHashCode(str2));
		// => 새로 만들어진 str2 문자열 주소 : 212628335 (주소가 변경됨)

		
		
		
		
	}

}
