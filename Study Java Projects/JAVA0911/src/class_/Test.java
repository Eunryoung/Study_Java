package class_;

public class Test {

	public static void main(String[] args) {
		// Person 클래스 인스턴스(p) 생성
		Person p = new Person();
		
		// 이름: 홍길동, 나이 : 20, 배고픔 : false 값 저장
		p.name = "홍길동";
		p.age = 20;
		p.isHungry = false;
		
//		System.out.println("이름 : " + p.name);
//		System.out.println("나이 : " + p.age);
//		System.out.println("배고픔 : " + p.isHungry);
		// => 이런 식으로 각자 명시하거나
		
		// 참조변수 p를 통해 멤버변수는 물론 메서드까지 접근 가능
		p.showPersonInfo();
		
		p.talk();
		p.eat("페퍼로니피자");
		
	} // main() 메서드 끝

} // Test 클래스 끝

/*
* Person 클래스 정의 
* [ 멤버변수(인스턴스 변수) 선언 ]
* - 이름(name, 문자열)
* - 나이(age, 정수)
* - 배고픔(isHungry, boolean) 
*
* [ 메서드 정의 ]
* - 이름, 나이, 배고픔을 출력하는 showPersonInfo() 메서드
*   (매개변수 없음, 리턴값 없음)
*   출력 형태
*   이름 : 홍길동
*   나이 : 20
*   배고픔 : true
*   
*   - 밥먹는 기능을 수행하는 eat() 메서드
*     (매개변수 : 음식이름(foodName, 문자열), 리턴값 없음)
*     => "XXX 먹기!" 출력
*     => 멤버변수 isHungry의 값을 false로 변경
*     
* - 말하기 기능을 수행하는 talk() 메서드
*   (매개변수 없음, 리턴값 없음)
*   => "말하기!" 출력
*   => 멤버변수 isHungry의 값을 true로 변경    
*/

class Person { // Test 클래스 안에 만드니까 public 명시할 필요 X
	// 멤버변수(인스턴스 변수) 선언
	String name;
	int age;
	boolean isHungry; // true : 배고픔, false : 배고프지 않음
	
	public void showPersonInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("배고픔 : " + isHungry);
	}
	
	public void eat(String foodName) {
		System.out.println(foodName + " 먹기!");
		// isHungry 변수의 값을 false로 변경(배고프지 않음)
		isHungry = false;
		System.out.println("식사 후 배고픔 : " + isHungry);
	}
	
	public void talk() {
		System.out.println("말하기!");
		// isHungry 변수의 값을 true 로 변경(배고픔)
		isHungry = true;
		System.out.println("말한 후 배고픔 : " + isHungry);
	}
	
//	< 내 코드 > (오답 => showPersonInfo()메서드를 클래스 정의할 때 넣지않음)
	// => eat(), talk() 메서드와 마찬가지로 showPersonInfo() 메서드도 Person 클래스 정의 시 들어감!
//	public void eat(String foodName) {
//		System.out.println(foodName + "먹기!");
//		isHungry = false;
//		System.out.println("배고픔 : " + isHungry);
//	}
//	
//	public void talk() {
//		System.out.println("말하기!");
//		isHungry = true;
//		System.out.println("배고픔 : " + isHungry);
//	}
}

