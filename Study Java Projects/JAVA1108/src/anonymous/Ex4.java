package anonymous;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * 익명 객체의 로컬 변수 사용
		 * - 메서드의 매개변수나 로컬변수를 익명 객체 내부에서 사용할 때 제한이 있음
		 * - 익명 객체는 메서드 실행이 종료되면 없어지는 것이 일반적이지만
		 *   메서드가 종료되어도 계속 실행 상태로 존재할 수 있음
		 *   (e.g. 익명 쓰레드 객체 사용)
		 * - 메서드의 매개변수나 로컬변수를 익명 객체 내부에서 사용할 때 
		 *   매개변수나 로컬변수는 메서드 실행이 끝나면 스택(Stack) 메모리에서 사라지기 때문에
		 *   익명 객체에서는 지속적으로 사용할 수 없음
		 * - 이런 문제를 해결하기 위해 자바는 컴파일 시 익명 객체에서 사용하는
		 *   매개변수나 로컬변수의 값을 익명 객체 내부에 복사해두고 사용함
		 * - 매개변수나 로컬변수가 수정되어 값이 변경되면 수정된 값과 익명 객체에 복사해둔 값이 달라지게 되어
		 *   매개 변수나 로컬변수를 final로 선언할 것을 요구함
		 * - 자바 7 이전까지는 final 키워드 없이 선언된 매개변수나 로컬변수를 익명 객체에서 사용 시 컴파일 에러가 발생했었음
		 * 	 (자바 8 부터 final 키워드 없이 선언된 매개변수나 로컬별수 사용 시 에러 발생하지 않음)
		 * - final 선언을 하지 않아도 수정될 수 없어도 final의 특성을 부여하기 때문
		 *       
		 */
		
		AnonymousClass ac = new AnonymousClass();
		ac.method(5, 7);
		
	}

}

interface Caculatable {
	public int sum();
}

class AnonymousClass {
	private int num;
	
	public void method(final int arg1, int arg2) {
		final int num1 = 0;
		int num2 = 0;
		
		num = 10; // 인스턴스 멤버 변수의 값은 변경 가능
		
//		arg1 = 20;
		// => The final local variable arg1 cannot be assigned. 
		//    It must be blank and not using a compound assignment
		// => final 변수는 값 변경 불가
//		arg2 = 20; 
		// => 메서드 내부에서 매개변수나 로컬 변수의 값을 변경 할 때는 오류가 발생하지 않는다!
		//    그러나 이후 익명 구현 객체 내부에서 사용하려할 때 오류가 발생하므로 값 변경 부분 주석처리 해야함

		// num1 = 30;
		// => The final local variable num1 cannot be assigned. 
		//    It must be blank and not using a compound assignment
		// => final 변수는 값 변경 불가
//		num2 = 30;
		// => 메서드 내부에서 매개변수나 로컬 변수의 값을 변경 할 때는 오류가 발생하지 않는다!
		//    그러나 이후 익명 구현 객체 내부에서 사용하려할 때 오류가 발생하므로 값 변경 부분 주석처리 해야함
		
		Caculatable cal = new Caculatable() {
			
			@Override
			public int sum() {
				int result = num + arg1 + arg2 + num1 + num2;
				// => Local variable arg2 defined in an enclosing scope must be final or effectively final
				// => 익명 객체에서 매개변수 값 또는 로컬변수 사용 시 
				//    값의 변경이 있으면 컴파일 에러가 발생
				//    따라서, 익명 객체 사용 전 값을 변경하는 부분이 없어야 함!
				// => 메서드 내부에서 매개변수나 로컬 변수의 값을 변경 할 때는 오류가 발생하지 않는다!
				//    그러나 익명 구현 객체 내부에서 사용하려할 때 오류가 발생하므로 값 변경 부분 주석처리 해야함
				//    그러니 처음부터 final 선언을 해두면 좋음!
				//    (어차피 값을 변경한다면 익명 구현 객체 내부에서 사용 시 오류 발생하기 때문)
				return result;
			}
		};
		
		System.out.println(cal.sum());
		
	} // method() 끝
	
} // Ex4 클래스 끝