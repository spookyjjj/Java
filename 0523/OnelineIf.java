public class OnelineIf {
	public static void main (String args[]) {
		boolean con = true;
		
		if (con) //{ ★한 문장일 경우, 중괄호 생략가능~!
			System.out.println("참일 경우 실행할 문장");
		//} 
		else //{ ★한 문장일 경우, 중괄호 생략가능~!
			System.out.println("거짓일 경우 실행할 문장");
		//}
		
		//즉, if (con) System.out.println("참일 경우"); System.out.println("거짓일 경우");
		//이렇게 다 같이 한 줄로 표현가능~
		
		System.out.println("프로그램 종료");
		
		
		boolean con2 = false;
		
		String result = (con2) ? "참" : "거짓"; // (불연값) ?삼항연산자 참:거짓 -> if-else문을 짧게 줄여쓰기~!
		System.out.println(result);
		
		System.out.println("프로그램 종료");
	}
}