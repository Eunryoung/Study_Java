package anonymous;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 익명(anonymous) 객체
		 * - 클래스 이름이 없는 객체
		 * - 클래스 선언과 객체의 생성을 동시에 하기 때문에 단 한번 사용될 수 있고
		 *   오직 하나의 객체만을 생성할 수 있는 일회용 클래스
		 * - 이름이 없기 때문에 생성자도 가질 수 없다.
		 * - 익명 객체를 만들기 위해서는 어떤 클래스를 상속하거나 인터페이스를 구현해야 함
		 * - 부모클래스의 이름이나 구현하고자 하는 인터페이스의 이름을 사용해서 정의하므로
		 *   한번에 하나의 클래스로 상속받는 동시에 인터페이스를 구현함
		 * - 단 하나의 클래스를 상속받거나 단 하나의 인터페이스만 구현할 수 있음(하나 이상 상속/구현 X)
		 * 
		 * < 익명 객체 문법 >
		 * new 슈퍼클래스이름() {
		 * 		// 멤버 선언
		 * };
		 * 
		 * 또는 
		 * 
		 * new 구현인터페이스이름() {
		 * 		// 멤버 선언
		 * };
		 * 
		 */
		
		NormalParent np = new NormalChild(); // 업캐스팅
		np.wake(); // 오버라이딩 된 NormalChild의 wake() 메서드 호출
//		np.work(); // 참조영역의 축소로 인해 접근 불가
		
		System.out.println("-------------------------------------------------------");
		
		
		NormalInterface ni = new NormalChild2(); // 업캐스팅
		ni.run(); // 구현체 클래스(NormalChild2)의 오버라이딩 된 구현메서드 run() 호출
		
		System.out.println("-------------------------------------------------------");

		NormalParent np2 = new NormalChild3(); // 업캐스팅
		np2.wake(); 
//		np2.run(); // 참조영역의 축소로 인해 접근 불가
		// => 일반적인 경우 상속과 구현을 동시에 할 수 있으나
		//	  업캐스팅을 통해 접근하면 모든 메서드를 사용할 수는 없음
		// => 모든 메서드에 접근하기 위해서는 NormalChild3의 객체 생성이 필요!
		NormalChild3 nc3 = new NormalChild3();
		nc3.wake();
		nc3.run();
		
		System.out.println("==================================================");
		
		UseExtendsClass uec = new UseExtendsClass();
		uec.p.wake(); // 오버라이딩 된 NormalChild의 wake() 메서드 호출
		uec.method(); 
		
		System.out.println("==================================================");
		
		UseAnonyClass uac = new UseAnonyClass();
		uac.p.wake();
//		System.out.println(uac.p.childVar); // 접근 불가
//		uac.p.childMethod(); // 접근 불가

		System.out.println("==================================================");
		
		UseAnonyClass2 uac2 = new UseAnonyClass2();
		uac2.method();
		
		System.out.println("==================================================");
		
		UseAnonyClass3 uac3 = new UseAnonyClass3();
		uac3.method1(np); // np = new NormalChild();
		uac3.method2(); 
		uac3.method3(new NormalParent() {
					public void study() {
						System.out.println("공부합니다!");
					}

					@Override
					public void wake() {
						System.out.println("4시에 일어납니다!");
						study();
					}
		});
		// => 매개변수 값으로 익명 객체 대입
		
	} // main() 메서드 끝

} // Ex 클래스 끝


// ===============================================================================================================
// 익명 객체를 사용하지 않는 일반적인 상속 관계
class NormalParent {
	public void wake() {
		System.out.println("7시에 일어납니다!");
	}
}

// NormalParent 클래스를 상속받는 NormalChild 클래스 정의
class NormalChild extends NormalParent { // 서브클래스를 명시적 선언
	public void work() {
		System.out.println("출근합니다!");
	}

	@Override
	public void wake() {
		System.out.println("6시에 일어납니다!");
		work();
	}
}

// ===============================================================================================================
// 익명 객체를 사용하지 않은 인터페이스 구현 관계
interface NormalInterface {
	void run(); // public abstract 생략 된 추상메서드
}

// NormalInterface 를 구현하는 NormalChild2 클래스 정의
class NormalChild2 implements NormalInterface {

	@Override
	public void run() {
		System.out.println("출근 전 러닝을 합니다!");
	}
}

// ===============================================================================================================
// NormalParent 를 상속받는 동시에 NormalInterface 를 구현하는 NormalChild3 클래스 정의
class NormalChild3 extends NormalParent implements NormalInterface {
	public void work() {
		System.out.println("출근합니다!");
	}

