package final_test;

public class Test3 {

	public static void main(String[] args) {
		Account acc = new Account("111-1111-111", "임은령", 10000);
//		acc.deposit(5000);
//		acc.withdraw(5000);
		acc.withdraw(15000);
	}

}

class Account {
	String accountNo;
	String ownerName;
	int balance;
	
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		balance += amount;
		System.out.println("입금 금액 : " + amount + "원, 현재잔고 : " + balance + "원");
	}
	
	public int withdraw(int amount) {
		
		if(balance >= amount) {
			balance -= amount;
			System.out.println("현재잔고 : " + balance + "원, 출금할 금액 : " + amount + "원");
			System.out.println(amount + "원이 출금되었습니다 (현재잔고 : " + balance + "원)");
		} else if(balance < amount) {
			System.out.println("현재잔고 : " + balance + "원, 출금할 금액 : " + amount + "원");
			System.out.println("잔고가 부족하여 출금할 수 없습니다.");
		}
		return amount;
	}
	
}