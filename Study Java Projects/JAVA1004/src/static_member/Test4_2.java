package static_member;

public class Test4_2 {

	public static void main(String[] args) {
		/*
		 * 카드 회사에서 카드를 발급할 때마다 카드 고유 번호를 부여해줍니다.
		 * 카드가 생성될 때마다 카드 번호가 자동으로 증가할 수 있도록 
		 * 카드 클래스를 만들고 생성해보세요.
		 * 
		 * 1. CardCompany 클래스 생성
		 *    - 멤버변수 : cardSerialNum(카드 고유번호)
		 *    - createCard() 메서드 생성 : 파라미터, 리턴값 있음
		 * 2. Card 클래스 생성
		 *    - 멤버변수 : cardNum(카드 번호), cardName(카드 이름)
		 * 
		 * Card 클래스를 생성하고 cardNum 을 출력하면 1씩 증가하는 값을
		 * 출력할 수 있음.
		 */
		
		CardCompany cardCompany = CardCompany.getInstance(); 
		// => 리턴받은 인스턴스 주소값을 CardCompany 클래스 타입 참조변수 cardCompany에 저장
		// => CardCompany 클래스 타입의 변수로 양변을 맞춰줘서 type mismatch 뜨지않도록한다
		
		Card card = new Card();
		card.cardName = cardCompany.createCard("현대 Zero 카드");
		
		Card card2 = new Card();
		card2.cardName = cardCompany.createCard("현대 M 카드");
		
		System.out.println("카드 고유 번호 : " + card.cardNum); 
		// static 처리가 되어있는 변수(공용으로 사용하는 변수)이므로 10000-> 10001로 값 변경 됨
		System.out.println("카드 이름 : " + card.cardName);
		
		System.out.println("카드 고유 번호 : " + card2.cardNum); 
		// static 처리가 되어있는 변수(공용으로 사용하는 변수)이므로 10001-> 10002로 값 변경 됨
		System.out.println("카드 이름 : " + card2.cardName);
		
	}

}

class CardCompany {
	static int cardSerialNum = 10000; 
	// static을 붙여서 카드가 만들어질때마다 변경된 고유 번호가 되도록!
	// 고유한 번호여야 하므로 static 명시(카드번호, 학번 등에 사용됨)
	
	public String createCard(String cardName) {
		return cardName;
	}
	
	// ===================== 싱글톤 디자인 패턴 적용 ====================
	
	// 1. 기본 생성자 정의 => 외부에서 새로운 인스턴스를 만들지 못하도록(싱글톤 디자인) private 명시
	private CardCompany() {} // 카드 회사를 고유하게 만듦
	
	// 2. 자신의 인스턴스를 생성하여 자신의 클래스 타입 변수 instance 에 저장
	//	  => private static 선언	
	//	  => 기본 생성자가 private이므로 static 명시해 
	//       외부에서 클래스명.멤버변수명으로 인스턴스 주소를 가져올 수 있다(접근 가능하게 됨)
	// 	  => 그러나 CardCompany 클래스로부터 리턴받은 인스턴스를 통해 
	//    클래스 내의 CardCompany 타입 변수 instance에 접근이 가능하므로 
	//    해당 변수의 값을 변경할 우려가 있음!(e.g. CardCompany.instance = null;) => private 명시
	private static CardCompany instance = new CardCompany();
	// => 값을 마음대로 바꾸지 못하게 private도 명시 => 접근을 못하게 됨 => Getter 정의 시 public static 선언	
	
	// 3. Getter 정의 => public static 선언 : 누구나 다 접근 가능한 메서드로 만듦
	public static CardCompany getInstance() { // 리턴타입이 기본 데이터타입이 아닌 CardCompany 클래스 타입임
		return instance; // 인스턴스 주소값 리턴
	}
	
}

class Card {
	int cardNum = 0;
	String cardName = null;
	
	public Card() {
		CardCompany.cardSerialNum += 1; // cardSerialNum이 static 변수이므로 클래스명.변수명으로 접근 가능
		cardNum = CardCompany.cardSerialNum;
	}
}














