package this_;

public class Test2 {

	public static void main(String[] args) {
		Account2 acc1 = new Account2();
//		acc1.accountNo = "111-1111-111";
//		acc1.ownerName = "홍길동";
//		acc1.balance = 0;
		acc1.showAccountInfo();
		System.out.println("-------------------------------------------");
		
	
		Account2 acc2 = new Account2("666-6666-666");
		acc2.showAccountInfo();
		System.out.println("-------------------------------------------");
		
		Account2 acc3 = new Account2("666-6666-666", "임은령");
		acc3.showAccountInfo();
		System.out.println("-------------------------------------------");
		
		Account2 acc4 = new Account2("666-6666-666", "임은령", 213532465);
		acc4.showAccountInfo();
		System.out.println("-------------------------------------------");
	}

}

/*
 * Account2 클래스 생성
 * - 멤버변수 : accountNo, ownerName, balance 선언
 * - 생성자 오버로딩(레퍼런스 this와 생성자 this() 활용)
 * 	 1) 기본 생성자 ("111-1111-111", "홍길동", 0)
 * 	 2) 계좌번호를 전달받아 초기화하는 생성자
 * 	 3) 계좌번호, 예금주명을 전달받아 초기화하는 생성자
 * 	 4) 계좌번호, 예금주명, 현재잔고를 전달받아 초기화하는 생성자
 *		=> 초기화 작업을 수행하는 생성자
 * - showAccountInfo() 메서드 정의 -> 계좌번호, 예금주명, 현재잔고를 출력
 */

class Account2 {
	String accountNo;
	String ownerName;
	int balance;
	

	// 기본생성자
	public Account2() {
		this("111-1111-111", "홍길동", 0);
//		accountNo = "111-1111-111";
//		ownerName = "홍길동";
//		balance = 0;		
		System.out.println("Account2() 생성자 호출됨!");
	}
	
	// 생성자 단축키 : Alt + Shift + S -> O	
	// 계좌번호를 전달받아 초기화하는 파라미터 생성자
	public Account2(String accountNo) {
		this(accountNo, "홍길동", 0);
//		this.accountNo = accountNo;
//		ownerName = "홍길동";
//		balance = 0;		
		System.out.println("Account2(String) 생성자 호출됨!");
	}
	
	// 계좌번호와 예금주명을 전달받아 초기화하는 파라미터 생성자
	public Account2(String accountNo, String ownerName) {
		this(accountNo, ownerName, 0);
//		this.accountNo = accountNo;
//		this.ownerName = ownerName;
//		balance = 0;		
		System.out.println("Account2(String, String) 생성자 호출됨!");
	}


	// 계좌번호, 예금주명, 현재잔고를 전달받아 초기화하는 파라미터 생성자
	public Account2(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println("Account2(String, String, int) 생성자 호출됨!");
	}

	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}
	
}

