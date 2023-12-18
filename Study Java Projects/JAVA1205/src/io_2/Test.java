package io_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Test {

	public static void main(String[] args) {
		/*
		 * 데이터를 입력하면 입력된 데이터를 출력하는 프로그램을 만들어보자
		 * 입력 스트림에서 데이터(문자열)을 읽어서 출력 스트림을 통해 입력스트림 데이터를 출력한다.
		 * e.g. 입력 문자열 : 아이티윌
		 * 	    화면에 출력되는 형태 : 입력한 데이터는 아이티윌 입니다. 
		 */
		
		//  BufferedReader 를 사용하여 입력받은 문자열을 OutputStream 을 사용하여 출력
		
		// 1. 기본 입력스트림 객체(InputStream) 생성 = byte 단위 처리
//		InputStream is = System.in;
		
		// 2. 입력스트림을 연결하는 보조스트림 InputStreamReader 객체 생성 = char 단위 처리
//		InputStreamReader reader = new InputStreamReader(is);
		
		// 3. 향상된 입력 보조스트림 BufferedReader 객체 생성 = String 단위 처리
//		BufferedReader buffer = new BufferedReader(reader);
		
		// ------------------------------------ 위 세 문장을 하나의 문장으로 결합 -------------------------------------
//		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		// try with resources 구문 작성
		// => try() 문장 소괄호 내에 복수 개의 객체를 세미콜론(;)으로 구분하여 전달 가능
		
		try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
				OutputStream os = System.out) {
			System.out.println("데이터를 입력하세요 : ");
			
			// 입력스트림에서 ㅎ나 줄의 데이터(문자열) 읽어오기
			String str = buffer.readLine();
			System.out.print("입력한 데이터는 ");
			
			// 출력 스트림을 통해 입력 데이터를 출력
			os.write(str.getBytes());
			
			System.out.println(" 입니다.\n");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
				
		
		
		
		// 내 코드
//		System.out.println("데이터를 입력하세요 : ");
//		String str = "";
//		
//		try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
//			str = buffer.readLine();
//			System.out.println("입력데이터 : " + str);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		try(OutputStream os = System.out) {
//			os.write(str.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
	}

}
