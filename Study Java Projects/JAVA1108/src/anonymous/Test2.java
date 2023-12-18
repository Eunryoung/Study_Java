package anonymous;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * run() 메서드를 가지는 인터페이스 Vehicle를 정의하고
		 * 익명 구현 객체를 이용하여 필드, 로컬변수의 초기값과
		 * 메서드의 매개값을 출력해보세요!
		 * 필드 : 자전거가 달립니다!
		 * 로컬변수의 초기값 : 승용차가 달립니다!
		 * 메서드의 매개값 : 트럭이 달립니다!
		 */
		
		UseAnonymousInterfaceClass uaic = new UseAnonymousInterfaceClass();
		uaic.v.run();
		uaic.method();
		uaic.method2(new Vehicle() {
			@Override
			public void run() {
				System.out.println("트럭이 달립니다!");
			}
		});
	}

}

interface Vehicle {
	public abstract void run();
}

class UseAnonymousInterfaceClass {
	Vehicle v = new Vehicle() {
		
		@Override
		public void run() {
			System.out.println("자전거가 달립니다!");
		}
	};
	
	public void method() {
		Vehicle localVar = new Vehicle() {
			
			@Override
			public void run() {
				System.out.println("승용차가 달립니다!");
			}
		};
		localVar.run();
	}
	
	public void method2(Vehicle v) {
		v.run();
	}
	
}