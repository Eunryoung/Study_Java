package abstract_;

public class Test_2 {

	public static void main(String[] args) {
		
//		Vehicle v = new Vehicle(); // 인스턴스 생성 불가! -> 추상클래스
		
		// 추상클래스 Vehicle 타입을 참조변수로 활용 = 업캐스팅을 통한 다형성 구현
		Vehicle v = new ElectricCar();
		v.addFuel();
		v.reportPosition();
		
		v = new DieselCar();
		v.addFuel();
		v.reportPosition();
		
	} // main() 메서드 끝 

} // Test_2 클래스 끝

/*
 * Vehicle 클래스 정의
 * 멤버변수 : curX, curY(int) 현재 좌표를 저장하는 변수
 * 메서드 : reportPosition(리턴타입X, 매개변수X)
 * 			=> "현재 위치 : curX, curY"
 * 			addFuel(리턴타입X, 매개변수X)
 * 			=> 차량마다 연료 공급 방법이 달라지므로 오버라이딩을 해야하며
 * 			   오버라이딩 강제성을 부여함
 */
abstract class Vehicle { // 추상메서드가 포함되어 있으므로 abstract 키워드 명시해 추상클래스로 정의
	int curX, curY;
	
	public void reportPosition() {
		System.out.println("현재 위치 : " + curX + ", " + curY);
	}
	
	public abstract void addFuel(); // 추상메서드 정의
	
}


/*
 * Vehicle 클래스를 상속받는 ElectricCar, DieselCar 클래스 정의
 * => ElectricCar의 addFuel() : "전기차 충전소에서 배터리 충전!"
 * => DieselCar의 addFuel() : "주유소에서 디젤 연료 공급!"
 */
class ElectricCar extends Vehicle {
	
	// 추상메서드 오버라이딩 작업
	@Override
	public void addFuel() {
		System.out.println("전기차 충전소에서 배터리 충전!");
	}
}

class DieselCar extends Vehicle {

	// 추상메서드 오버라이딩 작업
	@Override
	public void addFuel() {
		System.out.println("주유소에서 디젤 연료 공급!");
	}
}