package class_;

public class Test2 {

	public static void main(String[] args) {
		Account acc = new Account();
		acc.accountNo = "111-1111-111";
		acc.ownerName = "홍길동";
		acc.balance = 10000;
		
		acc.showAccountInfo();

	} // main() 메서드 끝

} // Test2 클래스 끝

/*
 * 은행계좌(Account) 클래스 정의
 * 멤버변수
 * - 계좌번호(accountNo, 문자열)
 * - 예금주명(ownerName, 문자열)
 * - 현재잔고(balance, 정수)
 * 
 * 메서드
 * - showAccountInfo() => 리턴값 없음, 매개변수 없음
 * => 계좌번호, 예금주명, 현재잔고를 출력하는 메서드 정의
 * e.g. 계좌번호 : 111-1111-111
 * 		예금주명 : 홍길동
 * 		현재잔고 : 10000원
 *
 */

class Account { // Test2 클래스 내에 Account 클래스 만드니까 public 명시할 필요 X
	String accountNo;
	String ownerName;
	int balance;
	
	public void showAccountInfo(){
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}
}