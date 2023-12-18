package String;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * String 클래스 메서드 연습
		 * ---------------------------------------------------
		 * 1. 주민번호(jumin)을 입력받아 성별(남 또는 여) 및 외국인 판별
		 * - 입력형식 : "XXXXXX-XXXXXXX"
		 * - 판별조건
		 * 	 1) 뒷자리 첫번째 숫자(문자데이터)가 1 또는 3 : "남성" 출력
		 * 	 2) 뒷자리 첫번째 숫자(문자데이터)가 2 또는 4 : "여성" 출력
		 * 	 3) 뒷자리 첫번째 숫자(문자데이터)가 5 또는 6 : "외국인" 출력
		 */
		
		String jumin = "991111-1647862";
		
		// 주민등록번호 뒷자리 첫번째 숫자 추출 => 문자로 저장
		char id = jumin.charAt(7);
		
		// if문 사용
		if(id == '1' || id == '3') {
			System.out.println(jumin + " : 남성!");
		} else if(id == '2' || id == '4') {
			System.out.println(jumin + " : 여성!");
		} else if(id == '5' || id == '6') {
			System.out.println(jumin + " : 외국인!");
		} else {
			System.out.println(jumin + " : 잘못된 주민번호!");
		}
		
		
		// switch-case 문
		switch(id) {
			case '1' :
			case '3' : System.out.println(jumin + " : 남성!"); break; 
			case '2' :
			case '4' : System.out.println(jumin + " : 여성!"); break; 
			case '5' :
			case '6' : System.out.println(jumin + " : 외국인!"); break;
			default : System.out.println(jumin + " : 잘못된 주민번호!");
		}
		
	} 
	
} 
