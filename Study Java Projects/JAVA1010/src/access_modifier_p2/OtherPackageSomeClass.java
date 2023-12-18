package access_modifier_p2;


//import access_modifier_p1.ParentClass; // import문으로 다른 패키지에 있는 클래스에 접근할 수 있다!
import access_modifier_p1.ParentClass;

public class OtherPackageSomeClass {
	
	public void useMember() {
		// 다른 패키지의 상속 관계가 아닌 다른 클래스 에서의 접근
		// => 클래스가 다르므로 인스턴스 생성 후 참조변수를 통해 접근해야 함 => has-a 관계
		// => 다른 패키지이므로 import문이 필요!
		
		ParentClass p = new ParentClass(); // 기본생성자 호출
		// => import문이 없으면 오류 발생!
		// => ParentClass cannot be resolved to a type
		
//		access_modifier_p1.ParentClass p = new access_modifier_p1.ParentClass();
		// => 패키지명 직접 명시할 경우 오류 사라짐 
		// => 혹은 import문 사용 (ctrl + space로 import문 자동완성)
		
		p.publicVar = 10; // public 접근 가능
//		p.protectedVar = 20; 
		// => protected 접근 불가!
		// => 패키지가 다르고, 상속관계도 아니므로 접근 불가
//		p.defaultVar = 30; 
		// => default 접근 불가!
		// => 다른 패키지에서 접근 불가!
//		p.privateVar = 40; 
		// => private 접근 불가!
		// => private 접근 제한자이므로 다른 클래스에서 접근 불가(ParentClass내 에서만 접근 가능!), 패키지도 다름!

		// 결론 : import문을 사용하더라도 다른 패키지라면 public 처리가 되어있는 멤버에 대해서만 접근 가능
	}
}
