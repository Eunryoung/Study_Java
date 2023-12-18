package io_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Test5 {

	public static void main(String[] args) {
		/*
		 * 키보드로부터 입력받은 내용을 readme2.txt 파일에 출력
		 * - 여러 줄을 입력 가능하도록 반복 입력 처리
		 * - 단, ":wq" 문자열이 입력되면 입력을 종료
		 */
		
		System.out.println("데이터를 입력하세요. (종료 시 :wq 입력)");
		
		File f = new File("C://temp/readme2.txt");
		
		
		try(BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter out = new PrintWriter(new FileWriter(f))) {
			
			String str = buffer.readLine();
			
			// 입력 문자열이 ":wq"가 아닐 동안 반복
			while(!str.equals(":wq")) {
//			while(str != null) {	// Ctrl + Z 가 종료조건일 경우
				out.println(str);	// 입력데이터 한 줄 출력
				str = buffer.readLine(); // 새로운 한 줄 읽어오기
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
