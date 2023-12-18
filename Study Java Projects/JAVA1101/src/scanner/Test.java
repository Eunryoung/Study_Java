package scanner;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		/*
		 * Scanner 클래스를 활용하여
		 * 사용자의 이름(inputName)을 입력받고 "OOO 님 환영합니다!" 를 출력
		 * (사용자의 이름을 입력하지 않고 엔터키를 입력하면 "이름을 입력해주세요!"를 출력)
		 * 
		 */
		// 쌤 코드
		Scanner scan = new Scanner(System.in);
		String inputName;
		
		System.out.println("사용자의 이름을 입력하세요 : ");
		inputName = scan.nextLine();
		
		if(!(inputName.equals(""))) {
			System.out.println(inputName + " 님 환영합니다!");
		} else {
			System.out.println("이름을 입력해주세요!");
		}
		
		// 내 코드 
//		do {
//			System.out.println("사용자의 이름을 입력하세요 : ");
//			inputName = scan.nextLine();
//			System.out.println(inputName + "님 환영합니다!");
//		} while(!inputName.equals(""));
//		System.out.println("이름을 입력해주세요!");
		// => 단, 공백 입력 시에도 " 님 환영합니다!" 문자열도 같이 출력됨ㅠㅠ
	}

}
