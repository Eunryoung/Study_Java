package method_overloading;

public class Test {

	public static void main(String[] args) {
		// PrintOverloading 클래스 인스턴스 생성
		PrintOverloading po = new PrintOverloading();
		
		// 객체의 print() 메서드를 호출하여 정수, 실수, 문자열 전달
		po.print(20);
		po.print();
		po.print(9.11);
		po.print();
		po.print("def");
		po.print();
		po.print(10, 3.14, "abc");
		
		
		System.out.println("===========================================================");
		
//		Calculator calc = new Calculator();
//		calc.add(1, 2);
//		calc.add(1, 2, 3);
//		calc.add(1, 2, 3, 4);
		
		System.out.println("----------------------------------------------------");
		
		Calculator c = new Calculator();
		c.cal('+', 10, 20);
		c.cal('+', 10, 20, 30);
		c.cal('+', 10, 20, 30, 40);
		
		c.cal('-', 100, 10);
		c.cal('-', 100, 10, 20);
		c.cal('-', 100, 10, 20, 30);
		
		c.cal('*', 10, 20);
		c.cal('/', 100, 10);
		c.cal('%', 105, 20);
	}
}
/*
 * 계산기(Calculator) 클래스 정의
 * - 정수를 전달받아 덧셈만 수행하는 add() 메서드 정의
 * 1. 정수 2개를 전달받아 덧셈 결과 출력
 * 2. 정수 3개를 전달받아 덧셈 결과 출력
 * 3. 정수 4개를 전달받아 덧셈 결과 출력
 */
class Calculator {
//	public void add(int num1, int num2) {
//		System.out.println("전달 받은 정수 2개의 합 : " + (num1 + num2));
//	}
//	
//	public void add(int num1, int num2, int num3) {
//		System.out.println("전달 받은 정수 3개의 합 : " + (num1 + num2 + num3));
//	}
//	public void add(int num1, int num2, int num3, int num4) {
//		System.out.println("전달 받은 정수 4개의 합 : " + (num1 + num2 + num3 + num4));
//	}
	
	/*
	 * 연산자에 해당하는 연산 수행하는 cal() 메서드 정의
	 * c.cal('+', 10, 20); // 10 + 20 = 30 출력
	 * c.cal('+', 10, 20, 30); // 10 + 20 + 30 = 60 출력
	 * c.cal('+', 10, 20, 30, 40); // 10 + 20 + 30 + 40 = 100 출력
	 * 
	 * c.cal('-', 100, 10); // 100 - 10 = 90 출력
	 * c.cal('-', 100, 10, 20); // 100 - 10 - 20 = 70 출력
	 * c.cal('-', 100, 10, 20, 30); // 100 - 10 - 20 - 30 = 40 출력
	 * 
	 */
	public void cal(char a, int b, int c) {
		if(a == '+') { // 덧셈일 경우
			System.out.println(b + " + " + c + " = " + (b + c));
		} else if(a == '-') { // 뺄셈일 경우
			System.out.println(b + " - " + c + " = " + (b - c));
		} else {
			System.out.println("덧셈, 뺄셈만 가능합니다.");
		}
	}
	
	public void cal(char a, int b, int c, int d) {
		if(a == '+') {
			System.out.println(b + " + " + c + " + " + d + " = " + (b + c + d));
		} else if(a == '-') {
			System.out.println(b + " - " + c + " - " + d + " = " + (b - c - d));
		} else {
			System.out.println("덧셈, 뺄셈만 가능합니다.");
		}
	}
	
	public void cal(char a, int b, int c, int d, int e) {
		if(a == '+') {
			System.out.println(b + " + " + c + " + " + d + " + " + e + " = " + (b + c + d + e));
		} else if(a == '-') {
			System.out.println(b + " - " + c + " - " + d + " - " + e + " = " + (b - c - d - e));
		} else {
			System.out.println("덧셈, 뺄셈만 가능합니다.");
		}
	}
}


// 정수, 실수, 문자열 데이터 1개를 전달받아 출력하는 print() 메서드 오버로딩
// 파라미터가 없는 print() 메서드까지 정의(-> 줄바꿈)
// 클래스명 : PrintOverloading
class PrintOverloading {
	public void print() { // 파라미터 없는 메서드도 오버로딩에 해당됨
		System.out.println();
	}
	
	public void print(int data) {
		System.out.println(data);
	}
	
	public void print(double data) {
		System.out.println(data);
	}
	
	public void print(String data) {
		System.out.println(data);
	}
	
	public void print(int a, double b, String c) {
		System.out.println("정수 : " + a + ", 실수 : " + b + ", 문자열 : " + c);
	}
}
