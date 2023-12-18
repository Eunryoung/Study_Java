 package lambda;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		/*
		 * 문자열을 입력받아 두 문자열을 연결하여 출력하는 프로그램 정의
		 * 람다식을 사용하여 구현
		 * e.g. Hello 와 World 를 매개변수값으로 전달하면
		 *      "Hello,World" 가 출력
		 */
		
		// [ 쌤 코드 ]
		// 객체 지향 프로그래밍 방식
		Scanner scan = new Scanner(System.in);
		System.out.print("첫 번째 문자열을 입력하세요 : ");
		String s1 = scan.nextLine();
		
		System.out.print("두 번째 문자열을 입력하세요 : ");
		String s2 = scan.nextLine();
		
		StringConcatImpl concat1 = new StringConcatImpl();
		concat1.makeString(s1, s2);
		
		
		// 람다식으로 인터페이스 구현
		StringConcat concat2 = (s, v) ->  System.out.println(s + "," + v);
		concat2.makeString(s1, s2);
		
		
		
		// [ 내 코드 ]
//		PrintInterface print = new PrintClass();
//		print.print("Hello", "World");
//		
//		PrintInterface print2 = (a, b) -> { System.out.println(a + "," + b); };
//		print2.print("Hello", "World");
	}

}

// [ 쌤 코드 ]
@FunctionalInterface
interface StringConcat {
	public void makeString(String s1, String s2);
}

class StringConcatImpl implements StringConcat {
	@Override
	public void makeString(String s1, String s2) {
		System.out.println(s1 + "," + s2);		
	}
}


// [ 내 코드 ]
//@FunctionalInterface 
//interface PrintInterface {
//	void print(String a, String b);
//}
//
//class PrintClass implements PrintInterface {
//
//	@Override
//	public void print(String a, String b) {
//		System.out.println(a + "," + b);
//	}
//	
//}