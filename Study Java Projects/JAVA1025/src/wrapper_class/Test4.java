package wrapper_class;

public class Test4 {

	public static void main(String[] args) {
		/*
		 * char 타입 배열(chArr) 에 'A', 'b', '5', '공백', '#' 문자 5개를 저장
		 * => 반복문을 활용하여 각각의 문자에 대한 판별을 수행하여 결과 출력
		 *    (대문자, 소문자, 숫자, 기타문자)
		 * => Wrapper 클래스의 메서드(isXXX() 메서드) 활용
		 */
		
		char[] chArr = {'A', 'b', '5', ' ', '#'};
		
		for(char ch : chArr) {
			if(Character.isUpperCase(ch)) {
				System.out.println(ch + " : 대문자!");
			} else if(Character.isLowerCase(ch)) {
				System.out.println(ch + " : 소문자!");
			} else if(Character.isDigit(ch)) {
				System.out.println(ch + " : 숫자!");
			} else {
				System.out.println(ch + " : 기타문자!");
			}
		}
		
		
	}

}
