package wrapper_class;

public class Test4_2 {

	public static void main(String[] args) {
		/*
		 * 문자열(패스워드)을 char[] 배열에 분리하여 저장 후
		 * 해당 패스워드에 대한 안전도 검사(패스워드 복잡도 검사)
		 * - 배열 내의 각 문자에 대해 다음 사항을 판별하여
		 *   해당 되는 항목이 있을 경우 점수를 증가시키고
		 *   해당 점수에 따라 안전도 레벨을 출력
		 *   1) 대문자가 포함될 경우 +1점
		 *   2) 소문자가 포함될 경우 +1점
		 *   3) 숫자가 포함될 경우 +1점
		 *   4) 특수문자 ! 가 포함될 경우 +1점
		 *   => 최대 점수4점, 최소 점수 1점이며 다음 결과 출력
		 *   1) 4점 : "패스워드 안전도 : 안전!" 출력
		 *   2) 3점 : "패스워드 안전도 : 보통!" 출력
		 *   3) 2점 : "패스워드 안전도 : 위험!" 출력
		 *   4) 1점 : "패스워드 안전도 : 사용 불가!" 출력
		 *   
		 *   ex) 'a', 'd', 'm', 'i', 'n', '1', '2', '3' 일 경우
		 *       소문자 포함(+1), 숫자 포함(+2) 이므로 총점 2점
		 *       "패스워드 안전도 : 위험!" 출력
		 */
		
		
		// String -> char[] 변환
		String password = "admin123";
		char[] chArr = password.toCharArray(); // toCharArray() : 문자열을 char[] 배열로 리턴
		// 안전도 점수를 저장할 변수 선언 및 초기화
		int point = 0;
		// 각 체크 항목별 포함 여부를 저장하는 변수 선언
		boolean isUpperCase = false; // 대문자 판별 결과
		boolean isLowerCase = false; // 소문자 판별 결과
		boolean isDigit = false; // 숫자 판별 결과 
		boolean isSpec = false; // 특수문자 판별 결과
		
		// 반복문을 사용하여 배열 반복(항목 포함 여부 체크)
		// => 각 항목 여부를 판별(Wrapper 클래스의 isXXX() 메서드 활용)
		// => 해당 항목이 포함되어 있을 경우 boolean 타입 변수 값을 true 로 변경
		for(int i = 0; i < chArr.length; i++) {
			if(Character.isUpperCase(chArr[i])) { // 대문자 판별
				isUpperCase = true;
			} else if(Character.isLowerCase(chArr[i])) { // 소문자 판별
				isLowerCase = true;
			} else if(Character.isDigit(chArr[i])) { // 숫자 판별
				isDigit = true;
			} else if(chArr[i] == '!') {
				isSpec = true;
			}
		}
		
		// 각 항목 포함 여부를 체크하여 포함되었을 경우 점수 1점 증가(if문 활용)
		if(isUpperCase) point++; 
		if(isLowerCase) point++; 
		if(isDigit) point++; 
		if(isSpec) point++; 
				
		// 점수에 따라 안전도 출력
		switch(point) {
			case 4 : System.out.println(password + " : 안전!"); break;
			case 3 : System.out.println(password + " : 보통!"); break;
			case 2 : System.out.println(password + " : 위험!"); break;
			default : System.out.println(password + " : 사용 불가능한 패스워드!");
		}
		
	}

}
