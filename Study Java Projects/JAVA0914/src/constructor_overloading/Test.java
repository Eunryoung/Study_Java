package constructor_overloading;

public class Test {

	public static void main(String[] args) {
		MyDate md = new MyDate();
		System.out.printf("%d/%d/%d\n",md.year, md.month, md.day);
		
		System.out.println("--------------------------------");
		
		MyDate md2 = new MyDate(2023);
		System.out.printf("%d/%d/%d\n",md2.year, md2.month, md2.day);
		
		System.out.println("--------------------------------");
		
		MyDate md3 = new MyDate(2023, 9);
		System.out.printf("%d/%d/%d\n",md3.year, md3.month, md3.day);
		
		System.out.println("--------------------------------");
		
		MyDate md4 = new MyDate(2023, 9, 14);
		System.out.printf("%d/%d/%d\n",md4.year, md4.month, md4.day);
		
		System.out.println("--------------------------------");
		
	} // main() 메서드 끝

	
} // Test 클래스 끝

/*
 * 날짜를 관리하는 MyDate 클래스 정의
 * - 멤버변수 : 연도(year, 정수), 월(month, 정수), 일(day, 정수)
 * - 생성자
 *   1) 기본 생성자 : 1999년 1월 1일로 초기화
 *   2) 파라미터 생성자
 *   	2-1. 연도(year)를 전달받아 초기화하고, 1월 1일로 초기화
 *   	2-2. 연도(year), 월(month)를 전달받아 초기화하고 1일로 초기화
 *   	2-3. 연도(year), 월(month), 일(day)를 전달받아 초기화
 *   
 *   생성자 자동 단축키 : Alt + Shift + S -> O    
 */

class MyDate {
	int year;
	int month;
	int day;
	
	// 1) 기본 생성자 : 1999년 1월 1일로 초기화
	public MyDate() {
		System.out.println("MyDate() 생성자 호출됨!");
		year = 1999;
		month = 1;
		day = 1;
	}
	
	// 2-1. 연도(year)를 전달받아 초기화하고, 1월 1일로 초기화
	public MyDate(int newYear) {
		System.out.println("MyDate(int) 생성자 호출됨!");
		year = newYear;
		month = 1;
		day = 1;
	}
	
	// 2-2. 연도(year), 월(month)를 전달받아 초기화하고 1일로 초기화
	public MyDate(int newYear, int newMonth) {
		System.out.println("MyDate(int, int) 생성자 호출됨!");
		year = newYear;
		month = newMonth;
		day = 1;
	}
	
	// 2-3. 연도(year), 월(month), 일(day)를 전달받아 초기화
//	public MyDate(int newYear, int newMonth, int newDay) {
//		System.out.println("MyDate(int, int, int) 생성자 호출됨!");
//		year = newYear;
//		month = newMonth;
//		day = newDay;
//	}
	// 자동 생성 단축키 : Alt + Shift + S -> O 
	public MyDate(int year, int month, int day) {
		System.out.println("MyDate(int, int, int) 생성자 호출됨!");
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	
	public void showDate() {
		System.out.println("설정된 날짜는 " + year + "년 " + month + "월 " + day + "일 입니다.");
	}

}