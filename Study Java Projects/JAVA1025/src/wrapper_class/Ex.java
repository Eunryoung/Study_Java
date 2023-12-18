package wrapper_class;

public class Ex {

	public static void main(String[] args) {
		/*
		 * Wrapper 클래스
		 * - 기본 데이터타입을 객체 형태로 관리해주는 클래스의 모음
		 *   => java.lang 패키지에 위치
		 * - 기본 데이터타입과 1:1 로 대응하는 8개의 클래스를 제공
		 *   (Byte, Short, Integer, Long, Float, Double, Boolean, Character)
		 * - Wrapper 클래스에서 제공하는 상수와 메서드 등을 활용하여
		 *   기본 데이터타입 데이터를 다양하게 처리할 수 있음
		 */
		
		System.out.println("byte 타입 메모리 크기(bit) : " + Byte.SIZE); // 8
		System.out.println("byte 타입 메모리 크기(byte) : " + Byte.BYTES); // 1
		System.out.println("byte 타입 최소값 : " + Byte.MIN_VALUE); // -128
		System.out.println("byte 타입 최소값 : " + Byte.MAX_VALUE); // 127
		
		System.out.println();
		
		System.out.println("short 타입 메모리 크기(bit) : " + Short.SIZE); // 16
		System.out.println("short 타입 메모리 크기(byte) : " + Short.BYTES); // 2
		System.out.println("short 타입 최소값 : " + Short.MIN_VALUE); // -32768
		System.out.println("short 타입 최소값 : " + Short.MAX_VALUE); // 32767
		
		System.out.println();
		
		System.out.println("char 타입 메모리 크기(bit) : " + Character.SIZE); // 16
		System.out.println("char 타입 메모리 크기(byte) : " + Character.BYTES); // 2
		System.out.println("char 타입 최소값 : " + (int)Character.MIN_VALUE); // 유니코드로 저장되어있어 int 타입 형변환 필요
		System.out.println("char 타입 최소값 : " + (int)Character.MAX_VALUE); // 유니코드로 저장되어있어 int 타입 형변환 필요
		
		System.out.println();
		
		System.out.println("int 타입 메모리 크기(bit) : " + Integer.SIZE); // 16
		System.out.println("int 타입 메모리 크기(byte) : " + Integer.BYTES); // 2
		System.out.println("int 타입 최소값 : " + Integer.MIN_VALUE); // -32768
		System.out.println("int 타입 최소값 : " + Integer.MAX_VALUE); // 32767
		
		System.out.println();
		
		System.out.println("long 타입 메모리 크기(bit) : " + Long.SIZE); // 64
		System.out.println("long 타입 메모리 크기(byte) : " + Long.BYTES); // 8
		System.out.println("long 타입 최소값 : " + Long.MIN_VALUE); // -9223372036854775808
		System.out.println("long 타입 최소값 : " + Long.MAX_VALUE); // 9223372036854775807
	
		System.out.println();
		
		System.out.println("float 타입 메모리 크기(bit) : " + Float.SIZE); // 32
		System.out.println("float 타입 메모리 크기(byte) : " + Float.BYTES); // 4
		System.out.println("float 타입 최소값 : " + Float.MIN_VALUE); // 1.4E-45
		System.out.println("float 타입 최소값 : " + Float.MAX_VALUE); // 3.4028235E38
		
		System.out.println();
		
		System.out.println("double 타입 메모리 크기(bit) : " + Double.SIZE); // 64
		System.out.println("double 타입 메모리 크기(byte) : " + Double.BYTES); // 8
		System.out.println("double 타입 최소값 : " + Double.MIN_VALUE); // 4.9E-324
		System.out.println("double 타입 최소값 : " + Double.MAX_VALUE); // 1.7976931348623157E308
		
	}

}
