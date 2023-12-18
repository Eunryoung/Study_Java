package constructor;

public class Test {

	public static void main(String[] args) {
		// Account 인스턴스 생성	
		Account acc = new Account();
		
//		acc.accountNo = "111-1111-111";
//		acc.ownerName = "홍길동";
//		acc.balance = 10000;
		
		acc.showAccountInfo();
		
		Account acc2 = new Account();
		acc2.showAccountInfo();
		
	} // main() 메서드 끝

} // Test 클래스 끝


/*
 * Account 클래스 정의
 * - accountNo, ownerName, balance
 * - 인스턴스 생성 시
 * 	 "Account() 생성자 호출됨!"를 출력
 * 	 accountNo = "111-1111-111", ownerName = "홍길동", balance = 10000
 * 	 초기값 설정
 * 
 * - showAccountInfo() 메서드 : 계좌번호, 예금주명, 현재잔고 출력
 * 	 계좌번호 : 111-1111-111
 * 	 예금주명 : 홍길동
 * 	 현재잔고 : 10000원
 */

class Account {
	// 멤버변수
	String accountNo;
	String ownerName;
	int balance;
	
//	public Account() {} // 기본 생성자	
	
	// 생성자 정의
	public Account() {
		System.out.println("Account() 생성자 호출됨!");
		
		// 인스턴스 생성 시 기본값으로 가져야할 데이터를 멤버변수에 저장
		accountNo = "111-1111-111";
		ownerName = "홍길동";
		balance = 10000;
	}
	
	// 메서드 정의
	// 계좌 정보를 출력하는 showAccountInfo() 메서드 정의
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}
	
}