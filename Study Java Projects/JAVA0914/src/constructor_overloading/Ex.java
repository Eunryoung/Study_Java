package constructor_overloading;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 생성자 오버로딩
		 * - 메서드 오버로딩과 동일
		 * - 생성자 호출 시 다양한 형태의 파라미터를 전달하여
		 * 	 객체를 다양하게 초기화하는 목적
		 * 
		 */
		
		Person p = new Person("한국", "홍길동", "0354547-216541");
		p.showPersonInfo();
		
		System.out.println("-----------------------------------------");
		
		// 문자열 2개만 전달할 경우 이름, 주민번호만 초기화하고
		// 국가는 "대한민국"으로 초기화하는 생성자 호출
		Person p2 = new Person("홍길동", "2346546-13245");
		p2.showPersonInfo();
		
		System.out.println("-----------------------------------------");
		
		// 파라미터 생성자를 하나라도 정의할 경우
		// 컴파일러에 의해 기본 생성자가 자동으로 생성되지 않는다!
		// 따라서, 기본 생성자를 호출해야 하는 경우 직접 기본 생성자를 정의!
		Person p3 = new Person();
		p3.showPersonInfo();
	}

}

class Person {
	String nation;
	String name;
	String jumin;
	
	// 기본 생성자 정의
	public Person() {
		System.out.println("Person() 생성자 호출됨!");
	}
	
	// 국가는 자동으로 "대한민국"으로 초기화하고
	// 파라미터 2개(name, jumin)를 전달받아 초기화하는 생성자 정의
	public Person(String newName, String newJumin) {
		System.out.println("Person(String, String) 생성자 호출됨!");
		nation = "대한민국";
		name = newName;
		jumin = newJumin;
	}
	
	// 파라미터 3개(nation, name, jumin)를 전달받아 초기화하는 생성자 정의
	public Person(String newNation, String newName, String newJumin) {
		System.out.println("Person(String, String, String) 생성자 호출됨!");
		nation = newNation;
		name = newName;
		jumin = newJumin;
	}
	
	// 국가명, 이름, 주민번호를 출력하는 showPersonInfo() 메서드 정의
	public void showPersonInfo() {
		System.out.println("국가 : " + nation);
		System.out.println("이름 : " + name);
		System.out.println("주민번호 : " + jumin);
	}
	
}