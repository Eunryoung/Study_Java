package math_class;

public class Ex {

	public static void main(String[] args) {
		/*
		 * java.lang.Math 클래스
		 * - 수학적인 다양한 기능을 상수와 메서드로 제공
		 * - 모든 상수와 메서드는 클래스명만으로 접근 가능(static)
		 * 	 e.g. Math.PI, Math.random()
		 * 
		 */
		
		System.out.println("PI 값 : " + Math.PI);
		
		System.out.println("-----------------------------------");
		
		int num = -10;
		
		System.out.println("num의 절대값 : " + Math.abs(num));
		System.out.println("num과 20 중 큰 값 : " + Math.max(num, 20));
		System.out.println("num과 20 중 작은 값 : " + Math.min(num, 20));
		System.out.println("4의 제곱근 : " + Math.sqrt(4));
		System.out.println("16의 제곱근 : " + Math.sqrt(16));

		// ----------------------------------------------------------------------------
		
		double dNum = 3.141592;
		
		System.out.println(Math.ceil(dNum)); // 소수점 첫째자리 올림(반올림X)
		System.out.println(Math.floor(dNum)); // 소수점 첫째자리 버림
		System.out.println(Math.round(dNum)); // 소수점 첫째자리 반올림(c.f. 정수(int) 리턴!)
		
		/*
		 * round() 메서드는 항상 소수점 첫째자리에서 반올림 수행
		 * x 번째 자리 반올림을 수행하기 위해서는 반올림할 숫자를
		 * 소수점 첫째자리에 위치하도록 변형해야 한다!
		 * e.g. 3.141592 의 소수점 4번째 숫자(5)를 반올림 위치로 가져오려면
		 * 	    (해당 숫자를 소수점 첫째자리에 위치하게 하기 위해)
		 * 	    원래 숫자에 1000을 곱하거나 공식에 따른 계산 작업을 수행해야함
		 * 	    (해당 숫자에 10^(x - 1) 값을 곱함(x는 반올림할 자리에 위치))
		 *		=> 3.141592 * 1000 또는 3.141592 * (10^(4-1))
		 *		   주의! x승을 표시하여 계산하려면 Math.pow(10, x) 메서드 활용
		 */ 
		System.out.println(dNum * 1000); // 3141.592
//		System.out.println(dNum * (10^(4-1))); // 28.274328 => 이상한 값 나옴
		System.out.println(dNum * Math.pow(10, (4-1))); // 3141.592
	
		System.out.println(Math.round(dNum * 1000)); // 3142
		
		// 원래 숫자로 되돌리기 위해서는 곱한 값 만큼 다시 나눗셈 수행 필요
		System.out.println(Math.round(dNum * 1000) / 1000); // 3
		// => long 타입(round() 메서드의 리턴타입) 결과값을 int 타입 1000으로 나누면 결과값이 정수 이므로
		//	  반드시 둘 중 하나라도 double 타입 실수로 연산을 수행해야 함
		System.out.println(Math.round(dNum * 1000) / 1000.0); // 3.142 

		
		// ===============================================================================================
		// 참고! 특정 위치의 숫자까지만 남기고 나머지는 제거해야할 경우
		// e.g. 3.141592 의 소수점 넷째자리만 남길 경우 3.1415
		// 1) 원하는 자리의 숫자까지 정수자리에 위치하도록 곱함
		//	  3.141592 -> 31415.92
		System.out.println(dNum * 10000);
		
		// 2) 소수 부분의 숫자를 제거하기 위해 정수화 수행
		//	  31425.92 -> 31415
		System.out.println((int)(dNum * 10000)); // 형변환 연산자 int
		
		// 3) 다시 원래 숫자로 복원하기 위해 처음에 곱한 값으로 다시 나눔
		//	  => 주의! 소수점 표현을 위해 double 타입 실수로 나누어야 함!
		// 	  31415 -> 3.1415
		System.out.println((int)(dNum * 10000) / 10000.0); 
	}

}
