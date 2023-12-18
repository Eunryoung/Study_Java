package String;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * 2. subString() 메서드 활용
		 * 문자열에 포함된 내용(주소) 중에서 실제 주소 부분만 추출하여 출력
		 * - 입력 형식 : "Address:주소..."
		 *   ex) "Address:부산광역시 부산진구 동천로 109 삼한골든게이트"
		 * - 출력 형식 : "Address:" 부분을 제외한 나머지 주소만 추출하여 출력
		 *   => "부산광역시 부산진구 동천로 109 삼한골든게이트" 출력
		 */
		
		String address = "Address:부산광역시 부산진구 동천로 109 삼한골든게이트";
		System.out.println("주소 : " + address.substring(8));
		
		/*
		 * 3. split() 메서드 활용
		 * 문자열에 포함된 정보를 특정 기준 문자열(구분자)을 기준으로 분리하여
		 * 항목별로 출력
		 */
		
		String address2 = 
				"Address:부산광역시 부산진구 동천로 109,Floor:7층,Tel:051-803-0909";
		
		// 1. 콤마(,)를 기준으로 각 항목 분리
		// => 분리된 문자열은 String[] 배열로 저장
		String[] strArr = address2.split(",");
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		System.out.println("------------------------------------------");
		
		// 2. 1번의 결과에서 콜론(:)을 기준으로 항목명과 항목 내용을 분리하여
		//    내용 부분(주소, 층, 전화번호)만 출력
		//    e.g. 부산광역시 부산진구 동천로 109, 7층, 051-803-0909 출력
		
		// strArr[0] = "Address:부산광역시 부산진구 동천로 109"
//		String[] strArr2 = strArr[0].split(":");
		// strArr2[0] = Address, strArr2[1] = 부산광역시 부산진구 동천로 109
//		System.out.println(strArr2[1]);
		
		// strArr[1] = "Floor:7층"
//		strArr2 = strArr[1].split(":");
		// strArr3[0] = Floor, strArr3[1] = 7층
//		System.out.println(strArr2[1]);
		
		for(int i = 0; i < strArr.length; i++) {
//			System.out.println(strArr[i]);
			
			String[] strArr2 = strArr[i].split(":");
			// => 분리된 문자열의 1번 인덱스가 실제 데이터이므로
//			System.out.print(strArr2[1] + " "); // 1번 인덱스 데이터를 반복 출력
			
			// 분리된 결과를 별도의 배열에 저장하지 않고
			// 1번 인덱스 데이터를 바로 출력 가능
			// => 1회성으로 접근 후 제거해도 무관할 경우 사용
			System.out.println(strArr[i].split(":")[1]);
			// => 분리된 결과의 1번 인덱스 문자열을 출력
		}
		
	} 

} 
