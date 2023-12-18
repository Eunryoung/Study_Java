package io_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ex5 {

	public static void main(String[] args) {
		/*
		 * 키보드로부터 입력받은 데이터를 파일로 출력
		 * 1. 키보드로부터 입력받기
		 * 1) System.in을 통해 키보드로부터 입력받는 입력스트림 InputStream 객체로 연결
		 *    => byte 단위로 처리
		 * 2) InputStream -> InputStreamReader 객체로 변환하여 char 단위로 처리
		 * 3) InputStreamReader -> BufferedReader 객체로 변환하여 String 단위로 처리
		 * 4) BufferedReader 객체로부터 입력스트림 한줄(Line) 단위로 읽어와서 출력
		 * 
		 * 2. 파일로 출력하기
		 * 1) File 객체를 사용하여 출력할 파일 위치 및 이름을 지정
		 * 2) FileWriter 객체를 사용하여 char 단위로 처리(File 객체 전달)
		 * 3) FileWriter -> PrintWriter 객체로 변환하여 출력
		 */
		
		// 키보드로부터 데이터 입력받기
//		InputStream is = System.in;
//		InputStreamReader reader = new InputStreamReader(is);
//		BufferedReader buffer = new BufferedReader(reader);
		
		// 위의 세 문장을 한 줄로 표현하면
//		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		// 또는 Scanner 클래스를 사용해 표현하면
		// Scanner sc = new Scanner(System.in);
		
		
		// 파일로 출력하기
		File f = new File("C://temp/readme.txt");
//		FileWriter fw = new FileWriter(f);
//		PrintWriter pw = new PrintWriter(fw);
		
		// 위의 세 문장을 한 줄로 표현하면
//		PrintWriter pw = new PrintWriter(new FileWriter(f));
		
		System.out.println("입력하세요 : ");
		
		try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(new FileWriter(f))) {
			String str = buffer.readLine();
			pw.println(str);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
