package while_;

public class Ex {

	public static void main(String[] args) {
		/*
		 * while문
		 * - for문과 마찬가지로 특정 조건식의 판별 결과가 true일 동안 반복
		 * - for문과 달리 조건식 위치만 정해져 있고,
		 *   초기식과 증감식의 위치는 유동적으로 변함(생략도 가능)
		 *   (개발자가 정해야 함!)
		 * - for문은 주로 반복 횟수가 정해져 있는 경우 사용하며,
		 *   while문은 주로 반복 횟수가 정해져 있지 않은 경우 사용
		 * - for문과 while문은 100% 상호 변환이 가능함!
		 * 
		 * < 기본 문법 >
		 * [초기식;] // while문 보다 위에 위치해야함(생략도 가능)
		 * 
		 * while(조건식) {
		 * 		[증감식;]		
		 * 		// 조건식 결과가 true일 때 반복 실행할 문장
		 *  	[증감식;] // 증감식 위치는 반복할 문장보다 위에 올 수도 있다!
		 * }
		 * 
		 * 
		 */
		
		// for문을 사용하여 "Hello, World!" 문자열을 10번 반복 출력
		for(int i = 1; i <= 10; i++) {
			System.out.println(i + " : Hello, World!");
		}
		
		System.out.println("-------------------------------------------");
		
		// 위의 for문을 while문으로 변환
		
		int i = 1; // 초기식. 생략 가능하기도함. 적는다면 while 위에 적기
		
		while(i <= 10) {
			System.out.println(i + " : Hello, World!"); // 반복 실행문
			i++; // 증감식
		}
		
		// 제어변수 i가 while문 보다 위쪽에서 선언되었으므로
		// while문 반복 종료 후에도 변수 i값에 접근 가능함
		System.out.println("while문 종료 후 i 값 = " + i);
		
		System.out.println("-------------------------------------------");
		
		
		// 제어변수 i가 1 ~ 10 까지 1씩 증가하면서 i 값 출력
		// => 1 2 3 4 5 6 7 8 9 10
		i = 1; // 초기식
		
		while(i <= 10) { // 조건식
			System.out.print(i + " ");
			i++; // 증감식
		}
		
		System.out.println(); // 줄바꿈 역할
		System.out.println("-------------------------------------------");
		
		// 제어변수 i가 1 ~ 10 까지 2씩 증가하면서 i 값을 출력(홀수 출력)
		// => 1 3 5 7 9
		
		i = 1; // 초기식
		
		while(i <= 10) { // 조건식
			System.out.print(i + " ");
			i = i + 2; // i += 2;
		}
		
		System.out.println(); // 줄바꿈 역할
		System.out.println("-------------------------------------------");
		
		i = 1; // 초기식
		
		while(i <= 10) { // 조건식
			if(i % 2 == 1) {
				System.out.print(i + " ");
			}
			i++; // 증감식
		}
		
		System.out.println(); // 줄바꿈 역할
		System.out.println("-------------------------------------------");
		
		
		// 제어변수 i가 1 ~ 10까지 2씩 증가하면서 i 값을 출력(짝수 출력)
		// => 2 4 6 8 10
		
		i = 2; // 초기식
		
		while(i <= 10) { // 조건식
			System.out.print(i + " ");
			i += 2; // i += 2; // 증감식
		}
		
		System.out.println(); // 줄바꿈 역할
		System.out.println("-------------------------------------------");
		
		// 제어변수 i가 10 ~ 1까지 1씩 감소하면서 i값을 출력(역순으로 출력)
		// => 10 9 8 7 6 5 4 3 2 1
		
		i = 10; // 초기식
		
		while(i >= 1) { // 조건식
			System.out.print(i + " ");
			i--; // 증감식
		}
		
		System.out.println();
		System.out.println("=========================================================");
		
		
		// 증감식의 위치에 따라 초기식, 조건식이 바뀔 수 있다!
		
		i = 0; // 초기식
		
		while(i <= 10) { // 조건식
			i++; // 증감식
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("while문 종료 후 i 값 = " + i);
								
	}

}
