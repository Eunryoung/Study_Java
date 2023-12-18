package if_;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * if ~ else문
		 * - 조건식 판별 결과가 true 일 때와 false 일 때 서로 다른 블록을 실행
		 * - 삼항연산자와 유사한 형태로 수행되나 삼항연산자보다 유연함
		 *   (조건식 판별 결과에 따라 실행 가능한 문장 더 다양함)
		 * - if문 블록은 조건식 결과가 true 일 때 실행하고,
		 *   else문 블록은 조건식 결과가 false 일 때 실행함.
		 *   => 둘 중 하나의 블록만 실행
		 *   
		 * < 기본 문법 >
		 * 문장1;
		 * 
		 * if(조건식) {
		 * 		문장2; // 조건식 결과가 true 일 때 실행할 문장들...
		 * } else {
		 * 		문장3; // 조건식 결과가 false 일 때 실행할 문장들...
		 * }
		 * 
		 * 문장4;
		 * 
		 * => 조건식 판별 결과 true  : 문장1 -> 조건식(true ) -> 문장2 -> 문장4
		 * => 조건식 판별 결과 false : 문장1 -> 조건식(false) -> 문장3 -> 문장4
		 */
		
		// 정수 num에 대한 절대값 계산
		int num = -5; // 문장1
		
		if(num < 0) { // 조건식
			// 조건식 결과가 true 일 때 실행할 문장들...
			System.out.println("음수이므로 양수로 변환!"); // 문장2
			num = -num;
		} else {
			// 조건식 결과가 false일 때 실행할 문장들..
			System.out.println("양수이므로 변환 생략!"); // 문장3
		}
		
		System.out.println("num의 절대값 : " + num); // 문장4
		
		
		System.out.println("=======================================");
		
		// 정수 num2에 대해 홀수, 짝수(0 포함) 판별
		int num2 = 9;
		
		// 홀수 : 정수 num2를 2로 나눈 나머지가 1일 경우(1과 같을 경우)
		// 짝수 : 정수 num2를 2로 나눈 나머지가 0일 경우(0과 같을 경우)
		
		// if문을 사용하여 홀수일 경우 "num은 홀수!" 출력하고
		// 아니면(짝수일 경우) "num은 짝수!" 출력
		if((num2 % 2) == 1) { // 홀수일 경우 // num2 % 2 > 0과 동일한 결과
			System.out.println(num2 + " : 홀수!");
		} else { // 홀수가 아닐 경우 = 짝수(또는 0)일 경우
			System.out.println(num2 + " : 짝수!");
		}
		
	}

}
