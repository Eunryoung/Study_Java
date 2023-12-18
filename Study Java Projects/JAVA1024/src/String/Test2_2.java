package String;

import java.util.Arrays;

public class Test2_2 {

	public static void main(String[] args) {
		/*
		 * 문자열을 char[] 배열에 분리하여 저장 후
		 * 해당 문자열에 대한 간단한 암호화 작업
		 * - 문자열을 분리하여 저장한 배열을 encrypt() 에 전달
		 * - 전달받은 배열의 문자에 대해 아스키코드 값 3만큼 증가한 문자를
		 *   별도의 배열에 저장한 후 문자열로 변환하여 리턴
		 *   ex) 'A'(65) -> 'D'(68)
		 *   ex) "Hello" -> 'H', 'e', 'l', 'l', 'o' 형태로 배열에 저장됨
		 *       암호화 작업 결과물 : 'K', 'h', 'o', 'o', 'r'
		 *       리턴되는 데이터 : "Khoor"
		 */
		
		// String 타입 문자열을 char 타입 배열로 변환 : toCharArray() 사용
		String str = "admin123";
		char[] chArr = str.toCharArray();
		// => char[] chArr = {'a', 'd', 'm', 'i', 'n', '1', '2', '3'};
		
		// chArr 배열 요소 확인
		for(int i = 0; i < chArr.length; i++) {
			System.out.println(i + "번째 인덱스 : " + chArr[i]);
		}
		
		String encryptResult = encrypt(chArr);

		System.out.println("암호화 전 : " + Arrays.toString(chArr));
		System.out.println("암호화 후 : " + encryptResult);
		// => 암호화 후 : [d, g, p, l, q, 4, 5, 6]


	} // main() 메서드 끝

	/*
	 * encrypt() 메서드 정의
	 * => 인스턴스 생성없이 사용할 수 있도록 정의
	 * => 암호화 작업 수행
	 * => 전달받은 배열 내의 모든 문자 값을 +3 을 수행하여 새 배열에 저장한 후
	 *    문자열로 결합하여 리턴( = 리턴타입 String)
	 * => 전달받은 배열의 크기를 새 배열의 크기로 지정
	 *    (힌트 : new 키워드를 사용, 배열의 크기는 기존 배열의 개수(길이))
	 */
	
	public static String encrypt(char[] chArr) {
		char[] encryptedArr = new char[chArr.length];
		for(int i = 0; i < encryptedArr.length; i++) {
			// 각 배열의 문자에 +3 수행한 결과를 새 배열에 저장
			encryptedArr[i] = (char) (chArr[i] + 3); // 형변환 실행하고 반복
		}
		// => 암호화 후 배열 내의 모든 문자를 문자열로 결합하여 리턴
		// 	  => Arrays 클래스의 toString() 메서드 활용
		//	  ex) Arrays.toString(배열명);    
//		return Arrays.toString(encryptedArr);
		
		// 출력 형태를 문자열 형태로 출력하고 싶다면
		// 1. String 생성자 활용
//		String str = new String(encryptedArr);
//		return str;
		
		// 2. String.valueOf() 메서드 활용 
		//    => static 처리 되어있으므로 인스턴스 생성하지 않아도 사용 가능
//		String str = String.valueOf(encryptedArr);
//		return str;
	
		// 3. StringBuilder 활용
		StringBuilder buffer = new StringBuilder();
		for(char ch : encryptedArr) {
			buffer.append(ch);
		}
		
		String encryptedStr = buffer.toString();
		return encryptedStr;
	}
	
} // Test2_2 클래스 끝






