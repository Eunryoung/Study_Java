package collection_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 2. List 계열
		 * - 저장 데이터의 순서 유지 O, 중복 허용 O
		 * - 저장되는 데이터는 저장 시점에서 자동으로 인덱스가 부여됨
		 * 	 => 배열과 동일하게 인덱스 번호가 0번부터 시작됨
		 * - 기본적인 메서드 대부분 Set 계열과 동일(= 부모가 동일하므로)
		 * 	 => 단, 인덱스를 활용하는 메서드가 많음
		 * - 대표적인 구현체 클래스 : ArrayList, Vector, LinkedList 등
		 * - Collection 클래스의 메서드를 통해 List 객체의 부가적인 처리 가능
		 * 	 (sort 및 shuffle 기능 등 제공)
		 */
		
		List<Integer> list = new ArrayList<Integer>();
		// => ArrayList 객체에 저장되는 데이터를 정수형으로 고정
		
		list.add(1);
		list.add(2);
		list.add(3);
//		list.add(3.14); // 제네릭 타입 고정으로 인해 정수 외에 추가 불가
		
		System.out.println("list 객체가 비어있는가? " + list.isEmpty()); // false
		System.out.println("list 객체에 저장된 요소 개수 : " + list.size()); // 3
		System.out.println("list 객체에 저장된 모든 요소 : " + list); // [1, 2, 3]
		
		System.out.println("중복 데이터 3 추가 가능한가? " + list.add(3)); // true
		System.out.println("list 객체에 저장된 모든 요소 : " + list); // [1, 2, 3, 3]
		// => Set 객체는 중복 데이터 추가 불가능!(list는 인덱스가 있어서 가능!)
		
		// Object get(int index) : index 에 해당하는 요소 리턴
		// => 단, 제네릭 타입을 Integer로 지정했으므로 리턴타입 Integer
		System.out.println("1번 인덱스에 저장된 요소 : " + list.get(1));
		// 배열과 마찬가지로 존재하지 않는 인덱스 지정할 경우 
		// IndexOutOfBoundsException 예외 발생
//		System.out.println("4번 인덱스에 저장된 요소 : " + list.get(4));
		
		// int indexOf(Object o) : 특정 요소가 위치한 인덱스 리턴(앞에서부터 탐색)
		System.out.println("정수 3의 인덱스 : " + list.indexOf(3));
		// int lastIndexOf(Object o) : 특정 요소가 위치한 인덱스 리턴(뒤에서부터 탐색)
		System.out.println("정수 3의 인덱스 : " + list.lastIndexOf(3));
		
		// Object remove(int index) : index에 해당하는 요소 삭제 후 요소 리턴
		// => 제네릭 타입에 따라 리턴타입 변함
		// => 주의! 요소가 정수 타입일 경우 정수 데이터를 지정하면
		// 	  정수 데이터가 아닌 인덱스로 취급되므로
		//	  정수형 요소를 지정해야하는 경우 Object 타입으로 변환 필요
//		System.out.println("정수 2 삭제 : " + list.remove(2));
//		System.out.println("list 객체에 저장된 모든 요소 : " + list); // [1, 2, 3]
		// => 2번 인덱스로 지정되어서 정수 2가 아닌 인덱스의 정수 3 삭제됨
		// => 파라미터로 인덱스 번호를 받으므로 인덱스 번호가 2인 정수 3이 삭제됨
		
//		System.out.println("정수 2 삭제 : " + list.remove( (Object)2 ));
//		System.out.println("list 객체에 저장된 모든 요소 : " + list); // [1, 3]
		// => remove() 메서드의 파라미터 종류는 int 타입(인덱스)과 Object 타입 두가지가 존재
		// 	  정수형 요소를 지정해야 하는 경우에는 int index를 선택하는 것이 아니라
		//	  Object 타입으로 형변환을 시켜줘야한다!
		
		// 	  또는, 보통 요소를 삭제해야할 경우 indexOf()로 탐색된 인덱스 요소 삭제
		// 	  => indexOf() 메서드의 파라미터는 Object 타입이기 때문!
		list.remove(list.indexOf(2));
		System.out.println("list 객체에 저장된 모든 요소 : " + list); // [1, 3, 3]
		
		// add(int index, Object o) : 특정 인덱스에 해당 요소(o)를 추가
		// => 기존 데이터는 뒤로 밀려남
		list.add(1, 5); // 1번 인덱스에 5 추가(기존 1번 인덱스 데이터부터 뒤로 밀림)
		System.out.println("list 객체에 저장된 모든 요소 : " + list); // [1, 5, 3, 3]
		
		// set(int index, Object o) : 특정 인덱스에 해당요소(o)를 덮어씀
		list.set(1, 10); // 1번 인덱스에 10 추가(기존 1번 인덱스 데이터 덮어씀)
		System.out.println("list 객체에 저장된 모든 요소 : " + list); // [1, 10, 3, 3]
		
		// List subList(int beginIndex, int endIndex)
		// => beginIndex 부터 endIndex - 1 까지의 부분을 리스트로 추출
		List subList = list.subList(1, 3); // 1 ~ 3-1 까지 추출
		System.out.println("추출된 부분 리스트 : " + subList); // [10, 3] => 1, 2번 인덱스의 데이터!
		
		System.out.println("==============================================================");
		
		// Collections 클래스를 활용(static 메서드 제공)
		List list2 = new ArrayList();
		list2.addAll(list); // list의 모든 요소를 list2에 추가
		list2.add(20);
		list2.add(8);
		list2.add(85);
		list2.add(50);
		System.out.println("정렬 전 : " + list2); // [1, 10, 3, 3, 20, 8, 85, 50]
		
		// Collections.sort(List) : List 객체 정렬(같은 타입 요소만 가능)
		Collections.sort(list2);
		System.out.println("정렬 후 : " + list2); // [1, 3, 3, 8, 10, 20, 50, 85] => 오름차순 정렬됨
		
		// Collections.shuffle(List) : List 객체 무작위 섞기(타입 무관)
		// => 실행할 때마다 셔플 결과는 달라짐
		list2.add("888"); // 다른 데이터타입도 셔플 가능함
		Collections.shuffle(list2);
		System.out.println("셔플 후 : " + list2); 
		
		System.out.println("=======================================================");
		
		// Arrays 클래스의 static 메서드인 asList() 메서드를 사용하면
		// 배열 -> List 객체로 쉽게 변환 가능
//		String[] names = {"홍길동", "이순신", "강감찬"};
//		List namesList = Arrays.asList(names);
		
		// asList() 메서드 파라미터로 가변인자가 사용되므로
		// 데이터를 직접 여러개 전달 가능하며, 배열로 자동으로 변환되어 전달됨
		List namesList = Arrays.asList("홍길동", "이순신", "강감찬");
		System.out.println(namesList);
		
		
		
	}

}
