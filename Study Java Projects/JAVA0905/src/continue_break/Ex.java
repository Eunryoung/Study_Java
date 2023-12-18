package continue_break;

public class Ex {

	public static void main(String[] args) {
		/*
		 * break 문과 continue 문
		 * - 반복문 내에서 특정 조건식과 결합하여
		 *   반복문의 실행 흐름을 제어하는 용도로 사용
		 *   
		 * 1. break 문
		 * - 반복문 내에서 조건식에 따라 반복문을 종료하는 용도로 사용
		 *   주로 if문과 조합하여 반복문을 빠져나갈 조건을 설정
		 *   
		 * < 기본 문법 >
		 * for(초기식; 조건식; 증감식) 또는 while(조건식) {
		 * 		if(조건) {
		 * 			break; // 현재 소속된 반복문의 블록문을 빠져나감(종료)
		 * 		}
		 * }  
		 */
		
		int i;
		
		for(i = 1; i <= 10; i++) {
			System.out.println(i);
			
			// i 값이 5 일 때 for문을 빠져나감			
			if(i == 5) {
				System.out.println("i = 5 이므로 for문을 종료!");
				break;
			}
		}
		
		System.out.println("for문 종료 후 i 값 = " + i);
		
		System.out.println("========================================================");
		
		i = 1; // 초기식
		
		while(i <= 10) { // 조건식
			System.out.println(i);
			
			// i값이 5 일 때 while문을 빠져나감
			if(i == 5) {
				System.out.println("i = 5 이므로 while문을 종료!");
				break;
			}
			
			i++;
		}
		
		System.out.println("while문 종료 후 i 값 = " + i);
		
		/*
		 * 2. continue 문
		 * - 반복문 내에서 조건식에 따라 반복문의 다음 문장 실행을 생략하고
		 *   다음 반복을 진행하는 용도 사용
		 * 
		 * < 기본 문법 >
		 * for(초기식; 조건식; 증감식) 또는 while(조건식) {
		 * 		if(조건식) {
		 * 			continue;
		 * 			// 현재 반복문의 continue 문 아래쪽 문장 실행을 생략하고
		 *			// 다음 반복 실행을 위해 for문의 증감식 또는
		 *			// while 문의 조건식으로 이동
		 * 		}
		 * 
		 * 		문장 X; // continue 문에 의해 실행이 생략되는 문장
		 * 
		 * }
		 */
		
		for(i = 1; i <= 10; i++) {
		
			// i 값이 5 일 때 출력문 실행을 생략하고 다음 반복을 실행
			if(i == 5) {
				System.out.println("i = 5 이므로 출력문 실행을 생략!");
				continue;
			}
			System.out.println(i); // i 값이 5 일 때 출력문이 실행되지 못함
		}
		
		
	}

}
