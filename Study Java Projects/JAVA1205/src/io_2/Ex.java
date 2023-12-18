package io_2;

import java.io.IOException;
import java.io.OutputStream;

public class Ex {

	public static void main(String[] args) {
		/*
		 * 모니터로 데이터를 출력하는 방법
		 * 1. 기본 출력스트림인 OutputStream 사용(byte 단위로 처리)
		 * - write() 메서드를 호출하여 byte 단위 출력
		 * - byte 단위로 처리되므로 문자열 데이터 자체를 처리할 수 없음
		 */
		
		// OutputStream 객체를 연결하기 위해서는 System.out 사용
//		OutputStream os = System.out;
		
//		char ch = 'A';
//		char ch = '강'; // 출력되지 않음
		
//		os.write(ch);
		// => Surround with try/catch 처리
		
//		try(OutputStream os = System.out) {
//			// write() 메서드를 호출하여 1byte 데이터를 출력
//			os.write(ch); // 1byte 단위로 출력하므로 한글, 한자 등 출력 불가능
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// ==================================================================
		// String 타입 데이터(문자열)를 OutputStream 으로 출력
		String str = "Hello, 자바!";
		try(OutputStream os = System.out) {
			// => try ~ with resources 구문
			// => try 문의 소괄호() 내부에 예외처리가 필요한 객체의 생성 코드를 작성
			// => 별도의 close() 메서드를 호출하지 않아도 자동으로 자원이 반환됨
			
			// write(byte[] b) 메서드를 호출하여 출력할 데이터를 배열로 전달
			// => byte 타입의 배열을 매개변수로 가지는 메서드 호출
			os.write(str.getBytes()); // getBytes() 메서드는 리턴 타입은 byte 타입의 배열 
			// => 한글, 한자 등의 문자열도 출력 가능
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
