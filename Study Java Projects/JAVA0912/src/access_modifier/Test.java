package access_modifier;

public class Test {

	public static void main(String[] args) {
		
		// 은행계좌(Account) 클래스의 인스턴스(acc) 생성
		Account acc = new Account();
		
//		acc.accountNo = "111-1111-111";
		// => 접근제한자가 private으로 설정되어 있어 접근 불가!
		// => Setter() 메서드로 대체!
		
		// Setter() 메서드로 111-1111-111, 홍길동, 10000 입력
		acc.setAccountNo("111-1111-111");
		acc.setOwnerName("홍길동");
		acc.setBalance(10000);
		
//		System.out.println("계좌번호 : " + acc.accountNo);
//		System.out.println("예금주명 : " + acc.ownerName);
//		System.out.println("현재잔고 : " + acc.balance);
		// => Getter() 메서드로 대체		
		
		// Getter() 메서드를 활용하여 계좌번호, 예금주명, 현재잔고를 출력
		System.out.println("계좌번호 : " + acc.getAccountNo());
		System.out.println("예금주명 : " + acc.getOwnerName());
		System.out.println("현재잔고 : " + acc.getBalance());
	}

}


/*
 * Account 클래스 정의
 * - 멤버변수(private 접근제한자로 선언)
 * 	 accountNo(문자열), ownerName(문자열), balance(정수)
 * - Getter / Setter 메서드 정의(단축키 사용 가능!)
 */

class Account{
	// Account 클래스의 멤버변수 private 접근제한자로 선언
	private String accountNo;
	private String ownerName;
	private int balance;
	
	// Getter / Setter 메서드 정의하여 멤버변수에 간접적으로 접근하도록 수행
	// 1. String accountNo 변수에 대한 Getter / Setter
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String newAccountNo) {
		accountNo = newAccountNo;
	}
	
	
	// 2. String ownerName 변수에 대한 Getter / Setter
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String newOwnerName) {
		ownerName = newOwnerName;
	}
	
	
	// 3. int balance 변수에 대한 Getter / Setter
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int newBalance) {
		balance = newBalance;
	}
	
	
	// ==============================================================
	// Getter / Setter 단축키 사용 : Alt + Shift + S -> R
//	public String getAccountNo() {
//		return accountNo;
//	}
//	
//	public void setAccountNo(String accountNo) {
//		this.accountNo = accountNo;
//	}
//	
//	public String getOwnerName() {
//		return ownerName;
//	}
//	
//	public void setOwnerName(String ownerName) {
//		this.ownerName = ownerName;
//	}
//	
//	public int getBalance() {
//		return balance;
//	}
//	
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
}
