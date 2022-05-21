public class IntegerToString {
	public static void main(String args[]) {
		String strNum = "01234"; //수를 문자화 시킴

		//만약 이름있는 int값을 String으로 넣고 싶을 때?
		
		int a = 12345;
		// String strNum1 = a; //★타입이 맞지 않는다는 컴파일에러 
		// String strNum1 = "a"; // 이름 a가 아닌 그냥 a로 인식됨
		// String strNum1 = (String) a; // 형변환도 안먹힘 int cannot be converted to String

		//해결책1
		System.out.println("~ String.valueOf(이름)이용 ~");
		String strNum2 = String.valueOf(a);
		System.out.println(strNum2.charAt(1));
		System.out.println(strNum2 + a + 100); //1234512345100
		System.out.println(100 + a + strNum2); //1244512345
		System.out.println(strNum2 + (a + 100)); //1234512445
		
		//해결책2
		System.out.println("~ \"\" + 이름 이용 ~");
		String strNum3 = "" + a; 
		System.out.println(strNum3.length());
	}
}