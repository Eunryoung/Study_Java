package polymorphism;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 동적 바인딩
		 * - 상속 관계에서 업캐스팅 후 메서드를 호출할 때
		 * 	 컴파일(번역) 단계에서의 실행 대상과, 실제 실행 단계에서의
		 * 	 실행 대상이 달라진 것
		 * - 참조 변수의 타입과 무관하게 실제 인스턴스의 메서드를 실행하게 됨
		 */
		
		// 슈퍼클래스 타입의 인스턴스 생성
		Parent p = new Parent();
		p.parentPrn();
		
		
		// 서브클래스 타입의 인스턴스 생성
		Child c = new Child();
		c.childPrn(); // 서브클래스에서 정의한 메서드
		c.parentPrn(); // 슈퍼클래스에서 상속받은 메서드(오버라이딩)
		
		System.out.println("----------------------------------------------------");
		
		// 서브클래스 타입 인스턴스 -> 슈퍼클래스 타입으로 업캐스팅
		p = c; // Child -> Parent
		// => Parent p = new Child();
		p.parentPrn(); // Child 인스턴스의 오버라이딩 된 메서드가 호출됨!
		// 메서드 호출 코드를 작성하는 시점(컴파일 시점)에서는
		// 참조변수 타입인 Parent 클래스의 parentPrn() 메서드를 호출하는 코드지만
		// 실제 실행하는 시점에서 참조변수에 저장한 인스턴스가 Child 인스턴스이므로
		// 실제 호출되는 메서드는 Child 타입의 오버라이딩 된 메서드가 호출됨!
		// => 즉, 컴파일 단계에서의 실행 대상과
		//	  실행 단계에서의 실행 대상이 다를 수 있다!
		
		System.out.println("===========================================================");
		
		자동차 car = new 자동차();
		car.drive();
		
		디젤차 dcar = new 디젤차();
		dcar.drive();
		
		전기차 ecar = new 전기차();
		ecar.drive();
		
		System.out.println("===========================================================");
		
		car = dcar; // 자동차 car = new 디젤차(); => 업캐스팅
		car.drive();
		
		car = ecar;
		car.drive();
		
	}

}

class Parent {
	public void parentPrn() {
		System.out.println("슈퍼클래스의 parentPrn()");
	}
}

class Child extends Parent {
	public void childPrn() {
		System.out.println("서브클래스의 childPrn()");
	}

	@Override
	public void parentPrn() { // 슈퍼클래스에서 상속받은 parentPrn() 메서드를 오버라이딩
		System.out.println("서브클래스에서 오버라이딩 된 parentPrn()");
	}
	
}

// =======================================================================

class 자동차 {
	public void drive() {
		System.out.println("자동차를 운전하다!");
	}
}


class 디젤차 extends 자동차 {
	@Override
	public void drive() { // 슈퍼클래스에서 상속받은 메서드 drive()를 오버라이딩
		System.out.println("디젤차를 운전하다!");
	}
}


class 전기차 extends 자동차 {
	@Override
	public void drive() { // 슈퍼클래스에서 상속받은 메서드 drive()를 오버라이딩
		System.out.println("전기차를 운전하다!");
	}
}

