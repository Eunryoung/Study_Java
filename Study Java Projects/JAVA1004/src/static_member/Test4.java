package static_member;

public class Test4 {

	public static void main(String[] args) {
	
//		Account acc = new Account();
//		Account acc2 = new Account(); // 인스턴스 여러개 생성 가능 => 싱글톤 디자인 X
		
		//  --------------------------------------------------------
		
		// 자신의 인스턴스를 생성하여 자신의 클래스 타입 참조변수 instance에 저장(static 명시)
//		Account acc = Account.instance; // 클래스명.을 붙여서 참조주소값 가져올 수 있게 됨
//		acc.instance = null; // but 값을 마음대로 바꿀수있게 됨 -> private 명시
		
		// 생성된 인스턴스 주소를 리턴
		Account acc = Account.getInstance(); // 리턴받은 인스턴스 주소값을 Account 클래스 타입 변수 acc에 저장
		
		// Setter() 호출하여 111-1111-111, 홍길동, 10000 입력
		acc.setAccountNo("111-1111-111");
		acc.setOwnerName("홍길동");
		acc.setBalance(10000);
		
		// showAccountInfo() 메서드로 계좌 정보를 출력!
		acc.showAccountInfo();		
	}

}

/*
 * Account 클래스를 싱글톤 디자인 패턴을 적용하여 설계
 * - 멤버변수 : accountNo, ownerName, balance 모두 private 설정
 * - 메서드 : showAccountInfo(), 멤버변수에 대한 Getter/Setter 정의
 */

class Account {
// < 싱글톤 디자인이 아닌 기존 방식 >  	
//	String accountNo;
//	String ownerName;
//	int balance;
//	
//	public Account() {}
//
//	public void showAccountInfo() {
//		System.out.println("계좌번호 : " + accountNo);
//		System.out.println("예금주명 : " + ownerName);
//		System.out.println("현재잔고 : " + balance + "원");
//	}
	
// ----------------------------------------------------------------------------------
//	< 싱글톤 디자인 패턴을 적용해 Account 클래스를 설계 >
	
	// 1. 기본 생성자 정의 
	//	  => private : 외부에서 인스턴스 생성을 하지 못하도록 막음
	private Account() {}
	
	// 2. 자신의 인스턴스를 생성하여 자신의 클래스 타입 변수 instance에 저장
	//	  => private static 선언
//	public static Account instance = new Account(); 
	// => static 명시 : 외부에서 클래스명.멤버변수명(Account.instance)으로 인스턴스 주소를 가져올 수 있다(접근 가능하게 됨)
	// => 그러나 Account 클래스로부터 리턴받은 인스턴스를 통해 
	//    클래스 내의 Account 타입 변수 instance에 접근이 가능하므로 
	//    해당 변수의 값을 변경할 우려가 있음! => private 명시
	
	private static Account instance = new Account(); 
	// => 값을 마음대로 바꾸지 못하게 private도 명시 => 접근을 못하게 됨 => Getter 정의 시 public static 선언
	
	// 3. Getter 정의 
	//    => public static 선언 : 누구나 다 접근 가능한 메서드로 만듦
	public static Account getInstance() { // 리턴타입이 기본 데이터타입이 아닌 Account 클래스 타입임
		return instance; // 인스턴스 주소값 리턴
	}
	
	private String accountNo;
	private String ownerName;
	private int balance;
	
	// Setter() 호출 시 전달받은 값을 멤버변수에 저장
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 저장된 멤버변수 값을 출력하는 메서드
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}
	
}
