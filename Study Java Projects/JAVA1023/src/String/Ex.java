package String;

public class Ex {

	public static void main(String[] args) {
		/*
		 * String 객체(문자열) 생성 방법 두 가지
		 * 1. 리터럴 할당을 통해 생성하는 방법(일반적으로 사용하는 방법)
		 * 	  => 상수풀(Constant Pool)에서 동일한 문자열이 존재하는지 검사 후
		 * 		 존재하지 않으면 새로 생성하고, 존재하면 해당 주소값을 리턴함
		 * 		 (String은 참조 데이터타입이므로(기본 데이터타입 X) 주소값 리턴)
		 * 
		 * 2. 일반적인 클래스 인스턴스를 생성하는 방법(new 연산자를 사용하는 방법)
		 * 	  => String도 클래스이므로 인스턴스 생성 가능!
		 * 	  => new 연산자에 의해 Heap 공간에 문자열 객체를 생성하며,
		 * 		 동일한 문자열을 가진 객체가 존재하더라도 무조건 새로 생성함
		 */
		
		String s1 = "Hello";
		String s2 = "Hello";
		// => 생성된 s1 과 s2 는 문자열 내용도 같고, 주소값도 같다!
		//    (동일한 문자열이 존재하므로 해당 주소값을 리턴)
		
		// 동등비교연산자(==)를 사용한 두 문자열의 주소값 비교
		if(s1 == s2) {
			System.out.println("s1 과 s2 는 주소값이 같다!");
		} else { 
			System.out.println("s1 과 s2 는 주소값이 다르다!");
		}
		
		// String 클래스에서 오버라이딩 된 equals() 메서드를 사용한 두 문자열의 내용 비교
		if(s1.equals(s2)) { 
			System.out.println("s1 과 s2 는 문자열 내용이 같다!");
		} else {
			System.out.println("s1 과 s2 는 문자열 내용이 다르다!");
		}
		
		System.out.println("-----------------------------------------------");
		
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		// => 생성된 s3 과 s4 는 문자열 내용은 같지만, 주소값이 다르다!
		//    new 연산자를 사용해 클래스 인스턴스를 생성하면 
		//    동일한 문자열을 가진 객체가 존재하더라도 무조건 새로 생성한다!
		
		// 동등비교연산자(==)를 사용한 두 문자열의 주소값 비교
		if(s3 == s4) {
			System.out.println("s3 과 s4 는 주소값이 같다!");
		} else { 
			System.out.println("s3 과 s4 는 주소값이 다르다!");
		}

		// String 클래스에서 오버라이딩 된 equals() 메서드를 사용한 두 문자열의 내용 비교
		if(s3.equals(s4)) { 
			System.out.println("s3 과 s4 는 문자열 내용이 같다!");
		} else {
			System.out.println("s3 과 s4 는 문자열 내용이 다르다!");
		}
		
	}

}
