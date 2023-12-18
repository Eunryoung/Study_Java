package if_;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 다중 if ~ else if문 (if ~ else if ~ else 문)
		 * - 두 가지 이상의 조건식을 사용하여 세 가지 이상의 경우의 수 판별
		 * - 기본 if문으로 첫 번째 조건을 설정하고, else if 문으로
		 *   두 번째 이후의 조건을 설정한다.
		 * - 모든 조건이 만족하지 않을 때 실행할 문이 있을 경우 문장의
		 *   마지막에 else 문 사용
		 * - if문 비교는 위에서 아래로 차례대로 비교를 수행한다.
		 *   => 비교 범위가 좁은 조건식부터 비교를 수행해야 한다!
		 *   
		 * < 기본 문법 >
		 * if(조건식1) {
		 * 		// 조건식1의 결과 true 일 때
		 * } else if(조건식2) {
		 * 		// 조건식1의 결과가 false 이고, 조건식2의 결과가 true 일 때
		 * } else if(조건식n) {
		 * 		// 조건식 1 ~ n-1 의 결과가 false 이고, 조건식 n의 결과가 true 일 때
		 * } else {
		 * 		// 위의 모든 조건식(n까지) 결과가 false 일 때
		 *		// 마지막 실행 문장...
		 *		// 마지막 else 문은 생략 가능
		 * }
		 */
		
		// 정수 num이 양수(0보다 클 경우)일 때 "양수!" 출력하고,
		// 아니면, 정수 num이 음수(0보다 작을 경우)일 때 "음수!" 출력하고
		// 둘 다 아닐 경우(0일 경우) "0" 출력 
		
		int num = 0;
		if(num > 0) { // 양수일 때
			System.out.println(num + " : 양수!");
		} else if(num < 0) { // 음수일 때
			System.out.println(num + " : 음수!");
		} else { // 양수도 아니고 음수도 아닐 때 (= 0일 때)
			System.out.println(num + " : 0!");
		}
		
		System.out.println("===================================");
		
		// 정수형 변수 num에 대해 홀수, 짝수 판별
		// 단, 홀수와 짝수가 아닌 0을 별도로 판별
		num = 0;
		
		// if문은 위에서부터 차례대로 조건을 검사한다!
//		if((num % 2) == 1) { // 홀수일 경우
//			System.out.println(num + " : 홀수!");
//		} else if((num % 2) == 0) { // 짝수일 경우
//			System.out.println(num + " : 짝수!");
//		} else { // 홀수와 짝수가 아닐 경우(0)
//			System.out.println(num + " : 0!");
//		}
		
		// => 주의! 0은 2로 나눈 나머지가 0이므로 짝수 판별식에서 true가 됨
		//		따라서, 0을 출력하는 문장은 실행될 수가 없다!
		
		
		
		if((num % 2) == 1) { // 홀수일 경우
			System.out.println(num + " : 홀수!");
		} else if(num == 0) { // 0일 경우
			System.out.println(num + " : 0!");
		} else { // 짝수인 경우(else if((num % 2) == 0) 사용해도 동일함)
			// 최소한 0을 판별하는 조건식보다 아래쪽에 짝수를 판별해야 함!
			System.out.println(num + " : 짝수!");
		}
		
		System.out.println("========================================");
		
		num = 11;
		
		// num이 5보다 클 경우 "5보다 크다!"
		// num이 10보다 클 경우 "10보다 크다!"
		if(num > 5) {
			System.out.println("5보다 크다!"); // 이미 첫 문장에서 5보다 크므로
		} else if(num > 10) {
			// num > 5 조건식 범위 안에 num > 10 조건식이 포함되므로
			// num > 10 조건식은 실행될 수 없는 문장이다!
			System.out.println("10보다 크다!"); // 두 번째 문장까지 넘어갈 수 없음
		}
		
		// 만약, 6 ~ 9의 숫자를 판단하려면?
		// else if 문 작성 시에는 조건식의 범위가 좋은 조건식부터 판별해야함
		if(num > 10) {
			System.out.println("10보다 크다!");
		} else if(num > 5) {
			System.out.println("5보다 크다!"); // 6, 7, 8, 9 중 숫자
		}
		
	}

}
