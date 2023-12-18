package variable_arguments;

public class Test {

	public static void main(String[] args) {
		// VariableArgumentsTest 인스턴스(vat) 생성
		VariableArgumentsTest vat = new VariableArgumentsTest();
		vat.print();
		vat.print(1);
		vat.print(1, 2);
		vat.print(1, 2, 3);
		vat.print(1, 2, 3, 5654);
		vat.print(1, 2, 3, 5654, 546);
		vat.print(1, 2, 3, 5654, 546, 555, 584, 3212, 567);
				
	}
}

/*
 * 클래스명 : VariableArgumentsTest
 * 정수를 0개 ~ 무한대로 전달받아 출력하는 print() 메서드 오버로딩
 * 단, 정수를 0개 전달할 경우 "전달받은 정수 없음!" 출력하고
 * 1개 이상을 전달할 경우 전달받은 정수를 출력
 */

class VariableArgumentsTest {
	public void print(int... nums) {
		if(nums.length == 0) { // 전달받은 배열 크기가 0개일 경우
			System.out.println("전달받은 정수 없음!");
		} else {
			for(int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println(); // 줄바꿈
		}
	}
}

