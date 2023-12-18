package collection_framework;

import java.util.LinkedList;
import java.util.Queue;

public class Ex6 {

	public static void main(String[] args) {
		/*
		 * Queue(큐)
		 * - 한 쪽에서 삽입, 반대쪽에서 삭제가 일어나는 구조
		 * - First In First Out(FIFO) 또는 Last In Last Out(LILO) 구조
		 * 	 => 먼저 추가된 요소가 가장 먼저 삭제됨
		 * - Queue 인터페이스를 직접 다루지 않고
		 * 	 Queue 를 상속받아 구현한 LinkedList 클래스 사용
		 *   => LinkedList 클래스는 List 와 Queue 인터페이스를 모두 구현한 구현체
		 * - 은행의 번호표 시스템, 온라인 게임의 대기열 시스템에 사용  
		 */
		
		Queue<String> q = new LinkedList<String>();
		
		// offer() : 데이터 추가
		q.offer("1 - Ex.java");
		q.offer("2 - index.jsp");
		q.offer("3 - 필수.txt");
		System.out.println("모든 Queue 요소 출력 : " + q);
		
		// peek() : 출구의 요소 확인(제거 X)
		System.out.println("가장 먼저 추가된 요소 확인(peek) : " + q.peek());
		System.out.println("가장 먼저 추가된 요소 확인(peek) : " + q.peek());
		
		// poll() : 출구의 요소 꺼내기(제거 O)
		System.out.println("가장 먼저 추가된 요소 꺼내기(poll) : " + q.poll());
		System.out.println("가장 먼저 추가된 요소 꺼내기(poll) : " + q.poll());
		System.out.println("가장 먼저 추가된 요소 꺼내기(poll) : " + q.poll());
		System.out.println("가장 먼저 추가된 요소 꺼내기(poll) : " + q.poll());
		// => 더 이상 꺼낼 요소가 없을 때는 null 값을 리턴
	}

}
