package nested_class;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 중첩 인터페이스(Nested Interface)
		 * - 클래스의 멤버로 선언된 인터페이스
		 * - 클래스 내부에 인터페이스를 선언하는 이유는 해당 클래스와
		 *   긴밀한 관계를 맺는 구현 클래스를 만들기 위함
		 * - 인스턴스 멤버 인터페이스와 정적(static) 멤버 인터페이스 모두 구현 가능
		 * - 인스턴스 멤버 인터페이스는 바깥 클래스 객체가 있어야 사용가능하며
		 *   정적 멤버 인터페이스는 바깥 클래스 객체 없이 바깥 클래스명만으로 접근 가능
		 * - 주로 정적 멤버 인터페이스를 많이 사용하는데 UI 프로그래밍에서 이벤트를
		 *   처리하는 목적으로 많이 활용됨
		 *   
		 * < 중첩 인터페이스 기본 문법 >
		 * class 바깥쪽 클래스명 {
		 * 		[static] interface 안쪽 인터페이스명 {
		 * 
		 * 		}
		 * }
		 */
		
		Button btn = new Button(); // 바깥쪽 클래스의 인스턴스 생성
		
		btn.setOnClickListener(new CallListener());
		btn.touch();
		
		btn.setOnClickListener(new MessageListener());
		btn.touch();
		
	} // main() 메서드 끝

} // Ex3 클래스 끝

// 클릭 시 이벤트를 처리하는 클래스 Button 정의
class Button { // 바깥쪽 클래스(Outer Class)
	static interface OnClickListener { // 중첩 인터페이스(Inner Interface)
		// 인터페이스는 상수, 추상메서드만 가질 수 있다!
		
		void onClick(); // public abstract void onClick();
		// => 추상 메서드 onClick() 정의
		
	}

	OnClickListener listener; // 인터페이스 타입 필드(멤버) 선언
	
	public void setOnClickListener(OnClickListener listener) {
		// => 다형성을 위한 onClickListener 매개 변수 선언
		this.listener = listener;
	} 
	
	public void touch() {
		listener.onClick(); // 구현 객체(클래스)에 각각 오버라이드 되어 있는 onClick() 메서드 호출
	}
		
	
	
} // Button 클래스 끝

// OnClickListener 인터페이스를 구현(implements) 하는 구현 클래스 정의
// => 전화걸기 버튼 터치의 경우 
class CallListener implements Button.OnClickListener {

	@Override
	public void onClick() {
		System.out.println("전화를 겁니다!");
	}
	
}

// OnClickListener 인터페이스를 구현(implements) 하는 구현 클래스 정의
// => 문자보내기 버튼 터치의 경우 
class MessageListener implements Button.OnClickListener {

	@Override
	public void onClick() {
		System.out.println("문자를 보냅니다!");
	}
	
}