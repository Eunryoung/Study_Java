package interface_;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * 인터페이스의 필요성
		 * 1. 구현의 강제로 코드의 통일성 향상(= 표준화)
		 * 2. 인터페이스를 통한 간접적인 클래스 사용으로 모듈 교체가 용이
		 *    => 특정 클래스를 직접 다루는 대신
		 *       부모 인터페이스 타입으로 클래스를 다루게 되면
		 *       실제 인스턴스가 바뀌더라도 기존 코드를 수정할 필요가 없어짐
		 * 3. 서로 상속 관계가 없는 클래스간의 인터페이스를 통한 상속 관계 부여
		 *    => 다형성 확장
		 * 4. 모듈간 독립적 프로그래밍으로 인한 개발 기간 단축
		 */
		
	// 3. 서로 상속 관계가 없는 클래스 간에 인터페이스를 통한 상속 관계 부여
	
//	noRelationShip(); 
	// => 자신의 클래스 내부에서 정의한 메서드이지만
	// => static 키워드로 명시된 메서드가 아니므로 호출 불가
	Ex4 ex = new Ex4(); // 본인 클래스의 인스턴스를 생성한 다음
	ex.noRelationShip(); // 참조변수를 통해 호출할 수 있다!
	// => 또는, 메서드 정의 시 static을 명시한다면 인스턴스 생성없이도 호출 가능!	
	
	System.out.println("--------------------------------------");
	
	ex.hasRelationShip();
		
	} // main() 메서드 끝
	
	// Ex4 클래스 내에서 새로운 메서드 생성
	public void noRelationShip() {
//		NoteBookPc notebook = new NoteBookPc();
//		notebook.charge();
//		SmartPhone smartPhone = new SmartPhone();
//		smartPhone.charge();
		
		// 두 개의 인스턴스를 하나의 배열로 관리해야할 경우
		// NoteBookPc와 SmartPhone의 공통 타입은 Object 타입 밖에 없음
		Object[] objArr = { new NoteBookPc(), new SmartPhone() };
		
		// 반복문을 사용하여 배열 크기만큼 반복
		for(int i = 0; i < objArr.length; i++) {
//			objArr[i].charge();
			// => 참조 영역 축소로 인해 Object 타입으로 charge() 메서드 호출 불가!
			
			// instanceof 연산자를 사용하여 NoteBookPc와 SmartPhone 타입 판별
			// => 다운캐스팅을 통해 각 인스턴스를 따로 접근해야 함
			if(objArr[i] instanceof NoteBookPc) { 
				// => Object -> NoteBookPc 타입으로 다운캐스팅 가능 여부 판별
				// => 다운캐스팅 후 charge() 호출
				NoteBookPc notebook = (NoteBookPc)objArr[i]; // 강제 형변환
				notebook.charge(); // 노트북의 충전기를 통해 충전
			} else if (objArr[i] instanceof SmartPhone) { 
				// => Object -> SmartPhone 타입으로 다운캐스팅 가능 여부 판별
				// => 다운캐스팅 후 charge() 호출
				SmartPhone smartPhone = (SmartPhone)objArr[i]; // 강제 형변환
				smartPhone.charge(); // 스마트폰의 충전기를 통해 충전
			}
		}
				
	} // noRelationShip() 메서드 끝
	
	// Ex4 클래스 내에서 새로운 메서드 생성
	public void hasRelationShip() {
		// 인터페이스를 사용하여 공통된 멤버를 갖는 상속 관계를 부여할 경우
		// 해당 인터페이스 타입으로 다운캐스팅 할 필요 없이
		// 업캐스팅 된 상태 그대로 멤버에 접근 가능
		// => 다형성으로 인한 코드 절약
		Chargeable c = new NoteBookPc2(); // NoteBookPc2 -> Chargeable로 업캐스팅
		Chargeable c2 = new SmartPhone2(); // SmartPhone2 -> Chargeable로 업캐스팅
		
		// Chargeable 타입 배열로 두 클래스 인스턴스 모두 관리 가능(업캐스팅)
		Chargeable[] chargeableArr = { new NoteBookPc2(), new SmartPhone2() };
		
		// 업캐스팅 후 공통 메서드 charge()를 호출 가능하므로
		// 별도의 다운캐스팅 없이 바로 charge() 메서드 접근 가능
		for(int i = 0; i < chargeableArr.length; i++) {
			chargeableArr[i].charge();
		}
		
	}

} // Ex4 클래스 끝


// Object 클래스 외에 공통 슈퍼클래스가 없는 NoteBookPc와 SmartPhone의
// 공통 인터페이스 Chargeable 인터페이스 정의
interface Chargeable {
	// 두 클래스 에서 공통으로 사용할 충전(charge()) 기능을 추상메서드로 정의
	public abstract void charge();
	
}

// 기존에 Pc 클래스를 상속받고 있는 상태에서
// 추가로 인터페이스를 구현해야 하는 경우 상속 코드 뒤에 구현 코드를 기술
// => implements Chargeable 코드 추가
// => 아무 관계도 없던 두 클래스에 동일한 부모 인터페이스가 추가되어
// 	  서로 상속 관계에 묶이게 됨
class NoteBookPc2 extends Pc implements Chargeable {
	
	// 상속받은 인터페이스의 추상메서드 오버라이딩
	@Override
	public void charge() {
		System.out.println("노트북 충전 중...");
	}
	
}

class SmartPhone2 extends HandPhone implements Chargeable {

	// 상속받은 인터페이스의 추상메서드 오버라이딩
	@Override
	public void charge() {
		System.out.println("스마트폰 충전 중...");
	}
	
}



// ===========================================================
class Pc {}

class NoteBookPc extends Pc {
	public void charge() {
		System.out.println("노트북 충전 중...");
	}
}

class HandPhone {}

class SmartPhone extends HandPhone {
	public void charge() {
		System.out.println("스마트폰 충전 중...");
	}
}