package inheritance;

public class Test {

	public static void main(String[] args) {
		ItwillBank ib = new ItwillBank();
		
		// Account 클래스(= 부모클래스)로부터 상속받은 기본 멤버에 접근
		ib.accountNo = "111-1111-111";
		ib.ownerName = "홍길동";
		ib.balance = 0;
		
		ib.showAccountInfo();
		System.out.println("-----------------------------------");

		ib.deposit(10000);
		System.out.println("-----------------------------------");
		
//		System.out.println(ib.withdraw(5000)); // 이런 식으로 직접 출력할 수도 있지만
		
		// 수수료 등을 뗄 경우 변수 처리해서 출력하는 것이 좋음
		int money = ib.withdraw(5000);
		System.out.println("출금된 금액 : " + (money - 100) + "원"); // 수수료 100원 차감 가정
		System.out.println("-----------------------------------");
		
		ib.withdraw(7000);
		System.out.println("-----------------------------------");
		
		// ItwillBank의 고유 기능(추가된 기능)
		ib.contract("KB 손해보험");
		
	} // main() 메서드 끝
	
	
} // Test 클래스 끝

/*
 * Account 클래스를 상속받는 ItwillBank 클래스 정의
 * - Account의 기본 기능(계좌의 기본 기능)은 그대로 유지
 * 	 => 멤버변수 : 계좌번호(accountNo), 예금주명(ownerName), 현재잔고(balance) 
 *   => 메서드 : 입금하기(deposit), 출금하기(withdraw), 정보보기(showAccountInfo) 
 * - 멤버변수 추가 : 보험명(insureName, 문자열)
 * - 메서드 추가 : 보험계약(contract())
 *   => 파라미터 : 보험명
 *   => 리턴값 : 없음
 *   => 전달받은 보험명을 멤버변수에 저장 후 "XXX 보험 계약 완료!" 출력
 */

class Account { // = class Account Extends Object
	// 멤버변수 선언
	String accountNo;
	String ownerName;
	int balance;
	
	public void showAccountInfo() {
		// 자신의 클래스 내부이므로 참조변수 없이 그대로 변수명 사용 가능
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}
	
	// 입금 기능 -> 입금 시에는 돌려받을 것이 없으므로 리턴타입은 void
	public void deposit(int amount) {
		balance += amount; // 입금받은 금액을 현재잔고에 누적
		System.out.println("입금한 금액 : " + amount + "원");
		System.out.println("현재잔고 : " + balance + "원");
	}
	
	// 출금 기능 -> 출금 금액 리턴
	public int withdraw(int amount) {
		if(balance >= amount) { // 현재잔고와 출금할 금액이 같은 경우에도 출금 가능하므로 = 붙여야함!
			balance -= amount;
			System.out.println("출금할 금액 : " + amount + "원");
			System.out.println("현재잔고 : " + balance + "원");
//			return balance; // if-else문 안에 각각 return해도 되고
		} else {
			System.out.println("잔액이 부족하여 출금할 수 없습니다.");
			System.out.println("출금 요청 금액 : " + amount + "원");
			System.out.println("현재잔고 : " + balance + "원");
//			return 0; // if-else문 안에 각각 return해도 되고
		}
		
		return amount; // if-else문 밖으로 빠져나와서 한번에 return해도 된다
	}
	
}

class ItwillBank extends Account {
	// 멤버변수 선언
	String insureName;
	
	// 보험명(문자열)을 파라미터로 받아 멤버변수에 저장 후 출력하는 메서드
	public void contract(String insureName) {
		this.insureName = insureName;
		System.out.println(this.insureName + " 계약 완료!");
	}
}