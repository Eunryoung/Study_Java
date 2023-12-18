package java_time_package;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 날짜 및 시각 정보에 대한 형식화(Formatting)
		 * - 날짜 또는 시각 정보를 원하는 형식으로 변환하는 과정
		 * - SimpleDateFormat 클래스와 DateTimeFormatter 클래스 사용
		 *   1) SimpleDateFormat : Date 타입 객체 대한 형식화
		 *   2) DateTimeFormatter : LocalXXX 타입 객체에 대한 형식화
		 *   
		 * < 형식 문자 >
		 * 기호			의미			표현			예
		 * ------------------------------------------------------
		 * y			연도			yyyy, yy		2023, 23 
		 * M			월				MMM, MM			10월, 10
		 * d			일				dd				27
		 * E			요일			EEEE, E			금요일, 금
		 * H			시(24시)		HH				15
		 * K			시(12시)		KK				3
		 * m			분				mm				37
		 * s			초				ss				40
		 * a			오전/오후		a				오전 또는 오후 
		 */
		
		// 1. SimpleDateFormat 클래스 사용
		Date today = new Date();
		System.out.println(today);
		// => 기본 표현 방식으로 출력됨(Fri Oct 27 15:39:26 KST 2023)
		
		// 형식 지정 문자를 사용하여 형식 사용을 위한 패턴 문자열 생성
		String pattern = "yyyy년 MM월 dd일 EEEE";
		
		// SimpleDateFormat 클래스 인스턴스 생성 => 파라미터로 패턴 문자열 전달
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		// SimpleDateFormat 객체의 format() 메서드를 호출하여 Date 객체 전달
		System.out.println(sdf.format(today)); // 결과값을 문자열로 출력하거나
		String formatToday = sdf.format(today); // String 타입 변수에 저장 가능
		System.out.println(formatToday);
		
		pattern = "yyyy/MM/dd(E) a KK:mm:ss";
		SimpleDateFormat sdf2 = new SimpleDateFormat(pattern);
		System.out.println(sdf2.format(today));
		
		System.out.println("==========================================");
		
		// 2. DateTimeFormatter 클래스 사용
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		// DateTimeFormatter 클래스의 ofPattern() 메서드를 호출하여
		// 파라미터로 패턴 문자열 전달
		// => 패턴 문자열은 SimpleDateFormat 클래스와 동일하게 사용
		// => 주의! LocalTime 과 LocalDate 클래스를 사용하는 경우
		//    패턴 문자열이 존재하지 않는 정보를 포함하지 않도록 주의해야 한다!
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		
		// LocalDate 등의 날짜 및 시각 객체의 format() 메서드를 호출하여
		// 파라미터로 DateTimeFormatter 객체 전달
		System.out.println(now.format(dtf));
		

	}

}














