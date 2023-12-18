package final_test;

public class Test1 {

	public static void main(String[] args) {
		int pee = 50000;
		int age = 14;
		
		if(age < 5 || age >= 65) {
			pee *= 0.5;
			System.out.println("나이가 " + age + "세이므로 입장료는 " + pee + "원입니다.");
		} else if(age >= 5 && age <= 19) {
			pee *= 0.7;
			System.out.println("나이가 " + age + "세이므로 입장료는 " + pee + "원입니다.");
		} else {
			System.out.println("나이가 " + age + "세이므로 입장료는 " + pee + "원입니다.");
		}
	}

}
