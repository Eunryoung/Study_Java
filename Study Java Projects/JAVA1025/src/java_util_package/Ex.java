package java_util_package;

import java.util.Random;

public class Ex {

	public static void main(String[] args) {
		/*
		 * java.util 패키지
		 * - 다양한 기능을 제공하는 유틸리티 클래스들의 모음
		 * - 난수 생성, 날짜 및 시각 관리, 자료 구조 등
		 * 
		 * Random 클래스
		 * - 난수 발생 기능 전용 클래스
		 * - static 메서드가 아닌 일반 메서드 형태로 제공하므로 인스턴스 생성 필수
		 * - 정수뿐만 아니라 다양한 타입의 난수 제공
		 *   => nextXXX() 메서드를 호출하여 각 기본 데이터타입 난수 발생
		 *   => 특히, nextInt() 메서드를 통해 정수화 과정 없이 정수형 난수 발생 
		 */
		
		// Random 클래스의 인스턴스 생성
		Random r = new Random();
		
		for(int i = 1; i <= 10; i++) {
			// nextInt() 메서드 : int형 범위(-21억 ~ 21억) 난수 발생
//			System.out.println("int형 범위의 난수 : " + r.nextInt());
			
			// nextDouble() 메서드 : double형 범위 난수 발생
			// => Math.random() 메서드와 동일한 결과
//			System.out.println("double형 범위의 난수 : " + r.nextDouble());
			
			// nextBoolean() 메서드 : true 또는 false 난수 발생
//			System.out.println("boolean형 범위의 난수 : " + r.nextBoolean());
			
			// nextInt(int) 메서드를 활용하여 원하는 범위의 난수 발생
			// => 파라미터로 최대값(x) 전달 시 : 0 ~ (x - 1) 범위의 난수 발생
//			System.out.println("0 ~ 9 사이의 난수 : " + r.nextInt(10));
			
			// 1 ~ 최대값(x) 사이의 난수 발생을 위해서는 nextInt(x) + 1 실행
			System.out.println("1 ~ 10 사이의 난수 : " + (r.nextInt(10) + 1));
			
			
		}
		
	}

}
