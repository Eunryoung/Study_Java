package io_1;

import java.io.IOException;
import java.io.InputStream;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 키보드로부터 데이터를 입력받아 처리하는 방법
		 * 2. InputStream 객체를 사용하여 1Byte 단위로 입력 데이터를 처리하지 않고
		 *    배열을 사용하여 한 번에 여러 Byte를 모아서 처리하는 방법
		 * - read(byte[] b) 메서드를 호출하여 입력데이터를 배열 크기만큼 읽어와서 저장
		 * - 아무리 많은 데이터가 입력되어도 배열 크기만큼만 다룰 수 있기 때문에
		 *   더 많은 데이터나 더 큰 단위 처리가 불가능
		 *   => 영문 또는 숫자 등의 데이터 1글자만 처리 가능
		 *   => 한글이나 한자 등 2Byte(char 단위) 문자들은 처리 불가능
		 *   => 읽어 온 데이터를 문자로 변환하는 후속 작업 필요
		 * - 저수준의 입력 방법
		 */
//		System.out.println("데이터를 입력하세요 : ");
//		
//		try(InputStream is = System.in) {
//			// 1Byte 씩 묶음으로 처리할 byte[] 배열을 생성
//			byte[] bArr = new byte[10]; // 10byte 단위로 묶을 경우
//			
//			// read() 메서드 파라미터로 byte[] 배열을 전달
//			// 입력되는 스트림을 자동으로 배열 크기만큼 읽어서 배열에 저장
//			// => 배열에 저장된 데이터 크기(읽어들인 바이트 수)를 리턴
//			int n = is.read(bArr);
//			System.out.println("입력 데이터 크기 : " + n + "바이트");
//			
//			// 반복을 사용하여 변수 b에 저장된 데이터를 출력
//			for(byte b : bArr) {
//				System.out.println("입력데이터 : " + b + ", 문자열로 변환 : " + (char)b);
//			}
//			
//			// String 클래스를 활용하면 byte[] 배열 데이터를 문자열로 변환 가능
//			String str = new String(bArr);
//			System.out.println("입력데이터(문자열) : " + str);
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		// ===============================================================================
		
		System.out.println("데이터를 입력하세요 : (취소 시 Ctrl + Z 입력)");
		

		try(InputStream is = System.in) {
			// 1Byte씩 묶음으로 처리할 byte[] 배열을 생성
			byte[] bArr = new byte[10]; // 10byte 단위로 묶을 경우
			int n = is.read(bArr);
			
			while(n > 0) {
				String str = new String(bArr);
				System.out.println("입력데이터(문자열) : " + str);
				
				n = is.read(bArr);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("입력 작업 종료!");

	}

}
