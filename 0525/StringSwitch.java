public class StringSwitch {
	public static void main (String args[]) {
		String month = "February";
		
		int monthNumber;
		switch (month) {
			case "january": //if와 달리 switch에서 문자열 값의 동등은 .equals()를 안쓰고 ""씀. 최신형이라~ㅎㅎ
				monthNumber = 1;
				break;
			case "February":
				monthNumber = 2;
				//int b = 100; -> ★여기서도 지역변수 주의
				break;
			case "March":
				monthNumber = 3;
				//System.out.println(b); -> b를 인식은 하지만, 초기화 되지 않을 수 있다는 에러
				break;
			default:
				monthNumber = 0;
				break;
		}
		System.out.println(monthNumber);
		//System.out.println(b); -> switch{}안에서 선언된 b라서 찾지못함
	}
}