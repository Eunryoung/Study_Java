package super_;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * < 상속에서의 생성자 >
		 * - 생성자는 상속되지 않음
		 *   => 생성자 이름은 자신의 클래스 이름과 동일한데
		 *   	만약, 상속받을 경우 생성자 이름이 부모 클래스이므로
		 *   	생성자 작성 규칙에 위배됨
		 * - 서브클래스의 인스턴스를 생성할 때는 자동으로 슈퍼클래스의 인스턴스를 
		 *   먼저 생성한 후 서브클래스의 인스턴스가 생성됨
		 * 	 => 이 때, 서브클래스 생성자에서 슈퍼클래스 기본생성자를 자동 호출
		 *   => 만약, 슈퍼클래스에 파라미터 생성자만 존재할 경우
		 *   	서브클래스 생성자에서 컴파일 에러가 발생하게 된다!
		 *   
		 *   < 생성자 super() >
		 * - 슈퍼클래스의 생성자를 명시적으로 호출할 때 사용
		 * 	 => 생성자 this()와 사용 방법 및 목적은 동일함
		 * - 기본 문법 : super([데이터...]);
		 * - 목적1) 슈퍼클래스 생성자 중 특정 생성자를 명시적으로 호출할 경우
		 * 			e.g. 슈퍼클래스에 기본 생성자 없이 파라미터 생성자만 정의 시
		 * 				 서브클래스 생성자에서 슈퍼클래스 기본 생성자를 호출할 수 없어
		 *				 컴파일 에러가 발생하는데, 이 때 슈퍼클래스의 
		 *			 	 파라미터 생성자를 명시적으로 호출하기 위해 사용  
		 * 
		 * - 목적2) 슈퍼클래스의 생성자에 멤버변수 초기화 코드가 존재할 경우
		 * 			e.g. 서브클래스 생성자에서 슈퍼클래스의 멤버까지 초기화하면
		 * 				 초기화 코드의 중복이 발생하게 됨.
		 * 				 이 때, 슈퍼클래스의 멤버는 슈퍼클래스의 생성자에서,
		 * 				 서브클래스의 멤버는 서브클래스의 생성자에서 초기화하여
		 * 				 코드 중복을 제거하기 위해 사용		
		 * 	 
		 * - 주의! 생성자 super()는 반드시 생성자의 첫 문장에서 실행되어야 함!
		 * 	 => 따라서, 생성자 내에서 super()와 this() 동시 사용 불가!
		 */
		
		Student s = new Student();
		
		Student s2 = new Student("이순신", 44, false);
		
		
	} // main() 메서드 끝

} // Ex 클래스 끝

class Person { // = class Person extends Object
	String name;
	int age;
	
	// 파라미터 생성자 단축키 : Alt + Shift + S -> O
	// 파라미터 생성자를 만들었을 경우 기본 생성자는 자동으로 생성되지 않는다!
	public Person(String name, int age) {
		super();
		
		// 슈퍼클래스 생성자에서 슈퍼클래스 멤버변수 초기화
		this.name = name;
		this.age = age;
	}
	
	// 슈퍼클래스에 파라미터 생성자만 존재해 오류 발생!
	// 슈퍼클래스에 기본 생성자를 별도로 정의해 오류 해결(1번 방법)
	public Person() {}
	
}

class Student extends Person {
	boolean isStudyMode;
	
	public Student() { // 기본생성자
		// 서브클래스의 기본 생성자에서 슈퍼클래스인 Person 클래스의 기본 생성자를 자동으로 호출
//		super(); // 암묵적으로 생성자내에 포함됨
		// 만약, 슈퍼클래스 생성자가 기본 생성자 Person() 없이 파라미터 생성자만 존재할 경우 오류 발생!
		// => Implicit super constructor Person() is undefined. Must explicitly invoke another constructor
		// => 파라미터 생성자를 만들었기 때문에 기본생성자가 자동으로 만들어지지않아 오류 발생!
		// < 해결 방법 >
		// (1번) 슈퍼클래스에 기본 생성자를 별도로 정의하거나
		// (2번) 서브클래스에서 슈퍼클래스의 파라미터 생성자를 명시적으로 호출
		
//		super("홍길동", 20); 
		// => 서브클래스에서 슈퍼클래스의 파라미터 생성자를 명시적으로 호출(2번 방법)
//		isStudyMode = true;
		
//		name = "홍길동";
//		age = 20;
//		isStudyMode = true;
		// 위처럼 직접 초기화하지 않고 this 생성자를 대신 호출
		this("홍길동", 20, true); 
		// => Student(String, int, boolean) 파라미터 생성자 호출하는 코드
		
		// 생성자 super()는 생성자 this()와 마찬가지로
		// 생성자 내에서 가장 먼저 실행되어야 한다!
//		super("홍길동", 20); 
		// => 부모클래스의 파라미터 생성자 호출 시 컴파일 에러 발생!
		// => Constructor call must be the first statement in a constructor
		// => 위에 this() 생성자가 있기 때문에 super() 생성자를 쓸 수가 없다!
		//	  (둘 다 가장 먼저 실행되어야 하므로 생성자 내에서 super() 와 this() 동시 사용 불가!)
	}

	public Student(String name, int age, boolean isStudyMode) { // 파라미터 생성자
		// Student 클래스 생성자에서 모든 멤버변수를 직접 초기화 할 경우
//		super(); 
		// => 여기서 부모클래스의 기본 생성자 호출하므로 위의 super("홍길동", 20) 호출할 필요x
//		this.name = name;
//		this.age = age;
//		this.isStudyMode = isStudyMode;
		
		// name과 age 멤버변수 초기화하는 코드는
		// 슈퍼클래스인 Person 클래스의 생성자의 초기화 코드와 중복됨
		// 따라서, 슈퍼클래스로부터 상속받은 멤버변수의 초기화는
		// 슈퍼클래스 생성자에서 수행하고, 서브클래스의 멤버만 초기화를 직접 수행
		// => 이 때, 슈퍼클래스의 파라미터 생성자를 호출하여 대신 초기화를 수행
		super(name, age); // 슈퍼클래스 생성자에 name, age의 데이터 값을 전달하여 대신 초기화
		this.isStudyMode = isStudyMode; // 자신의 멤버변수만 직접 초기화
	}
	
	
}