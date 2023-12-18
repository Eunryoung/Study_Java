package method_overriding;

public class Test2 {

	public static void main(String[] args) {
		
		// 전기자동차 인스턴스 생성
		ElectricCar ec = new ElectricCar();
		System.out.println("현재속력 : " + ec.speed + ", 최대속력 : " + ec.maxSpeed); // 정의하지 않아서 기본값인 0 출력

		// speed : 0, maxSpeed : 240, batteryCapacity : 5
		ec.speed = 0;
		ec.maxSpeed = 240;
		ec.batteryCapacity = 5;
		System.out.println("현재속력 : " + ec.speed + ", 최대속력 : " + ec.maxSpeed);
		System.out.println("배터리 용량 : " + ec.batteryCapacity);
		
		// ElectricCar 클래스에서 오버라이딩한 메서드 출력
		ec.speedUp();
		ec.speedDown();
		ec.addFuel();
		
		System.out.println("----------------------------------------------------------");
		
		// 디젤자동차 인스턴스 생성
		DieselCar dc = new DieselCar();
		System.out.println("현재속력 : " + dc.speed + ", 최대속력 : " + dc.maxSpeed); // 정의하지않아서 기본값인 0 출력
		
		// speed : 0, maxSpeed : 260, cc : 3000
		dc.speed = 0;
		dc.maxSpeed = 260;
		dc.cc = 3000;
		System.out.println("현재속력 : " + dc.speed + ", 최대속력 : " + dc.maxSpeed);
		System.out.println("엔진 배기량 : " + dc.cc);
		
		// DieselCar 클래스에서 오버라이딩한 메서드 출력
		dc.speedUp();
		dc.speedDown();
		dc.addFuel();
	}

}

/*
 * Car 클래스 정의
 * - 멤버변수 : speed(현재속력, int), maxSpeed(최대속력, int)
 * - 메서드
 * 	 speedUp() : "자동차 속력 증가!" 출력(리턴타입, 파라미터 없음)
 * 	 speedDown() : "자동차 속력 감소!" 출력(리턴타입, 파라미터 없음)
 * 	 addFuel() : "자동차 연료 주입!" 출력(리턴타입, 파라미터 없음)
 */

/*
 * 자동차(Car) 클래스를 상속받는 전기자동차(ElectricCar) 정의
 * - 멤버변수 : batteryCapacity(배터리 용량, int)
 * - Car 클래스의 메서드 오버라이딩
 * 	 speedUp() : "ElectricCar 전기모터의 힘으로 속력 증가!" 출력
 * 	 speedDown() : "ElectricCar 속력 감소하면서 전기배터리 충전!" 출력
 * 	 addFuel() : "전기차 충전소에서 배터리 충전!" 출력
 */

/*
 * 자동차(Car) 클래스를 상속받는 디젤자동차(DieselCar) 정의
 * - 멤버변수 : cc(엔진 배기량, int)
 * - Car 클래스의 메서드 오버라이딩
 * 	 speedUp() : "디젤 엔진의 힘으로 속력 증가!" 출력
 * 	 speedDown() : "디젤 자동차 속력 감소!" 출력
 * 	 addFuel() : "주유소에서 디젤 연료 주입!" 출력
 * 
 */

class Car {
	int speed;
	int maxSpeed;
	
	public void speedUp() {
		System.out.println("자동차 속력 증가!");
	}
	
	public void speedDown() {
		System.out.println("자동차 속력 감소!");
	}
	
	public void addFuel() {
		System.out.println("자동차 연료 주입!");
	}
}

class ElectricCar extends Car {
	int batteryCapacity;
	
	public void speedUp() {
		System.out.println("ElectricCar 전기모터의 힘으로 속력 증가!");
	}
	
	public void speedDown() {
		System.out.println("ElectricCar 속력 감소하면서 전기배터리 충전!");
	}
	
	public void addFuel() {
		System.out.println("전기차 충전소에서 배터리 충전!");
	}
}

class DieselCar extends Car {
	int cc;
	
	public void speedUp() {
		System.out.println("디젤 엔진의 힘으로 속력 증가!");
	}
	
	public void speedDown() {
		System.out.println("디젤 자동차 속력 감소!");
	}
	
	public void addFuel() {
		System.out.println("주유소에서 디젤 연료 주입!");
	}
	
}