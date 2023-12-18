package operator;

public class Ex5 {

	public static void main(String[] args) {
		/*
		 * 비교 연산자(관계 연산자) (>, >=, <=, <, ==, !=)
		 * - 두 피연산자 간의 대소 관계 등을 비교하여 true 또는 false 값 리턴
		 * - 주의! 동등비교 연산자는 수학(=) 과는 달리 '==' 형태의 기호 사용
		 *   주의! >= 또는 <= 연산의 순서 변경 불가능! ( => (x), =< (x) )
		 * - 리턴되는 결과값을 바로 사용하거나 boolean 타입 변수에 저장 가능
		 * - 서로 다른 데이터타입끼리의 비교 시 산술연산과 마찬가지로
		 *   동일한 타입으로 일치시킨 후 비교 연산을 수행
		 */
		
		int a = 10, b = 5;
		
		System.out.println("a > b 인가? " + (a > b));
		System.out.println("a >= b 인가? " + (a >= b));
		System.out.println("a <= b 인가? " + (a <= b));
		System.out.println("a < b 인가? " + (a < b));
		System.out.println("a == b인가? " + (a == b));
		System.out.println("a != b인가? " + (a != b));
		
		boolean result = (a > b);
//		int result = a > b; // 결과값이 true 또는 false이므로 int형 변수에는 저장불가!
		// => a > b의 결과(true)를 boolean 타입 변수 result에 저장
		System.out.println(result);
		
		System.out.println("----------------------------------");
		
		// char 타입끼리 비교시 int 타입으로 변환 후 비교(유니코드 값 비교)
		System.out.println('A' > 'B'); // 65 > 66 비교 (false)
		System.out.println('A' == 65); // 65 == 65 비교 (true)
		

		// 주의! double 타입과 float 타입 비교 시
		System.out.println(0.1); // 0.1 출력
		System.out.println(0.1f); // 0.1 출력
		
		System.out.println(0.1 == 0.1f); // false, 같은 값이나 다른 값으로 취급됨
		
		// true 값을 얻으려면
		System.out.println((float)0.1 == 0.1f); // true
		
		// 다른 연산과 관계 연산자를 결함하여 연산 결과의 대소 관계 판별 가능
		System.out.println((a + b) > (a - b)); // true
		System.out.println(('A' > 'B') == ('A' == 65));
		// false == true -> false
		System.out.println(('A' > 'B') != ('A' == 65));
		// false != true -> true		
		System.out.println(('A' > 'B') == ('A' != 65));
		// false == false -> true
		
		
	}

}
