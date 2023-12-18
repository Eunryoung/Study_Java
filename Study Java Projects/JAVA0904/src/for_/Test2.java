package for_;

public class Test2 {

	public static void main(String[] args) {
		// 정수 1 ~ 100까지의 합을 누적변수 total에 누적 후 출력
		// 누적변수 선언 및 초기화
		int total = 0;
		
		// for문
		for(int i = 1; i <= 100; i++) {
			// total 에 i 값을 누적
			total += i;
			System.out.println("i = " + i + ", total = " + total);
		}
		
		// 누적변수 출력
		System.out.println("1에서 100까지의 합 : " + total);
		
		System.out.println("====================================================");
		
		// 1 ~ 10까지 1씩 증가하면서, 정수 중 짝수의 합만 계산
		
		// 누적 변수 선언 및 초기화
		int total2 = 0;
		
		// for문
		// hint) for문 내에서 짝수 인지 판별해서 짝수면 누적
		for(int i2 = 1; i2 <= 10; i2++) {
			if(i2 % 2 == 0) { // 짝수를 판별
				// 짝수일 때 누적 수행
				total2 += i2; // total2 = total2 + i2;
				System.out.println("i2 = " + i2 + ", total2 = " + total2);
			} else { // 짝수가 아닐 때(= 홀수일 때)
				System.out.println(i2 + " : 홀수이므로 누적 X");
			}
						
		}
		
		// 1 ~ 10까지 정수 중 짝수의 합 출력
		System.out.println("1 ~ 10까지 정수 중 짝수의 합 : " + total2);
		
		System.out.println("==============================================");
		
		// 1 ~ 10까지 정수 중 홀수의 합 계산 후 출력
		int total3 = 0; // 누적 변수 선언 및 초기화
		
		for(int i3 = 1; i3 <= 10; i3++) { // 1 ~ 10까지 1씩 증가하면서 반복
			// 홀수일 경우에만 누적변수에 현재 값(i) 를 누적
			if(i3 % 2 == 1) { // 홀수 판별
				// 홀수일 때 누적 수행
				total3 += i3;
				System.out.println("i3 = " + i3 + ", total3 = " + total3);
			} else { // 홀수가 아닐 때 즉, 짝수일 때
				System.out.println(i3 + " : 짝수이므로 누적X");
			}
		}
		
		System.out.println("1 ~ 10까지 정수 중 홀수의 합 : " + total3);
		
	}

}
