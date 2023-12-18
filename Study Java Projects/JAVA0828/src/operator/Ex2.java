package operator;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 산술 연산 시 자동 형변환
		 * - 연산 수행 시 피연산자(항) 끼리의 데이터타입을 일치시킨 후 연산을 수행
		 * - 규칙1) int 타입보다 작은 타입(byte, short, char) 끼리의 연산은
		 *          모두 int 타입으로 (자동) 변환 후 연산을 수행
		 *          => 즉, 결과값이 무조건 int 타입이 됨
		 *          ex) byte + byte = (int)byte + (int)byte = int + int = int
		 *          ex2) char + int = (int)char + int = int + int = int
		 * 
		 * - 규칙2) int 타입보다 큰 타입과의 연산 시 큰 타입으로 변환 후 수행
		 *          => 즉, 결과값이 무조건 큰 타입이 됨
		 *          ex) int + long = (long)int + long = long + long = long
		 *          ex2) long + float = (float)long + float = float + float = float
		 *
		 */		

		byte b1 = 10;
		byte b2 = 20;
		byte b3;
		
		// b1과 b2의 연산결과를 byte 타입 변수 b3에 저장할 때 문제가 발생함
//		b3 = b1 + b2; // 오류 발생! Type mismatch: cannot convert from int to byte
		// b1과 b2의 연산결과를 int로 인식하기때문(연산시에만 int타입으로 인식)
		// => (int)b1 + (int)b2 -> int + int -> int
		// => 저장하려는 변수 데이터타입이 byte라서 문제가 발생함
		// => int 타입을 byte 타입으로 저장하려면 강제 형변환(byte)이 필요
		
//		b3 = (byte)b1 + (byte)b2; // 오류 발생
		// => 다시 각각 int 타입으로 변환 됨
		// => (int)(byte)b1 + (int)(byte)b2 = int + int = int
		
		// 연산 결과에 형변환 연산자를 적용하여 byte 타입으로 변환해야 한다!
		b3 = (byte)(b1 + b2);
		// => (int)b1 + (int)b2 -> (int)(b1+b2) -> (byte)( (int)(b1+b2) ) -> byte
		
		System.out.println(b3);
		
		System.out.println("----------------------");
		
//		short s = b1 + b2; // 오류 발생! byte + byte -> int + int -> int 이므로
		// short 타입 변수 s에 저장(자동 형변환) 불가!
		short s = (short)(b1 + b2);
		System.out.println(s);
		
		System.out.println("----------------------");

		char ch = 'A';
		
		// char 타입 변수 ch2에 ch 값에 2를 더한 결과를 저장
//		char ch2 = ch + 2; // 오류발생! char + int -> (int)char + int -> int
		// => 결과값이 int가 되어 char 타입 변수에 저장 불가!
		
		char ch2 = (char)(ch + 2); // 연산 결과를 char 타입으로 변환
		// => 'A' + 2 = 65 + 2 = 67 이므로 결과값을 다시 char 타입으로 변환하면
		// 	  67에 해당하는 문자 'C'(67을 char타입으로 변환한 데이터)가 저장됨
		System.out.println(ch2);
		
		System.out.println(ch + 2);
		// => ch = 'A' -> int(65), 65 + 2 = 67
		// => ch + 2의 결과값은 int형이므로 문자 'C' 대신 67 출력
		// => 이 결과값을 다시 char 타입으로 변환하면 문자 'C'가 출력됨
		
		System.out.println((char)(ch+2));
		
		System.out.println("----------------------------------");
		
		int i = 100;
		long l = 200L;
		
		// int형 변수 i2에 i + l 결과값을 저장
//		int i2 = i + l; // int + long = long 이므로 int 타입 변수에 저장 불가!
		
		int i2 = (int)(i + l); // int 타입으로 강제형변환
		System.out.println(i2);
		
		float f = 3.14f;
		// => float f = (float)3.14;
		long l2 = (long)(l + f); // long + float = float(정수 + 실수 = 실수) 이므로 long으로 변환
		System.out.println(l2);
		
		System.out.println("=======================================");
		
		System.out.println(3 / 2); // 결과값이 int로 나와서 1.5가 아닌 1만 나옴
		// 나눗셈 연산은 몫을 계산하여, int / int = int 가 되어
		// 3 / 2의 연산 결과는 정수 1이 출력됨
		// 만약, 3 / 2 결과를 1.5의 결과값으로 얻고 싶을 경우
		// 정수가 아닌 실수 형태의 나눗셈 연산으로 연산을 수행해야 함
		// 따라서, 최소한 피연산자 중 하나를 실수로 변환한 후 연산을 수행
		// => 규칙2에 의해서 int형 보다 큰 데이터 타입을 따라감
		
		System.out.println((double)3 / 2); // double / int = double
		
		System.out.println(3 / 2.0); // int / double = double
		// => 주로, 수치 데이터 .0을 붙여서 실수로 변환하고
		//    실수형 변수는 형변환 연산자로 변환을 한다.
		
		System.out.println("==============================================");
		
		// 실수끼리의 연산(float 과 double 간의 연산)
		float f1 = 0.1f;
		double d1 = 0.1;
		
		System.out.println(f1);
		System.out.println(d1);
		
		System.out.println(f1 + d1);// 결과값이 0.2가 나오지 않음
		// => float -> double로 변환하여 double + double = double이 된다
		//	  따라서, 0.1f + 0.1 = 0.1 + 0.1 = 0.2인데
		//	  근사치 표현에 의해 원하지 않는 결과가 나올 수 있다!
		// => double -> float 타입으로 강제 형변환 후 연산을 수행하거나
		//	  두 실수 모두 정수로 변환하여 연산 수행 후 다시 실수로 변환
		
		System.out.println(f1+(float)d1);
		
		System.out.println(((int)(f1 * 10) + (int)(d1 * 10)) / 10.0); 
		// 10으로 하면 정수 간의 연산이라 결과값 0 나오므로 10.0으로 고쳐줌
		
		System.out.println("====================================");
		
		
		// 리터럴(상수)끼리 연산 시에는 자동 형변환이 발생하지 않는다!
		byte b4 = 10 + 20; // c.f. 규칙1 예제 참고! 변수끼리는 오류 일어남
		// byte 타입 범위 내의 정수는 byte 타입 그대로 연산
		System.out.println(b4);
		
		//단, 리터럴끼리의 연산이라도 표현 가능 범위를 초과하면 오류 발생!
//		byte b5 = 10 + 200; // byte 타입 범위(-128 ~ 127)를 초과하면 int로 취급됨
		
		
	}

}
