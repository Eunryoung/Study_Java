package while_;

public class 연습 {

	public static void main(String[] args) {
		int total = 0;
		int x;
		for(x = 1; x <= 100; x++) {
			total += x;
			if(total > 1000) {
				break;
			}
			
		}
		
		System.out.println("1 ~ " + x + "까지의 정수의 합 = " + total);
		System.out.println("합계가 1000보다 클 때의 x = " + x);
		
		x = 1;
		total = 0;
		while(true) {
			if(x % 2 == 0) {
				System.out.println(-x);
				total = total + -x;
			} else {
				System.out.println(x);
				total += x;
			}
			if(total >= 100) {
				break;
			}
			x++;
		}
		System.out.println();
		System.out.println("x = " + x);
		System.out.println("total = " + total);
		
//		while(total < 100) {
//			if(x % 2 == 0) {
//				System.out.println(-x);
//				total = total + -x;
//			} else {
//				System.out.println(x);
//				total += x;
//			}
//			x++;
//		}
		
		
	}

}
