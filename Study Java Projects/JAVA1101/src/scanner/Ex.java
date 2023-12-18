package scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex {

	public static void main(String[] args) {
		/*
		 * Scanner
		 * - 화면, 파일, 문자열과 같은 입력소스로부터 문자데이터를
		 * 	 읽어오는데 사용되는 클래스
		 * - 여러 형태의 생성자를 오버로딩하여 지원하므로 다양한
		 *   입력소스로부터 데이터를 읽을 수 있음
		 *   (e.g. scanner(String source), scanner(file source) 등)
		 * - 정규표현식(Regular Expression)을 이용한 라인단위의 검색을 지원
		 * - nextXXX() 메서드를 통해 입력받은 문자를 다시 변환하는 수고를 덜어줌
		 * 	 (e.g. nextInt() : int, nextLine() : String)
		 * - Scanner를 사용하기 위해서는 java.util.Scanner 클래스의 import가 필요
		 *   
		 * < Scanner 설정 문법 >
		 * Scanner 변수 = new Scanner(); // 입력을 받을 시 System.in 활용
		 * 변수.nextXXX() 메서드를 호출하여 입력 받음
		 */
		
		Scanner scan = new Scanner(System.in); // System.in : 콘솔 창에 키보드로 입력(c.f. System.out : 모니터에 출력)
		String input = "";
		
//		do {
//			System.out.println("원하는 값을 입력하세요. 프로그램을 종료하려면 Q 를 입력하세요 : ");
			// 입력한 값을 라인 단위로 읽어옴 
//			input = scan.next();
			// => 공백을 허용하지 않을 때 사용
			// => 1 1 을 넣으면 공백을 구분자(delimiter) 로 생각하여 앞의 1만 입력받아
			//	  input에 대입
			
//			input = scan.nextLine();
			// => 라인 전체를 문자열로 인식
			// => 1 1 을 넣으면 1 1 이 출력
			
//			System.out.println("입력하신 값은 " + input + "입니다!");
			
//		} while(!input.equals("Q"));
//		System.out.println("프로그램을 종료합니다!");
		
		System.out.println("=======================================================");
		
//		try {
//			System.out.println("숫자(정수)를 입력하세요 : ");
//			int num = scan.nextInt();
//			System.out.println("입력하신 값은 " + num + "입니다!");
//			// => 정수가 아닌 다른 값을 입력하면 InputMismatchException 예외 발생!
//			
//		} catch(InputMismatchException e) { // 예외는 클래스! 참조변수 써주기
//			e.printStackTrace();
//			System.out.println("숫자(정수)만 입력하세요!");
//		}
//		
//		System.out.println("프로그램을 종료합니다!");
		
//		System.out.println("숫자(실수)를 입력하세요 : ");
//		double dNum = scan.nextDouble();
//		System.out.println("입력하신 값은 " + dNum + "입니다!");
		// => 정수값을 입력하면 실수로 인식
		
		System.out.println("true 또는 false를 입력하세요 : ");
		boolean b = scan.nextBoolean();
		System.out.println("입력하신 값은 " + b + "입니다!");
		// => 대소문자 구별없이 true 또는 false 입력 가능
		// => true 또는 false 이외의 값을 입력하면 InputMismatchException 예외 발생!
		
		
	}

}
