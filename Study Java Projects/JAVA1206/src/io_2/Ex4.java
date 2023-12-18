package io_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * 객체 직렬화(Serialization) & 역직렬화(Deserialization)
		 * - 자바에서 사용하는 객체는 상태(참조 변수 값)가 계속 변하는 영속성(Persistence)을 부여함
		 *   => 객체의 상태는 디스크에 저장될 수 있으며, 동일한 상태를 가지는 객체는 미래 시점에 동일한 지점에서 다시 생성될 수 있다
		 * 	    (어떤 특정한 시점에 참조변수가 가리키고 있는(= 참조하고 있는) 객체를 객체 형태 그대로 뽑아냄(= 값을 기억해둔다))
		 *      c.f. 변수의 직렬화는 메모리 상으로 붙여서 저장하는 개념
		 * - 이 때 어떤 순간의 상태(참조 변수 값)를 파일 또는 네트워크 등으로 내보내는 것을 객체 직렬화라고 하며, 
		 *   반대로 파일이나 네트워크로부터 데이터를 읽어 객체로 변환하는 것을 역직렬화라고 한다
		 * - 직렬화란 인스턴스 내용을 연속 스트림으로 만드는 것이고,
		 *   스트림을 만들어야 파일에 쓸 수도 있고 네트워크로 전송할 수도 있다
		 * - 직렬화 과정을 통해 인스턴스 변수 값을 스트림으로 만들게 된다
		 * - ObjectInputStream, ObjectOutputStream 클래스 사용
		 * - 주의! 직렬화 대상이 되는 클래스를 정의할 때는 반드시 Serializable 인터페이스 상속(구현) 필수!
		 * - 만약, 직렬화 클래스 내에서 출력 대상으로부터 제외시킬 변수가 있을 경우
		 *   해당 변수 선언부 앞에 transient 키워드를 사용하면 출력 대상에서 제외됨
		 * < 직렬화 문법 >
		 * ObjectInputStream(InputStream in)
		 * 
		 * < 역직렬화 문법 >
		 * ObjectOutputStream(OutputStream out)
		 */
		
		// Person 객체 생성
		Person p = new Person("홍길동", 20, "031010-3123456");
		Person p2 = new Person("이순신", 44, "791111-1234567");
		
		// File 경로 관리를 위한 File 객체 생성
		File f = new File("C://temp/Person.txt");
		
		// Person 객체를 외부 파일로 출력하기(= 직렬화, Serialization)
		// => ObjectOutputStream 객체를 생성하여 FileOutputStream 객체 연결
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			oos.writeObject(p);
			oos.writeObject(p2);	
			// 출력 시 글자가 깨어져서 나옴 -> readXXX() 메서드로 읽어야함!

			// Person.txt 파일을 통해 어떤 시점의 객체를 빼둬서 출력
			// 나중에 역직렬화를 통해 값을 가져와 확인할 수 있다
			// 참조변수 p, p2에 해당되는 값은 언제든 바뀔 수 있다
			// => 객체 직렬화는 어떤 시점에 인스턴스를 다루게 되는데
			// 원하는 시점에 p가 가지고 잇는 값을 기록을 해 두는것이다
			// 직렬화는 인스턴스 내용을 연속 스트림으로 만드는 것이므로 객체는 연속으로 저장이 된다
			// 그냥 txt를 보면 알수없는 형태로 되어있지만
			// 안에 있는 내용 (=객체) 를 다시 보려면 역직렬화가 필요
			// objectoutputstream 역직렬화 문법을 통해 내용 확인 가능
		} catch(FileNotFoundException e) {
			// 파일 관련 예외 처리
			e.printStackTrace();
		} catch (IOException e) {
			// 입출력 관련 예외 처리
			e.printStackTrace();
		}
		System.out.println("객체 출력 완료!");
		
		System.out.println("===========================================================================");
		
		// 외부 폴더(C드라이브 - temp - person.txt)에 저장되어 잇느 ㄴ파일 내의
		// Person 객체를 ObjectInputStream 객체를 사용하여 읽어오기
		// => 역직렬화(Deserialization)
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			// ObjectInputStream 객체의 readObject() 메서드를 호출하여
			// 파일에 저장된 객체를 Object 타입으로 읽어오기
			// => 리턴타입이 Object 타입으로 실제 객체 사용을 위해 다운캐스팅 필요
//			Person person = (Person)ois.readObject(); 
			
			Object o = ois.readObject();
			if(o instanceof Person) { // 다운캐스팅 가능 여부 판별
				Person person = (Person)o; // 다운캐스팅
				// toString() 메서드가 오버라이딩 되어 있으므로 변수명 바로 전달
				System.out.println(person);
			}
			
			Person person2 = (Person)ois.readObject();
			System.out.println(person2);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}


// 직렬화를 위한 Person 클래스 정의
// => 주의! 직렬화 대상이 되는 클래스를 정의할 때 반드시 Serializable 인터페이스 상속 필수!(Serializable 인터페이스를 구현하는 구현 객체)
//    별도의 추상메서드가 없는 단순한 마커(Marker) 용도의 인터페이스
class Person implements Serializable { // 추상메서드가 하나도 없어서 오버라이딩할 메서드가 없으므로 에러 발생 X
	
	// 멤버변수 선언
	String name;
	int age;
	transient String jumin; // => transient 키워드 명시할 경우 출력 대상에서 제외
	
	public Person(String name, int age, String jumin) { // 파라미터 생성자 정의
		super();
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}
	
	// toString() 메서드 오버라이딩
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", jumin=" + jumin + "]";
	}
	
	
}