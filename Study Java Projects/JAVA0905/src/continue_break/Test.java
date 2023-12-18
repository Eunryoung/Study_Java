package continue_break;

public class Test {

	public static void main(String[] args) {
		/*
		 * 1 ~ 100 까지 정수의 합을 계산(total 변수에 저장)
		 * => 단, 합계가 1000 보다 클 경우 반복문을 종료하고 빠져나간 뒤
		 *    1000 보다 커지는 시점의 정수(x)를 출력
		 */
		
		// 변수 선언 및 초기화
		int total = 0;
		int x;
		
		// 반복문
		for(x = 1; x <= 100; x++) {
			total += x;
			
			if(total > 1000) {
				break; // 합계(total) 가 1000 보다 클 때 for문 종료
			}
		}
		
		// total 과 x 값 출력
		System.out.println("1 ~ " + x +"까지 정수의 합 = " + total);
		System.out.println("1000보다 커지는 시점의 정수 : " + x);
		
		System.out.println("===============================================================");
		
		/*
		 * 1 + (-2) + 3 + (-4) + 5 + (-6) + ... 생략 ...
		 * 형식으로 계속 더 할 때 총합이 100 이상이 되는 x 값을 출력(break문 사용)
		 * <힌트> 정수가 짝수일 때는 음수 형태로 변환하여 합계 누적
		 * <힌트> while 조건식이 true 일 때 무한 반복 ( while(true) ) 
		 */
		
// 내코드
//		total = 0;
//		x = 1;
//		
//		while() {
//			total += x;
//			if(x % 2 == 0) {
//				x = -x;
//			}
//			System.out.println(x + " + ");
//			x++;
//			if(total >= 100) {
//				break;
//			}
//			
//		}
		
		// while문 사용
//		x = 1;
//		total = 0;
//		
//		while(total < 100) { // 합계가 100보다 작을 동안 반복(= 100 이상 종료)
//			
//			x++;
//			if(x % 2 == 0) { // 짝수일 때
//				System.out.println(-x);
//				total = total + -x; // 음수값으로 변환하여 누적
//			} else { // 홀수일 때
//				System.out.println(x);
//				total += x; // 양수값 그대로 누적
//			}
//		}
	
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		// break 문을 사용한 while 문
		x = 1;
		total = 0;
//		
//		while(true) { // while 조건문에 true 주면 계속 반복
//			if(x % 2 == 0) { // 짝수일 때
//				System.out.println(-x);
//				total = total + -x; // 짝수를 음수값으로 변환하여 누적
//			} else { // 홀수일 때
//				System.out.println(x);
//				total += x; // 양수값 그대로 누적
//			}
//			
//			if(total >= 100) {
//				break;
//			}
		
//			x++;
//		}
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		// 초기식을 생략한 형태의 for문
//		for(; total < 100; x++) { 
		// => for문 밖에서 초기식의 변수를 선언해놨다면(= 제어변수 x에 초기값을 이미 줬다면) 초기식 생략 가능
//			if(x % 2 == 0) { // 짝수일 때
//				System.out.println(-x);
//				total = total + -x; // 짝수를 음수값으로 변환하여 누적
//			} else { // 홀수일 때
//				System.out.println(x);
//				total += x; // 양수값 그대로 누적
//			}
//			
//			if(total >= 100) {
//				break;
//			}
//		}
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		// 조건식을 생략한 형태의 for문
//		for(x = 1; ; x++) { 
		// => 조건식을 생략한 경우 조건식의 값은 기본값 while(true)와 동일. 무조건 계속반복.
//			if(x % 2 == 0) { // 짝수일 때
//				System.out.println(-x);
//				total = total + -x; // 짝수를 음수값으로 변환하여 누적
//			} else { // 홀수일 때
//				System.out.println(x);
//				total += x; // 양수값 그대로 누적
//			}
//			
//			if(total >= 100) {
//				break;
//			}
//		}
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		// 증감식을 생략한 형태의 for문
//		for(x = 1; total < 100; ) { // 증감식 생략됨
//			if(x % 2 == 0) { // 짝수일 때
//				System.out.println(-x);
//				total = total + -x; // 짝수를 음수값으로 변환하여 누적
//			} else { // 홀수일 때
//				System.out.println(x);
//				total += x; // 양수값 그대로 누적
//			}
//			
//			if(total >= 100) {
//				break;
//			}
//			x++; // for문 내에서 제어변수의 값을 증가할 경우 증감식 생략 가능!
//		}
		
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		// 모든 요소를 생략한 형태의 for문
		for( ; ; ) { // 무조건 무한 반복
			if(x % 2 == 0) { // 짝수일 때
				System.out.println(-x);
				total = total + -x; // 짝수를 음수값으로 변환하여 누적
			} else { // 홀수일 때
				System.out.println(x);
				total += x; // 양수값 그대로 누적
			}
			
			if(total >= 100) {
				break;
			}
			x++;
			// => for문 내에서 제어변수의 값을 증가할 경우 증감식 생략 가능!
			// => 증감식은 for문 벗어나기전 필수!(증감해야 반복하니까)
		}
		
		System.out.println();
		System.out.println("x = " + x);
		System.out.println("total = " + total);
		
	}

}
