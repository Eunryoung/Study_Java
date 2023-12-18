package method_overriding;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 메서드 오버라이딩(Method Overriding) = 메서드 재정의
		 * - 슈퍼클래스로부터 상속받은 메서드를 서브클래스에서 재정의 하는 것
		 * - 기본 슈퍼클래스의 메서드와 동일하게 생긴 메서드를 정의하게 되므로
		 * 	 서브클래스에서는 더 이상 슈퍼클래스의 메서드가 보이지 않음
		 * 	 => 슈퍼클래스의 메서드를 덮어쓰기 때문에 자신의 메서드만 보이게 됨
		 * 		(= 슈퍼클래스의 메서드는 은닉됨)
		 * - 슈퍼클래스의 메서드에 새로운 기능을 추가하는 경우
		 * 	 기존에 상속된 메서드 내용을 변경하는 경우
		 * 
		 * < 오버라이딩 규칙 >
		 * 1. 상속 관계 필수!
		 * 2. 메서드 시그니처(메서드명, 리턴타입, 파라미터)가 일치해야 함 
		 * 	  => c.f. 파라미터가 다를 시 오버로딩! 다 같으면 오버라이딩!
		 * 	  => 단, 리턴타입은 부모와 같거나 서브클래스 타입으로 변경 가능
		 * 3. 접근제한자는 같거나 넓은 범위로만 변경 가능(= 좁아질 수 없다!)
		 * (넓음) public > protected > default > private (좁음)
		 * 
		 * 
		 * < 오버라이딩 단축키 >
		 * Alt + Shift + S -> V
		 * => 단, 이미 오버라이딩 된 메서드는 표시되지 않음
		 */
		
		// Child 클래스의 인스턴스(c) 생성
		Child c = new Child(); // 기본생성자 호출
		c.childPrn(); // 서브클래스에서 직접 정의한 메서드
		// 슈퍼클래스로부터 상속받은 메서드
		c.parentPrn1(); 
		c.parentPrn2();
		c.parentPrn3();
		
		System.out.println("---------------------------------------------------");
		
		Animal ani = new Animal();
		ani.cry();
		
		Dog dog = new Dog();
		dog.cry();
		
		Cat cat = new Cat();
		cat.cry();
		
	} // main() 메서드 끝

} // Ex2 클래스 끝


class Parent {
	public void parentPrn1() {
		System.out.println("슈퍼클래스의 parentPrn1()");
	}
	
	public Object parentPrn2() {
		System.out.println("슈퍼클래스의 parentPrn2()");
		return null;
	}
	
	public String parentPrn3() {
		System.out.println("슈퍼클래스의 parentPrn3()");
		return null;
	}
}

class Child extends Parent {
	public void childPrn() {
		System.out.println("서브클래스의 childPrn()");
	}
	
	
	// 슈퍼클래스 Parent로부터 상속받은 parentPrn1() 메서드 오버라이딩
	// => 슈퍼클래스의 메서드명과 리턴타입, 파라미터가 동일한 메서드 재정의
	// => 슈퍼클래스가 가진 parentPrn1() 메서드는 Child 인스턴스에서 보이지않음!(은닉)
	public void parentPrn1() {
		System.out.println("서브클래스에서 오버라이딩된 parentPrn1()");
	}
	
	// 오버라이딩 시 슈퍼클래스의 접근제한자보다 좁아질 수 없다!
	// => 부모가 public일 경우 자식은 무조건 public만 지정 가능!
//	private void parentPrn1() { // 컴파일 에러 발생!
//		System.out.println("서브클래스에서 오버라이딩된 parentPrn1()");
//	}
	// => Cannot reduce the visibility of the inherited method from Parent
	
	// --------------------------------------------------------------
	// 오버라이딩 시 슈퍼클래스의 리턴타입과 같은 타입으로 명시할 수 있다!
//	public Object parentPrn2() {
//		System.out.println("서브클래스에서 오버라이딩된 parentPrn2()");
//		return null;
//	}
	
	// 오버라이딩 시 슈퍼클래스의 리턴타입보다 서브클래스 타입을 명시할 수 있다!
	public String parentPrn2() {
		System.out.println("서브클래스에서 오버라이딩된 parentPrn2()");
		return null;
	}


	
	// 오버라이딩 시 리턴타입은 기존 리턴타입의 슈퍼클래스 타입이 올 수 없다!
//	public Object parentPrn3() { // 컴파일 에러 발생!
//		System.out.println("서브클래스에서 오버라이딩된 parentPrn3()");
//		return null;
//	}
	// => The return type is incompatible with Parent.parentPrn3()
	
	// 오버라이딩 단축키 : Alt + Shift + S -> V
	@Override
	public String parentPrn3() {
		System.out.println("서브클래스에서 오버라이딩된 parentPrn3()");
		return null;
	}
	// 주의! @Override 어노테이션(Annotation)이 붙어있을 경우에는
	// 오버로딩을 수행하거나 오버라이딩 규칙 위반 시 컴파일 에러 발생!
	
//	@Override
//	public String parentPrn3(int a) {
//		System.out.println("서브클래스에서 오버라이딩된 parentPrn3()");
//		return null;
//	}
	// => 어노테이션 명시 시 오버로딩 수행 시 컴파일 에러 발생!
	// => 어노테이션 떼거나 주석처리할 경우 오버로딩 가능. 오류 X
	
//	@Override
//	public String parentPrn4() {
//		System.out.println("서브클래스에서 오버라이딩된 parentPrn3()");
//		return null;
//	}
	// => 어노테이션 명시 시 클래스명 변경 시 컴파일 에러 발생!
	// => 어노테이션 떼거나 주석처리할 경우 새로운 메서드 생성으로 여김. 오류 X
	
}

// 동물(Animal) 클래스 정의
class Animal {
	String name;
	int age;
	
	public void cry() {
		System.out.println("동물 울음 소리!");
	}
}

class Dog extends Animal {
	
	// 오버라이딩 단축키 : Alt + Shift + S -> V
	@Override
	public void cry() {
		System.out.println("멍멍!");
	}
	
}

class Cat extends Animal {
	
	// 오버라이딩 단축키 : Alt + Shift + S -> V
	@Override
	public void cry() {
		System.out.println("냐옹!");
	}
	
}