package array;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * 거스름돈을 몇 개의 동전으로 지불할 수 있는지 계산하는 문제
		 * 변수 money의 금액을 동전으로 바꾸었을 때
		 * 각각 몇 개의 동전이 필요한지 계산해서 출력해보자.
		 * 단, 가능한 한 적은 수의 동전으로 거슬러 주어야 한다!
		 * (힌트) 나눗셈 연산자와 나머지 연산자를 사용
		 * 
		 * [ 출력 예시 ]
		 * money = 2680;
		 * 500원 = 5개
		 * 100원 = 1개
		 * 50원 = 1개
		 * 10원 = 3개
		 */
		
		// 배열 생성(동전의 액수)
		int[] coinUnit = {500, 100, 50, 10};
		
		// 거스름돈 변수(money) 선언 및 초기화 
		int money = 2680;
		
		System.out.println("money = " + money + "원");
		
		// for문을 통해 배열 접근
		for(int i = 0; i < coinUnit.length; i++) {
			// => 거스름돈(money)을 각 동전으로 나누었을 때 몫 = 필요 동전 개수
			//	  거스름돈(money)을 각 동전으로 나눈 나머지 = 남은 거스름돈
//			if( money % coinUnit[i] < coinUnit[i] ) { // if문 굳이 쓰지 않아도 값 나옴
				System.out.println(coinUnit[i] + "원 = " + money / coinUnit[i] + "개" );
//				System.out.println(money % coinUnit[i]);
				money %= coinUnit[i]; // money = money % coinUnit[i]
				System.out.println("남은 거스름돈 : " + money + "원");
//			} // if문 굳이 쓰지 않아도 값 나옴
		}
		
		
	}

}
