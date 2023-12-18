package method;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 메서드(Method)
		 * - 동작(작업)의 최소 단위(= 작업을 수행하는 코드들의 모음)
		 *   ex) "밥먹다"의 기능을 메서드로 표현(밥을 떠서 입에 넣고 씹기 등)
		 * - 메서드는 반드시 호출되어야만 실행될 수 있음
		 *   => 호출하는 메서드 : Caller, 호출 당하는 메서드 : Worker
		 * - 메서드 호출 시 메서드에 전달하는 값을 전달인자(Argument) 라고 하며,
		 *   이 전달 인자를 전달받아 저장하는 변수를 매개변수(Parameter)라고 함.
		 *   => 파라미터 있을 수도 있고, 없을 수도 있음.
		 * - 메서드가 호출되면 작업을 수행한 후에 반드시 호출한 위치로 돌아감
		 *   => 이 때, 호출한 곳으로 전달하는 값을 리턴값(Return Value) 이라고 함
		 * - 리턴타입을 명시한 메서드는 반드시 return 문을 사용하여 데이터를 리턴
		 *   => 단, 리턴타입이 void 인 메서드는 return 문을 생략해도 되고
		 *      리턴값 없이 return 문만 기술할 수 있다!
		 *   => 메서드 내에서 return 문을 만나면 즉시 메서드를 종료하고 돌아감
		 *   => if 문 등의 조건식을 사용하여 return 문을 실행할 경우
		 *      반드시 어떤 경우에도 return 문이 실행되도록 조건식을 작성해야함.
		 *      
		 * - main() 메서드는 자바에서 유일하게 호출하지 않아도 
		 *   프로그램 실행 시점에서 자동으로 호출되는 메서드
		 *   => main() 메서드를 자바 프로그램의 시작점(Starting Point)이라고 함.
		 * - 메서드 호출 시 메서드 매개변수와 일치하는 타입 및 개수의
		 *   데이터 전달이 필수! (메서드 호출 형태로 정의 형태가 일치해야함)         
		 *   
		 * < 메서드 정의 기본 문법 >
		 * [접근제한자] 리턴타입 메서드명([매개변수선언..]) {
		 * 		// 메서드 호출 시 수행할 코드들...
		 * 		// [return [리턴값];]
		 * }
		 * 
		 * < 메서드 호출 기본 문법 >
		 * 1. 리턴값이 없는 경우
		 *    메서드명([데이터...]);
		 * 
		 * 2. 리턴값이 있는 경우
		 *    1) 데이터타입 변수명 = 메서드명([데이터...]);
		 *       => 리턴되는 데이터를 변수에 저장할 경우
		 *    2) System.out.println(메서드명([데이터...]);
		 *       => 리턴되는 데이터를 출력하거나 직접 연산에 사용하는 경우
		 * 
		 * 
		 * < 메서드 형태 4가지 >
		 * 1. 파라미터도 없고, 리턴값도 없는 메서드
		 * 2. 파라미터는 없고, 리턴값만 있는 메서드
		 * 3. 파라미터만 있고, 리턴값은 없는 메서드
		 * 4. 파라미터도 있고, 리턴값도 있는 메서드
		 * 
		 */
		
		// 1. 파라미터도(전달할 값)도 없고, 리턴값(돌려받을 값)도 없는 메서드 호출
		System.out.println("동생아! 불 좀 꺼줘!");
		sister_1();
		System.out.println("동생이 불을 끄고 갔다!");
		
		// 주의! 리턴값이 없는 메서드를 출력문에서 호출하거나 변수에 대입 불가!
//		String result = sister_1();
		// 오류 발생!
		// => Type mismatch: cannot convert from void to String
//		System.out.println(sister_1());
		
		System.out.println("====================================================");
		
		// 2. 파라미터(전달할 값)도 없고, 리턴값(돌려받을 값)만 있는 메서드 호출
		System.out.println("동생아! 물 좀 떠줘!");
//		sister_2();
		// => 리턴값이 있는 메서드 호출 후 변수에 저장하거나 출력문에 사용 가능
		//	  만약, 아무 동작도 없을 경우 메서드 호출 후 리턴값은 버려짐
		
		String result = sister_2();
		// => sister_2() 메서드 호출 후 리턴값("물")을 전달 받아
		//	  String 타입 변수 result에 저장(String result = "물"과 동일함)
		System.out.println("동생이 가져다 준 것 : " + result);
		
		// 리턴값을 변수에 저장하지 않고 직접 사용 가능
		System.out.println("동생이 가져다 준 것 : " + sister_2());
		
		
	} // main() 메서드 끝	
		
	
	/* < 메서드 정의 기본 문법 >
	 * [접근제한자] 리턴타입 메서드명([매개변수선언..]){
	 * 		// 메서드 호출시 수행할 코드들...
	 * 		// [return [리턴값];]
	 * }
	 */
	
	// --------------------------------------------------------------------------------------------------
	// 1. 파라미터도 없고, 리턴값도 없는 메서드 정의
	// => 메서드 파라미터가 없으므로 선언부 소괄호() 안에 아무것도 명시하지 않음
	// => 리턴값이 없으므로 리턴타입 부분에 특수한 데이터타입 void 타입을 명시
	// 	  (void = 리턴값이 없다는 의미)
	
	public static void sister_1() {
		// sister_1() 메서드가 호출됐을 때 수행할 작업들을 기술
		System.out.println("동생 : 오빠가 불을 끄라고 해서 불을 껐다!");
	}
	
	// 2. 파라미터는 없고, 리턴값만 있는 메서드 정의
	// => 메서드 파라미터가 없으므로 선언부 소괄호() 안에 아무것도 명시하지 않음
	// => 리턴값이 있으므로 리턴할 데이터와 일치하는 데이터타입을
	//	  리턴타입 부분에 명시(문자열을 리턴하려면 String 타입을 명시)
	
	public static String sister_2() {
		// => This method must return a result of type String
		System.out.println("동생 : 오빠가 물을 떠오라고 시켜서 물을 떠다 줬다!");
		return "물";
//		System.out.println("동생이 물을 가져다 줬다!"); // 
	}
	
	
} // Ex 클래스 끝