	@Override
	public void run() {
		System.out.println("출근 전 러닝을 합니다!");
	}

	@Override
	public void wake() {
		System.out.println("5시에 일어납니다!");
		work();
	}
	
}

// ===============================================================================================================
// 상속 관계에 있는 서브클래스를 활용하는 클래스의 정의
class UseExtendsClass {
	NormalParent p = new NormalChild(); // 멤버변수에 서브클래스 객체를 대입
	public void method() {
		NormalParent localP = new NormalChild(); // 로컬변수에 서브클래스 객체를 대입
	}
	
}
// => 서브클래스(NormalChild)를 명시적으로 선언하여 이미 선언된 서브클래스로 간단히 객체를 생성하여 사용할 수 있음
// => 재사용성이 높음
// => 그러나, 서브클래스가 재사용되지 않고, 특정 위치에서 사용할 경우라면
//	  서브클래스를 명시적으로 선언하는 것은 귀찮은 작업이 되며
//	  이럴 경우 [ 익명 자식 객체 ]를 생성

/*
 * 익명 자식 객체 생성 방법
 * 부모클래스 [필드|변수] = new 부모클래스(매개값, ...) {
 * 		// 필드(멤버변수)
 * 		// 메서드
 * }; 
 */

// ===============================================================================================================
// 익명 객체를 사용한 클래스 정의
// (1. 멤버변수(p)를 선언할 때 초기값으로 익명 클래스 사용)
class UseAnonyClass { // 익명객체 형태가 클래스 내부에 존재하므로 extends나 implements 키워드 명시 할 필요 X
	NormalParent p = new NormalParent() {
		int childVar = 10;
		public void childMethod() {
			System.out.println("익명 객체에서 정의된 메서드!");
		}
		@Override
		public void wake() {
			System.out.println("부모클래스로부터 오버라이딩 된 메서드!");
		}
	};
	
	public void method() {
//		p.childVar = 20; // 접근 불가
//		p.childMethod(); // 접근 불가
		p.wake(); // 접근 가능
	
	}
	// => 익명 자식 객체에 새롭게 정의된 필드(멤버변수)와 메서드는
	//    익명 자식 객체 내부에서만 사용가능, 외부에서는 접근할 수 없음
	// => 익명 자식 객체는 부모 타입 변수에 대입되므로 부모 타입에 선언된 것만 사용할 수 있음!
	// => NormalParent p = new NormalParent() {};의 형태에서 new 키워드 이하는 new NormalChild(); 형태와 동일하다고 여긴다면
	//    업캐스팅으로 인한 참조영역의 축소로 접근이 불가능한 것으로 생각할 수 있다!
	
}
// ===============================================================================================================
// 익명 객체를 사용한 클래스의 정의
// (2. 멤버 메서드 내에서 로컬변수(localP)를 선언할 때 초기값으로 익명 클래스 사용)
class UseAnonyClass2 {
	public void method() {
		NormalParent localP = new NormalParent() {
			int childVar = 10;
			public void childMethod() {
				System.out.println("익명 객체에서 정의된 메서드!");
			}
			
			@Override
			public void wake() {
				System.out.println("로컬변수 localP에 선언된 익명 객체의 오버라이딩 된 wake() 메서드!");
			}
			
		};
		
		localP.wake(); 
		// => 로컬변수는 메서드가 종료되면 stack 메모리 영역에서 삭제
		// 	  따라서 익명 객체가 저장된 localP는 메서드가 종료되기 전에 메서드 블록 내에서 사용해야 함
		//    메서드가 호출되면 익명 객체가 만들어지고 메서드가 끝나고 나면 익명 구현객체가 사라지므로 
		//    로컬변수에 선언된 익명 객체의 메서드는 반드시 멤버 메서드 내에서 호출해야함

	} // method() 끝
}

// ===============================================================================================================
// 익명 객체를 사용한 클래스의 정의
// (3. 메서드의 매개변수가 부모타입일 경우 메서드를 호출하는 코드에서 익명 자식 객체를 생성해 매개값으로 대입)
class UseAnonyClass3 {
	public void method1(NormalParent parent) { }
	
	public void method2() {
		method1(new NormalParent() {
					int childVar;
					void childMethod() { }
					@Override
					public void wake() {
						System.out.println("매개변수로 사용된 익명객체의 오버라이딩 된 wake() 메서드");
					}
		});
	}
	
	public void method3(NormalParent parent) {
		parent.wake();
	}
}