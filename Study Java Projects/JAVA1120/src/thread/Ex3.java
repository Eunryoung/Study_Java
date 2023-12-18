package thread;

public class Ex3 {

	public static void main(String[] args) {
		// Runnable 인터페이스 구현체 클래스의 인스턴스 생성
		YourThread yt1 = new YourThread("★A작업★", 1000000);
		YourThread yt2 = new YourThread("§B작업§", 500000);
		YourThread yt3 = new YourThread("▲C작업▲", 1000000);
		
		Runnable r = new YourThread("▲C작업▲", 1000000); 
		// => Runnable 타입으로 업캐스팅하는 것으로도 표현 가능		
		
		// Runnable 구현체 내부에서 start() 메서드가 존재하지 않는다!
		// => 애초에 Runnable 인터페이스 내에는 없는 메서드
//		yt1.start(); // 컴파일 에러 발생! 존재하지 않는 메서드!
		
		// Thread 클래스의 인스턴스 생성 시 생성자 파라미터에 Runnable 전달 가능
		// => Thread 객체의 start() 메서드를 통해 간접적으로 멀티 쓰레딩 수행
//		Thread t1 = new Thread(yt1);
//		Thread t2 = new Thread(yt2);
//		Thread t3 = new Thread(yt3);
		
		// -----------------------------------------------------------------------------------
		// YourThread 타입 변수(ytn)는 Thread 생성자에 전달 작업 외에 불필요
		// => 1회성 변수를 선언하기 보다 생성자에 인스턴스를 직접 전달 가능
		Thread t1 = new Thread(new YourThread("★A작업★", 1000000));
		Thread t2 = new Thread(new YourThread("§B작업§", 500000));
		Thread t3 = new Thread(new YourThread("▲C작업▲", 1000000));
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class A {}

// 이미 A 클래스를 상속받은 YourThread 클래스에 멀티쓰레딩을 구현해야 하는 경우
// => Thread 클래스를 상속받지 못함(= 다중 상속 불가)
// => Runnable 인터페이스를 구현(implements) 해야 함
class YourThread extends A implements Runnable {
	// => The type YourThread must implement the inherited abstract method Runnable.run()
	// => run() 메서드를 구현해야 한다!
	String name;
	int count;
	
	public YourThread(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	// run() 메서드를 오버라이딩하여 멀티쓰레딩으로 처리할 코드를 기술
	@Override
	public void run() {
		for(int i = 1; i <= count; i++) {
			System.out.println(name + " : " + i);
		}
		
	}
	
	
	
}