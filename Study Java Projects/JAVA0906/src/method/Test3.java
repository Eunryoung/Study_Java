package method;

public class Test3 {

	public static void main(String[] args) {
		// 5. 파라미터가 2개 이상인 메서드 호출 연습
		// => 정수 2개를 전달하면 두 정수의 합을 리턴하는  메서드를 호출하고
		//	  리턴값을 출력(e.g. 10, 20 전달 시 10 + 20 결과인 30 리턴)
		int result = sum(10, 20);
		System.out.println("두 정수의 합은 " + result);
//		System.out.println("두 정수의 합은 " + sum(10, 20)); // 바로 계산 결과를 호출해서 출력해도 됨
		
		// => 연산자 문자 1개와 정수 2개를 전달하면
		// 	  두 정수에 대한 어떤 연산을 수행한 후
		//	  결과값을 리턴하는 메서드 호출하고 리턴되는 값을 출력
		// 	  e.g. '+', 10, 20 전달하면 10 + 20 결과인 30 리턴
		//		   '-', 10, 20 전달하면 10 - 20 결과인 -10 리턴
		int calculator = calc('-', 10, 20);
		System.out.println("결과값 : " + calculator);
	
	
	}// main() 메서드 끝

	// ========================================================
	
	
	
	// 5. 파라미터가 2개 이상인 메서드 정의 연습
	// => 정수 2개를 전달하면 두 정수의 합을 리턴하는 메서드를 정의
	public static int sum(int num1, int num2) {
		System.out.println("숫자1 = " + num1);
		System.out.println("숫자2 = " + num2);		
		return num1 + num2;
	}
	
	
	// => 연산자 문자 1개와 정수 2개를 전달받아 
	// 	  두 정수에 대한 어떤 연산을 수행한 후 결과값을 리턴하는 메서드 정의
	// 	  e.g. '+', 10, 20 전달하면 10 + 20 결과인 30 리턴
	//		   '-', 10, 20 전달하면 10 - 20 결과인 -10 리턴
	
	// < 쌤 코드 >
//	public static int calc(char a, int b, int c) {
//		if(a == '+') {
//			return b + c;
//		} else if(a == '-') {
//			return b - c;
//		} else {
//			// 잘못된 연산자가 입력되었을 경우(덧셈, 뺄셈만 가능하다고 가정)
//			// 오류 메세지 출력 후 0 리턴(가정)
//			System.out.println("연산자가 올바르지 않습니다!");}
//			return 0;
//		}
	
// < 쌤 코드 2 >
//		int calculator = 0; // 연산 결과를 저장할 변수
//		
//		if (calc == '+') { // 덧셈
//			calculator = b + c;
//		} else if(calc == '-') {
//			calculator = b - c;
//		} else {
//			// 잘못된 연산자가 입력되었을 경우
//			// 오류 메시지 출력 후 0 리턴(가정)
//			System.out.println("연산자가 올바르지 않습니다!");
//		}
//		
//		return calculator;
	
//	 < 내 코드>
	public static int calc(char a, int b, int c) {
		if(a == '+') {
			return b + c;
		} else if(a == '-') {
			return b - c;
		} else if (a == '*') {
			return b * c;
		} else if (a == '/') {
			return b / c;
		} else {
			return b % c;
		}
	}
	
	
} // Test3 클래스 끝
