package for_;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 반복문
		 * - 특정 조건에 따라 지정된 범위의 문장들을 반복 실행하는 문
		 * - for문, while문으로 구분됨
		 * 
		 * 1. for문
		 * - 가장 기본적인 반복문
		 * - 반복 횟수가 정해져 있는 경우에 주로 사용
		 * - 초기식, 조건식, 증감식의 위치가 정해져 있어, 초보가 익히기 쉬움
		 * - 초기식 : 반복 횟수를 판별하기 위한 조건에 사용될 제어변수를
		 *            선언하거나 초기화하는 문장
		 * - 조건식 : 반복 여부를 결정하기 위한 조건식
		 *            => if문과 마찬가지로 true 일 때 블록 내의 문장을 실행하고
		 *               false 일 때 for문을 종료하고 빠져나감
		 * - 증감식 : 반복을 위한 조건식에 맞춰 초기식에서 초기화한 제어변수를
		 *            증가 또는 감소시키는 문장
		 * 
		 * < 기본 문법 >
		 * for(초기식; 조건식; 증감식) {
		 * 		// 조건식 결과가 true 일 때 반복 실행할 문장들...
		 * }
		 */
		
		// " x : Hello, World!" 문자열을 10번 반복 출력 (x는 현재 반복 횟수)
		System.out.println("1 : Hello, World!");
		System.out.println("2 : Hello, World!");
		System.out.println("3 : Hello, World!");
		System.out.println("4 : Hello, World!");
		System.out.println("5 : Hello, World!");
		System.out.println("6 : Hello, World!");
		System.out.println("7 : Hello, World!");
		System.out.println("8 : Hello, World!");
		System.out.println("9 : Hello, World!");
		System.out.println("10 : Hello, World!");
		
		System.out.println("----------------------------------------------");
		
		// 위의 10개의 출력문을 반복문(for)을 사용하여 압축
		// => 10번 반복을 위해서 제어변수 i가 1부터 10 이하일 동안
		//	  1씩 증가하면서 출력문을 반복 실행
		// => 초기식 : 제어변수 i를 선언하고 초기값인 1로 초기화(int i = 1)
		//	  조건식 : 제어변수 i가 10 이하일 때 true 조건( i <= 10)
		//	  증감식 : 제어변수 i를 1씩 증가 (i++ 또는 ++i)
//		for(int i = 1; i <= 10; i++) { // i++ 대신 ++i, i = i + 1, i += 1 적어도 됨
			// 조건식의 결과가 true 일 때 실행할 문장
//			System.out.println(i + " : Hello, World!");
//		}
		
//		System.out.println("for문 종료 후 i 값 = " + i);
		// => 오류 발생! i cannot be resolved to a variable
		// => 제어변수 i는 for문에서 선언된 변수이므로
		//	  for문의 블록 {}이 끝나면 사용 불가능한 변수(존재하지 않음!)
		// => 따라서, 제어변수 i를 for문 종료 후에도 사용하려면
		//	  최소한 for문 보다 위쪽(앞쪽)에서 선언해야 한다!
		
		int i = 1; // for문보다 위에 위치하므로 for문 종료 후에도 유지됨 
		
		for(i = 1; i <= 10; i++) { // int 지워줌(* duplicate)
			// 조건식의 결과가 true 일 때 실행할 문장			
			System.out.println(i + " : Hello, World!");
		}
		
		System.out.println("for문 종료 후 i 값 = " + i);
		
		/* 
		 * 위의 for문에 대한 디버깅(Debugging)
		 * ----------------------------------------------------------------------------
		 * 초기식(i)	조건식(i <= 10)		실행결과(i + "Hello, World!") 	증감식(i++)
		 * ----------------------------------------------------------------------------
		 * 		1			true				1 : Hello, World!			1 -> 2			
		 * 		2			true				2 : Hello, World!			2 -> 3	
		 * 		3			true				3 : Hello, World!			3 -> 4
		 * 		4			true				4 : Hello, World!			4 -> 5
		 * 		5			true				5 : Hello, World!			5 -> 6
		 * 		6			true				6 : Hello, World!			6 -> 7
		 * 		7			true				7 : Hello, World!			7 -> 8
		 * 		8			true				8 : Hello, World!			8 -> 9
		 * 		9			true				9 : Hello, World!			9 -> 10
		 * 		10			true				10 : Hello, World!			10 -> 11
		 * 		11			false				for문을 빠져나감!	 
		 */
		
		System.out.println("===========================================================");
		
		// 제어변수 i가 1 ~ 10 까지 1씩 증가하면서 i값 출력
		// => 출력 예시 : 1 2 3 4 5 6 7 8 9 10
		
		for(i = 1; i <= 10; i++) { // 조건문에 i < 11 써도 됨
			// 반복할 문장
			System.out.print(i + " ");
		}
		
		System.out.println(); // 줄바꿈 역할
		System.out.println("------------------------------------------");
		
		// 제어변수 i가 1 ~ 10까지 2씩 증가하면서 i값 출력(홀수 출력)
		// => 출력 예시 : 1 3 5 7 9
		for(i = 1; i <= 10; i += 2) {
			// 반복할 문장
			System.out.print(i + " ");
		}
		
		System.out.println(); // 줄바꿈 역할
		System.out.println("------------------------------------------");
		
		// 제어변수 i가 1 ~ 10까지 2씩 증가하면서 i값 출력(짝수 출력)
		// => 출력 예시 : 2 4 6 8 10
		for(i = 2; i <= 10; i += 2) {
			// 반복할 문장
			System.out.print(i + " ");
		}
		
		System.out.println(); // 줄바꿈 역할
		System.out.println("------------------------------------------");
		
		// 제어변수 i가 10 ~ 1씩 감소하면서 i 값 출력(역순으로 출력)
		// => 출력 예시 : 10 9 8 7 6 5 4 3 2 1
		for(i = 10; i >= 1; i--) {
			System.out.print(i + " ");
		}
		
//		Ctrl + Shift + { : 세로 듀얼 창
//		Ctrl + Shift + _ : 가로 듀얼 창
		
		
	}

}
