package final_test;

public class Test2 {

	public static void main(String[] args) {
		char ch = '@';
		if(ch >= 'A' && ch <= 'Z') {
			System.out.println("대문자!");
		} else if(ch >= 'a' && ch <= 'z') {
			System.out.println("소문자!");
		} else if(ch >= '0' && ch <= '9') {
			System.out.println("숫자!");
		} else {
			System.out.println("기타 문자!");
		}
	}

}
