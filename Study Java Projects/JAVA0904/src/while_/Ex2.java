package while_;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * do ~ while 문
		 * - while 문은 조건을 먼저 검사하고 반복 여부를 결정하지만
		 *   do ~ while 문은 일단 반복문을 먼저 실행하고 난 뒤에 조건을 검사하여
		 *   다음 반복 여부를 결정함
		 * - while 문은 조건식에 따라 반복문이 단 한 번도 실행되지 않을 수도 있지만
		 *   do ~ while 문은 최소 한 번의 실행은 보장됨
		 *   
		 * < 기본 문법 >
		 * do {
		 * 		// 반복 실행할 문장
		 * } while(조건식);
		 * // => 주의! while 문 뒤에 반드시 세미콜런(;) 필수!
		 */
		
		int i = 11; // 초기식
		
		while(i <= 10) { // 조건식
			// 제어변수 i 초기값이 10보다 클 경우
			// 조건식 판별 결과가 false 이므로 반복문은 실행되지 못함!
			System.out.println("i = " + i); // 반복 실행할 문장
			i++; // 증감식
		}
		
		System.out.println("while문 종료 후 i 값 = " + i);
		
		System.out.println("--------------------------------");
		
		i = 11;
		
		do { // 조건식이 없으므로 블록문이 무조건 한 번 실행됨!
			 // 제어변수 i 초기값이 10보다 크더라도
			 // 조건식 판별을 마지막에 수행하므로 일단 실행문이 한 번 실행되고
			 // 이 후 조건식 판별 결과가 false 이므로 do ~ while 문을 빠져나감
			System.out.println("i = " + i); // 반복 실행할 문장
			i++; // 증감식
		} while(i <= 10);
		
		System.out.println("do ~ while 문 종료 후 i 값 = " + i);
		
	}

}
