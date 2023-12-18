package io_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 키보드로부터 데이터를 입력받아 처리하는 방법
		 * 3. InputStreamReader 객체를 사용하여 char 단위로 입력데이터를 처리하는 방법
		 * - InputStream 객체를 파라미터로 갖는 InputStreamReader 객체 생성
		 *   => 보조스트림을 사용하는 스트림 체이닝(Stream Chaining) 방식의 문법 구성
		 * - read() 메서드를 호출하여 입력데이터를 char단위(2Byte) 만큼 읽어와서 저장
		 * - 아무리 많은 데이터가 입력되어도 2Byte(char)만큼만 다룰 수 있기 때문에
		 *   더 많은 데이터나 더 큰 단위 처리가 불가능
		 *   => 영문 또는 숫자 등의 데이터 1글자(1Byte) 처리 가능 
		 *   => 한글이나 한자 등 2Byte(char 단위) 문자도 처리 가능(1글자)
		 *   => 읽어온 데이터를 문자로 변환하는 후속 작업 필요
		 * - InputStream 보다는 유용하지만, 여전히 낮은 수준의 입력 처리 방식
		 * 
		 * < 기본 문법 >
		 * InputStreamReader reader = new InputStreamReader(InputStream 객체); // new 키워드로 객체 생성, 파라미터로 InputStream 객체
		 *  
		 */
		
		// 1. System.in 을 사용하여 입력스트림 객체 생성(가져오기)
//		InputStream is = System.in;
		
		// 2. InputStreamReader 객체를 생성 => 파라미터로 InputStream 객체 전달
//		InputStreamReader reader = new InputStreamReader(is);
		
		// ----------------------------- 위의 문법을 한 문장으로 결합 -----------------------------
//		InputStreamReader reader = new InputStreamReader(System.in);
		
//		System.out.println("데이터를 입력하세요 : ");
//		
//		try(InputStreamReader reader = new InputStreamReader(System.in)) { 
//			// 이 입력 스트림에 대해 자동으로 finally 없이 자원 반환되도록 try with resources 구문 사용
//			// InputStreamReader 객체의 read() 메서드를 호출하여 char 단위 읽어오기
//			int n = reader.read(); // char 단위 데이터 1개(1개 문자)를 int형으로 리턴
//			System.out.println("입력된 데이터 : " + n + ", 문자로 변환 : " + (char)n);
//			// InputStreamReader => 2Byte 단위 출력이라 한글도 제대로 출력됨
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// ================================================================
		
		System.out.println("데이터를 입력하세요 : ");
		
		try(InputStreamReader reader = new InputStreamReader(System.in)) { 
			// InputStreamReader 객체의 read() 메서드를 호출하여 char 단위 읽어오기
			int n = reader.read(); // char 단위 데이터 1개(1개 문자)를 int형으로 리턴
			
			while(n != -1) {
				System.out.println("입력된 데이터 : " + n + ", 문자로 변환 : " + (char)n);
				n = reader.read();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
