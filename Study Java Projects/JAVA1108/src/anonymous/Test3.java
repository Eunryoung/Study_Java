package anonymous;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * CheckBox 클래스를 정의
		 * - select() 메서드가 호출되면 "배경을 변경합니다!" 가 출력
		 */
		// CheckBox 객체 생성
		CheckBox cb = new CheckBox();

		// setOnSelectListener 호출, 이 때 매개변수로 익명 구현 객체를 사용
		cb.setOnSelectListener(new CheckBox.OnSelectListener() {
			
			@Override
			public void onSelect() {
				System.out.println("배경을 변경합니다!");
			}
		});
		
		// select() 메서드 호출
		cb.select();
	}

}

// CheckBox 클래스 정의
// - 정적 내부 인터페이스 OnSelectListener 정의
// 	 => onSelect() 추상 메서드 선언
// - OnSelectListener 타입의 인스턴스 변수를 선언
// - setOnSelectListener 메서드를 정의. 이 때 매개변수로 인터페이스 타입 지정
// - select() 메서드를 정의해서 인스턴스 변수의 오버라이딩 된 onSelect() 메서드가 호출되도록 함
class CheckBox {
	static interface OnSelectListener {
		void onSelect();
	}
	
	OnSelectListener listener;
	
	public void setOnSelectListener(OnSelectListener listener) {
		this.listener = listener;
	}
	
	public void select() {
		listener.onSelect();
	}
}