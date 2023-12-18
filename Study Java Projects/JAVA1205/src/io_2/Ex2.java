package io_2;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 모니터로 데이터를 출력하는 방법
		 * 2. OutputStreamWriter 사용(char 단위로 처리)
		 * - write() 메서드를 호출하여 char[] 배열 또는 String 객체를 전달하여
		 *   문자 데이터 출력 가능
		 *   => String 클래스는 char[] 배열로 관리되므로 writer 계열에서 처리 가능
		 * - FileOutputStream
		 *   => 파일에 바이트 단위 자료를 출력하기 위해 사용하는 스트림
		 * - 데코레이션 패턴을 활용하기 위해 BufferedOutputStream 객체 사용 가능
		 *   => 바이트 단위로 출력하는 스트림에 버퍼링 기능을 제공
		 * - BufferedWriter 는 문자 단위로 출력하는 스트림에 버퍼링 기능 제공
		 *   => OutputStreamWriter 보다 BufferedWriter 의 처리속도가 빠르다!
		 */
		
//		try(OutputStreamWriter writer = new OutputStreamWriter(System.out)) { // InputStreamReader에 System.in 넣듯 OutputStreamWriter에 System.out 넣어줌  
//			String str = "Hello, 자바!";
//			writer.write(str);
//			
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		// ==========================================================================================
		// 출력 내용을 파일에 저장
		
		try {
			FileOutputStream fos = new FileOutputStream("C://temp/data.txt");
			// C 경로에 새 폴더 temp 만들고 
			// 우클릭 속성 - 보안 - 편집 - 추가 - everyone 만들고 모든 권한 허용 - 적용 - 확인 
			fos.write(65); // 파라미터로 숫자를 쓰면 해당 아스키 코드 값으로 변환됨
			fos.write(66);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// => catch 항목을 IOException e 로만 처리해도 된다(IOException 안에 FileNotFoundException 포함)
		// => 경로에 자동 생성된 data.txt 파일에 AB가 출력 되어있음!

		System.out.println("출력이 완료되었습니다!");
		
		// ==========================================================================================
		
		
//		try {
//			FileOutputStream fos = new FileOutputStream("C://temp/data.txt");
//			// C 경로에 새 폴더 temp 만들고 
//			// 우클릭 속성 - 보안 - 편집 - 추가 - everyone 만들고 모든 권한 허용 - 적용 - 확인 
//			fos.write(67);
			// => 기존의 AB를 덮어쓰고 새로운 C를 출력
//		} catch(FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		// => 경로에 자동 생성된 data.txt 파일에 기존 출력된 AB는 사라지고 C가 출력 되어있음!(덮어씀)
//		
//		System.out.println("출력이 완료되었습니다!");
		
		// 만약, 기존 자료에 이어서 출력하고 싶으면 생성자의 두 번째 매개변수에
		// true 를 입력
		try {
			FileOutputStream fos = new FileOutputStream("C://temp/data.txt", true);
			fos.write(67);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// => 경로에 자동 생성된 data.txt 파일에 기존 출력된 AB 뒤에 C가 추가되어 ABC 출력
		System.out.println("출력이 완료되었습니다!");
		
		
		// ========================================================================
		
		// 파일에 바이트 배열로 출력하기
		try {
			FileOutputStream fos = new FileOutputStream("C://temp/data2.txt", true);
			byte[] bArr = new byte[26];
			byte data = 65; // 'A'의 아스키 값
			for(int i = 0; i < bArr.length; i++) {
				bArr[i] = data;
				data++;
			}
//			fos.write(bArr);
			// => 배열을 한꺼번에 출력
			// => 대문자 A부터 Z까지 data.txt에 출력
			
			fos.write(bArr, 2, 10);
			// => 배열의 세 번째 위치부터 10개의 바이트 출력
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("출력이 완료되었습니다!");
		
		// ========================================================================
		// BufferedOutputStream 활용
		
		// FileOutputStream
//		FileOutputStream fos = new FileOutputStream("C://temp/data3.txt", true);
	
		// BufferedOutputStream 의 버퍼 크기를 5로 지정한다
//		BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
		
		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C://temp/data3.txt", true), 5)) {
			// 파일 data3.txt에 1부터 9까지 출력한다
//			for(int i = 1; i <= 9; i++) { // 작은따옴표('') 명시하지 않을 경우 글자가 깨어져서 나옴
			for(int i = '1'; i <= '9'; i++) {
				bos.write(i); // 출력
				bos.flush(); // 특정 조건이 맞아 떨어지면 버퍼 안에 있던 걸 강제로 끄집어 냄
//				bos.close(); // 안에 있던걸 비운다
				// => 교재 P. 533 참고!
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("출력이 완료되었습니다!");

		
		// ========================================================================
		// BufferedWriter 활용
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("C://temp/data4.txt", true), 5)) {
			// 파일 data4.txt에 1부터 9까지 출력한다
			for(int i = '1'; i <= '9'; i++) {
				bw.write(i);
				bw.flush();
//				bw.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("출력이 완료되었습니다!");
	}

}
