package access_modifier_p1;

public class SamePackageSomeClass {
	
	public void useMember() {
		// 같은 패키지 내의 다른 클래스(ParentClass)의 멤버에 접근
		// => 인스턴스 생성 후 참조변수를 통해 접근해야 함
		// => 같은 패키지이므로 import문이 불필요!
//		publicVar = 10; // 오류 발생
//		this.publicVar = 10; // 오류 발생
		
		ParentClass p = new ParentClass(); // ParentClass의 인스턴스 생성
		
		// 참조변수 p와 public 접근제한자를 통해 접근 가능
		p.publicVar = 10; // public 접근 가능
		p.protectedVar = 20; // protected 접근 가능(같은 패키지)
		p.defaultVar = 30; // default 접근 가능(같은 패키지)
//		p.privateVar = 40; 
		// => private 접근 불가!
		// => private 접근 제한자이므로 다른 클래스에서 접근 불가(ParentClass 내에서만 접근 가능!)
	}
}
