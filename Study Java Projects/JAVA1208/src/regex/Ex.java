package regex;
import java.util.regex.Pattern;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 정규표현식을 활용하는 클래스
		 * 1. java.util.regex.Pattern 클래스
		 * - 정규표현식 문자열을 컴파일한 후 객체로 관리
		 * - 해당 객체를 활용하여 전체 문자열이 정규표현식과 일치하는지 판별 가능
		 *   e.g. 전화번호 형식 검증, 패스워드 길이 규칙 검증 등
		 *        => 단, 패스워드 복잡도 검사 등의 부분 규칙 검사 불가
		 * - 공개된 생성자가 없으며, Pattern 클래스의 static 메서드인
		 *   compile() 메서드를 통해 객체를 리턴받아 사용
		 * - Pattern 클래스의 static 메서드인 matches() 메서드를 사용하여
		 *   정규표현식과 일치하는지 판별 가능
		 */
		
		// ----------- Pattern 클래스 활용 -------------------------
		// 1. 한글 이름(2 ~ 5자) 검증
//		String name = "홍길동입니다";
		String name = "홍길동";
		String nameRegex = "^[가-힣]{2,5}$"; // 한글로 시작해 2~5자고 한글로 끝남
		
		if(Pattern.matches(nameRegex, name)) { // 앞부분에 식, 뒷부분에 검증할 이름
			System.out.println("올바른 한글 이름입니다!");
		} else {
			System.out.println("잘못된 한글 이름입니다!");
		} 

		// 2. 전화번호 검증
		// 2-1) 전화번호 검증에 사용할 정규표현식 작성
		String phoneRegex = "^(010|011)[-\\s]?\\d{3,4}[-\\s]?\\d{4}$"; 
		// => 자바 코드에서는 \를 \ 기호로 사용하기위해서는 \를 두 번 적어줘야한다
		/*
		 * ^(010|011) => 010 또는 011로 시작
		 * [-\\s]? => - 기호 또는 공백이 있을 수도 있고 없을 수도 있음
		 * \\d{3,4} => 숫자 3자리 ~ 4자리
		 * [-\\s]? => - 기호 또는 공백이 있을 수도 있고 없을 수도 있음
		 * \\d{4}$ => 숫잘 4자리로 끝
		 */
		
		String phone = "010-1234-5678";
//		String phone = "010-1234-56780";
		
		// 2-2) Pattern 클래스의 matches() 메서드를 사용하여 판별
		//	    파라미터 : 정규표현식 문자열, 검증할 원본 문자열
		//      리턴타입 : boolean
		//      => 해당 원본 문자열이 정규표현식에 부합하는지 여부 리턴
		boolean result = Pattern.matches(phoneRegex, phone); // 리턴타입이 boolean이므로 boolean 타입 변수에 저장 가능
		System.out.println(phone + " 검증 결과 : " + result);
		
		if(Pattern.matches(phoneRegex, phone)) {
			System.out.println(phone + " : 정상적인 번호 형식입니다!");
		} else {
			System.out.println(phone + " : 잘못된 번호 형식입니다!");
		}
		
		
		
	}

}
