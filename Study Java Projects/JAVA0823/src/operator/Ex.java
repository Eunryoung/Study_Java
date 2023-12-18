package operator;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 산술연산자(+, -, *, /, %)
		 * - 일반적인 사칙연산과 동일
		 * - % 연산자 : 나머지 연산자(또는 퍼센트 연산자) 라고 하며,
		 *              나눗셈 결과에 대한 나머지를 계산하는 연산자
		 *              (/ 연산자는 나눗셈 결과에 대한 몫을 계산하는 연산자) 
		 */		
		
		// 출력문에 연산식을 기술하면 연산 결과를 출력
		System.out.println(10 + 2); // 10 + 2 결과인 12 출력됨
		System.out.println(10 - 2); // 10 - 2 결과인 8 출력됨
		System.out.println(10 * 2); // 10 * 2 결과인 20 출력됨
		System.out.println(10 / 2); // 10 / 2 결과인 5 출력됨 (몫)
		System.out.println(10 % 2); // 10 % 2 결과인 0 출력됨 (나머지)
		
		System.out.println("-------------------------------");
		
		// int형 변수 a에 10을 저장하고, b에 2를 저장
		int a = 10, b = 2; // 같은 데이터타입이라면 한 번에 선언 및 초기화 가능
		System.out.println(a + b); // a + b 결과인 12 출력됨
		System.out.println(a - b); // a - b 결과인 8 출력됨
		System.out.println(a * b); // a * b 결과인 20 출력됨
		System.out.println(a / b); // a / b 결과인 5 출력됨 (몫)
		System.out.println(a % b); // a % b 결과인 0 출력됨 (나머지)
		
		System.out.println("----------------------");
		
		// 연산 결과를 변수에 저장 후 출력
		int c; // 연산 결과를 저장할 변수 c 선언
		
		// a와 b의 덧셈 결과를 변수 c에 저장
		c = (a + b); 
		// => '=' : 대입연산자, '+' : 산술연산자
		// => 교재 87쪽. 연산자의 우선순위 참고 ('='이 제일 마지막)
		// => 소괄호 처리를 해주면 시각적으로 좋음!
		System.out.println(a + "+" + b + "=" + c ); // println은 + 기호로 문자열 결합!
		System.out.printf("%d + %d = %d\n", a, b, c);
		
		c = (a - b); // 뺄셈
		System.out.println(a + "-" + b + "=" + c );
		System.out.printf("%d - %d = %d\n", a, b, c);
		
		c = (a * b); // 곱셈
		System.out.println(a + "*" + b + "=" + c );
		System.out.printf("%d * %d = %d\n", a, b, c);
		
		c = (a / b); // 나눗셈(몫)
		System.out.println(a + "/" + b + "=" + c );
		System.out.printf("%d / %d = %d\n", a, b, c);
		
		c = (a % b); // 나눗셈(나머지)
		System.out.println(a + "%" + b + "=" + c );
//		System.out.printf("%d % %d = %d\n", a, b, c); // 오류 발생
		System.out.printf("%d %% %d = %d\n", a, b, c);
		// => 산술연산자로 %를 쓸 경우에는 %를 두 번 적어야 한다!
		
	}

}
