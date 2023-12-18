package inheritance;

public class Test2 {

	public static void main(String[] args) {
		Manager mgr = new Manager("홍길동", 4000, "개발팀");
		System.out.println(mgr.getManager());
		
	} // main() 메서드 끝

} // Test2 클래스 끝

/*
 * 직원(Employee) 클래스
 * 멤버변수
 *  - 직원이름(name, 문자열)
 *  - 연봉(salary, 정수)
 * 메서드
 *  - 직원 정보를 문자열로 결합하여 리턴하는 getEmployee() 메서드 정의
 *    (파라미터 없음, 리턴값 있음(String))
 *    => 직원 이름과 연봉을 문자열로 결합하여 리턴
 *    	 e.g. 홍길동, 4000
 */
class Employee {
	String name;
	int salary;
	
	public String getEmployee() {
		return name + ", " + salary;
	}
	
}

/*
 * Employee 클래스를 상속받는 Manager 클래스 정의
 * - 이름, 연봉, 부서명(depart, 문자열) 멤버변수
 * - 이름, 연봉, 부서명을 문자열로 결합하여 리턴하는 getManager() 메서드
 * 	 e.g. 홍길동, 4000, 개발팀 
 */
class Manager extends Employee {
	String depart; // 부서명
	
	// 파라미터 생성자 생성
	public Manager(String name, int salary, String depart) {
		this.name = name;
		this.salary = salary;
		this.depart = depart;
	}
	
	public String getManager() {
//		return name + ", " + salary + ", " + depart;
		// 슈퍼클래스의 getEmployee() 메서드를 재사용하여
		// 리턴값과 부서명을 결합 후 다시 리턴
		return getEmployee() + ", " + depart;
	}
}