package collection_framework;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		/*
		 * Set 계열 객체를 활용하여 로또 번호 생성기 작성(정렬은 선택)
		 * 1. Set 타입 객체 myLotto 생성
		 * 2. 1 ~ 45 사이의 중복되지 않는 난수(로또번호) 6개를 Set 객체에 저장
		 * 	  => e.g. "나의 로또 번호 : 1 10 11 15 23 41 43" 출력
		 * ------------------------------------------------------------------------
		 * 3. 이번주 로또 1등 당첨 번호를 Set 객체 thisWeekLotto에 저장
		 * 	  => e.g. "이번주 1등 당첨번호 : 7 8 11 13 15 23" 출력
		 * 4. 기존의 myLotto에 저장된 번호와 1등 당첨번호를 비교하여
		 * 	  일치하는 번호 개수와 등수 출력
		 * 	  => e.g. 번호가 3개(11, 15, 23) 일치 시
		 * 			  "일치하는 번호 개수 : 3개(4등)"
		 * 	  => 6개 일치 : 1등, 5개 : 2등, 4개 : 3등, 3개 : 4등, 나머지 : 꽝
		 */
		
		// 1. Set 타입 객체 myLotto 생성
		Set<Integer> myLotto = new TreeSet<Integer>();
		
		// 2. 1 ~ 45 사이의 중복되지 않는 난수(로또번호) 6개를 Set 객체에 저장
		// => 1) for문 사용 시 중복을 허용하지 않으므로 중복이 발생하면
		//		 저장 없이 반복 횟수만 증가함
		//		 따라서, 중복이 발생했을 시 제어변수의 반복 횟수의 조정이 필요
		// => 2) while문 사용 시 Set 계열의 메서드를 사용하여 6개의 번호가
		//		 만들어지지 않으면 계속 반복하도록 설정
		// => 난수는 Random 클래스를 활용
		
		// Random 클래스의 메서드를 사용하기 위해 인스턴스 생성
		Random r = new Random();
		
//		for(int i = 1; i <= 6; i ++) {
//			int rNum = r.nextInt(45) + 1;
//			// => int rNum = (int)(Math.random() * 45 + 1); 와 동일
//			
//			if(myLotto.contains(rNum)) {
//				System.out.println("중복되는 번호 발생! - " + rNum);
//				// 중복 번호가 발생했으므로 카운팅을 하지 않도록 i 값을 1 감소 시키기
//				i--;
//			} else {
//				myLotto.add(rNum);
//			}
			
			// ------------------------------------------------------------------------
			
//			if(!(myLotto.add(rNum))) { // 저장하지 못한 경우 = 중복이 발생한 경우
//				System.out.println("중복되는 번호 발생! - " + rNum);
//				// 중복 번호가 발생했으므로 카운팅을 하지 않도록 i 값을 1 감소 시키기
//				i--;
//			} else {
//				myLotto.add(rNum);
//			}
//		}
			
//		for(; myLotto.size() < 6; ) {
//			myLotto.add(r.nextInt(45) + 1);
//		}
		
		while(myLotto.size() < 6) {
			myLotto.add(r.nextInt(45) + 1);
		}
		
		System.out.println("나의 로또 번호 : " + myLotto); 
		// => toString() 메서드가 오버라이딩 되어있어 참조변수만 출력해도 값이 나옴

		System.out.println("==========================================================================");
		
		// 3. 이번주 로또 1등 당첨 번호를 Set 객체 thisWeekLotto에 저장
		//    => "이번주 1등 당첨번호 : 7 8 11 13 15 23" 출력
		
		// Set 객체(thisWeekLotto) 생성
//		Set<Integer> thisWeekLotto = new TreeSet<Integer>();
//		thisWeekLotto.add(7);
//		thisWeekLotto.add(8);
//		thisWeekLotto.add(11);
//		thisWeekLotto.add(13);
//		thisWeekLotto.add(15);
//		thisWeekLotto.add(23);
		
		Set<Integer> thisWeekLotto = new TreeSet<Integer>(Arrays.asList(7, 8, 11, 13, 15, 23));
		
		
		System.out.println("이번주 로또 1등 번호 : " + thisWeekLotto);
		
		// 4. 기존의 myLotto에 저장된 번호와 1등 당첨 번호를 비교하여
		//	  일치하는 번호 개수와 등수 출력
		//	  => 번호가 3개(11, 15, 23) 일치 시
		// 		 "일치하는 번호 개수 : 3개(4등)"
		// 	  => 6개 일치 : 1등, 5개 : 2등, 4개 : 3등, 3개 : 4등, 나머지 : 꽝
		
		// 일치하는 당첨번호 개수를 카운트하기 위한 변수 선언 및 초기화
		int count = 0;
		
		// 당첨번호 비교(contains() 메서드 활용)
		// 1. 향상된 for문 사용
		for(int num : myLotto) { // 나의 로또 번호에서 번호 1개씩 꺼내기
			// 꺼낸 번호와 1등 당첨 번호를 비교
			if(thisWeekLotto.contains(num)) {
				// 카운팅 증가
				count++;
			}
		}
		
		// 2. Iterator(반복자) 사용 시
		Iterator<Integer> ite = myLotto.iterator();
		// => iterator() 메서드를 호출하여 Iterator 인터페이스를 구현한 객체를 얻음
		while(ite.hasNext()) { // 가져올 객체가 있으면 true, 없으면 false 리턴
			int num = ite.next(); 
			// => next() 메서드를 호출하여 객체를 하나 받아와 int 타입 변수에 저장
			
			// 꺼낸 번호와 1등 당첨 번호를 비교
			if(thisWeekLotto.contains(num)) {
				// 카운팅 증가
				count++;
			} 
		}
		
		System.out.println(count);
		
		// 결과는 switch ~ case 문 사용
		switch(count) {
			case 6 : System.out.println("1등"); break;
			case 5 : System.out.println("2등"); break;
			case 4 : System.out.println("3등"); break;
			case 3 : System.out.println("4등"); break;
			default : System.out.println("꽝!");
		}
	}
	
	

}
