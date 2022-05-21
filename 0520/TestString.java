public class TestString {
	public static void main(String args[]) {
		String str; //참조형은 기본형과 달리 대문자로 시작한다. 클래스를 불러오는 것이기 때문
		str = "Hello World";
		System.out.println(str);
		
		String s2 = "다음 문자열";
		System.out.println(s2);
		
		String concat = str + s2; //문자열끼리 합연산도 가능~
		System.out.println(concat);
		
		System.out.println(str + 1 + 5 + "\n" + true + s2 + 3.0); //★문자열 변수 뒤로는 다 문자열 취급!!
		System.out.println(1 + 5 + str + false + s2 + 3.0); //연산 후에 문자열 변수 등장
		System.out.println(str + (1 + 5) + "\n" + null + s2 + 3.0); //중간에 있지만 int계산부터 하고싶다면 괄호 묶기
		System.out.println("str + (1 + 5) + \n + true + s2 + 3.0"); //그냥 전부다 문자열로 나옴
		/*
		System.out.println(str + (1 + 5) + \n + noname + s2 + 3.0); 
		nonam은 변수이름으로 설정되지 않았기에 안됨. 그럼 true는? 
		★true는 1이나 5, 3.0처럼 하나의 값 취급임~! false나 null도 마찬가지
		*/
	}
}