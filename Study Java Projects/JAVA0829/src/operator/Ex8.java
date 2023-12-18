package operator;

public class Ex8 {

	public static void main(String[] args) {
		/*
		 * 삼항연산자(조건연산자)  ?:
		 * - 피연산자가 3개인 연산자
		 * - 조건식의 판별 결과가 true 일 때와 false 일 때
		 *   서로 다른 위치의 값(또는 식)을 선택하는 연산자
		 *   조건식은 결과가 true 또는 false 가 되는 식을 사용해야 함
		 *   
		 * < 기본 문법 >
		 * 조건식 ? 값1(true 일 때 선택) : 값2 (false 일 때 선택); 
		 */
		
		int num = 0;
		
		// num이 0 이상인지 판별하는 식
		System.out.println(num >= 0);
		System.out.println(num >= 0 ? "num은 양수!" : "num은 음수!");
		// num이 0 이상일 경우 true가 리턴되고 true에 해당하는 
		// "num은 양수!" 값을 선택하게 되어 출력문에 출력
		// System.out.println("num은 양수!"); 문장과 결과가 동일
		
		String result = num >= 0 ? "num은 양수!" : "num은 음수!";
		System.out.println(result);
		
		System.out.println("==================================");
		
		result = num > 0 ?  "num은 양수!" : num < 0 ? "num은 음수!" : "num은 0이다!" ;
		System.out.println(result);
		
	}

}
