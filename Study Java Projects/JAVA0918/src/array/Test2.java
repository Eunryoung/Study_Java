package array;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * 배열의 최대값을 구하는 코드
		 * numbers = {3, 2, 14, 21, 100, 4, 2, 1}
		 * int max; int min; int sum; int avg;
		 * 
		 * 출력 결과
		 * 
		 * 최대값 : 100
		 * 최소값 : 1
		 * 합계 : 
		 * 평균 :
		 */
		
		// 배열 선언, 생성, 초기화
		int[] numbers = {3, 2, 14, 21, 100, 4, 2, 1};
		
		// 변수 선언 및 초기화
		int max = numbers[0];
		int min = numbers[0];
		int sum = 0;
		double avg;
		
		// 반복문(for문)을 통해 비교 및 대입
		for(int i = 0; i < numbers.length; i++) {
//			System.out.println(numbers[i] + " ");
			
			// 최대값
			if(max < numbers[i]) {
				max = numbers[i];
			}
			
			// 최소값
			if(min > numbers[i]) {
				min = numbers[i];
			}
			
			// 합계
			sum += numbers[i];
			
		} // for 반복문 끝
		
		// 평균
		avg = ((double)sum / numbers.length);
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		
		
		/* 내 코드
		for(int i = 0 ; i < numbers.length; i++) {
			if(numbers[i] < numbers[i+1]) {
				numbers[i] = numbers[i+1];
				System.out.println("최대값 : " + numbers[i]);
			} else if (numbers[i] > numbers[i+1]) {
				numbers[i] = numbers[i+1];
				System.out.println("최소값 : " + numbers[i]);
			}
			sum += numbers[i];
			System.out.println("합계 : " + sum);
			
			avg = sum / numbers.length;
			System.out.println("평균 : " + avg);
			
		}
		*/
		
	}

}
