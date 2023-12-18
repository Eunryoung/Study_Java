package inheritance;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 상속(inheritance)
		 * - is-a 관계가 성립하는 객체간의 관계
		 * - 슈퍼클래스(부모)의 모든 멤버를 서브클래스(자식)에서 물려받아 선언 없이 사용하는 것
		 * - 슈퍼클래스(Super Class) = 부모클래스 = 상위클래스 = 조상클래스
		 *   서브클래스(Sub Class) = 자식클래스 = 하위클래스 = 자손클래스
		 * - private 접근제한자 지정된 멤버는 상속 대상에서 제외됨
		 * - 생성자는 상속 대상에서 제외됨
		 * 	 => 생성자의 이름은 자신의 클래스이어야만 함
		 * 	 	상속받은 생성자는 부모의 클래스 이름이므로 규칙에 위배되기 때문
		 * - 자바는 단일 상속만 지원
		 *   => 두 개 이상의 슈퍼클래스(부모)를 지정할 수 없음
		 * - 별도로 상속 대상을 지정하지 않을 경우(extends 생략할 경우)
		 *   java.lang.Object 클래스를 자동으로 상속 받음
		 *   => java.lang.Object 클래스를 자바의 최상위 클래스라고 함
		 *   
		 *   < 상속의 기본 문법 >
		 *   class 서브클래스명 extends 슈퍼클래스명 {}
		 */
		
		// 서브클래스 Child 인스턴스 생성
		Child c = new Child();
		c.childPrn(); // 서브클래스에서 직접 정의한 메서드
		
		// Child 클래스는 자신의 클래스 내의 멤버뿐만 아니라
		// 슈퍼클래스인 Parent 클래스의 멤버도 아무런 선언없이 사용 가능
		c.num = 10; // 슈퍼클래스 Parent로부터 상속받은 멤버변수
		c.parentPrn(); // 슈퍼클래스 Parent로부터 상속받은 메서드
		
		c.showNum();
		
		System.out.println("==========================================================");
		
		// 나 클래스 인스턴스 생성
		나 나 = new 나();
		
		// 나 클래스 자신의 멤버
		System.out.println("내 폰 : " + 나.폰);
		나.프로그래밍();
		
		// 아버지 클래스로부터 상속받은 멤버
		System.out.println("내 자동차 : " + 나.자동차);
		나.노래하기();
		
		// 할아버지 클래스로부터 상속받은 아버지 클래스로부터 상속받은 멤버
		System.out.println("내 집 : " + 나.집);
		나.그림그리기();
		
	} // main() 메서드 끝 
	
} // Ex 클래스 끝

// 슈퍼클래스에 해당하는 Parent 클래스 정의
class Parent { // (= class Parent extends Object)와 동일함 = Object 클래스를 상속받는 클래스
	int num; // 슈퍼클래스의 멤버변수
	
	public void parentPrn() {
		System.out.println("슈퍼클래스의 parentPrn()");
	}
	
}


// 슈퍼클래스인 Parent 클래스를 상속받는 서브클래스 Child 정의
// => Child 클래스 선언부에 extends 키워드를 쓰고 슈퍼클래스인 Parent 명시
class Child extends Parent {
	// Parent 클래스를 상속받게 되면
	// Child 클래스에서 선언하지 않은 멤버(=Parent의 멤버)도 사용 가능해짐
	public void childPrn() {
		System.out.println("서브클래스의 childPrn()");
	}
	
	public void showNum() {
		// 슈퍼클래스의 멤버변수 num에 접근 가능
		System.out.println("부모로부터 상속받은 멤버변수 num = " + num);
	}
	
}

// =======================================================================================
class 할아버지 {
	String 집 = "고층 아파트";
	String 티비 = "최신형 티비";
	
	public void 그림그리기() {
		System.out.println("그림을 잘 그린다!");
	}
}

// 할아버지 클래스를 상속받는 아버지 클래스 정의
// 멤버변수 : 자동차("스포츠카")
// 메서드 : 노래하기("노래를 잘 한다!" 출력)
class 아버지 extends 할아버지 {
	String 자동차 = "스포츠카";
	
	public void 노래하기() {
		System.out.println("노래를 잘 한다!");
	}
}

// 아버지 클래스를 상속 받는 나 클래스 정의
// 멤버변수, 메서드 하나씩 정의
class 나 extends 아버지 {
	String 폰 = "스마트폰";
	
	public void 프로그래밍() {
		System.out.println("프로그래밍을 잘 한다!");
	}
}