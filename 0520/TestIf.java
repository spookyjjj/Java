public class TestIf {
	public static void main(String args[]) {
		/*
		if ( 조건식(=논리값) ) {
			true일땐 중괄호 안도 해석 	->then절
		}
		false일때는 중괄호를 건너띄고 해석 여기부터 해석시작
		*/
		
		boolean condition = false;
		if (condition) {
			System.out.println("조건문 블록 안 입니다.");
		}
		System.out.println("프로그램 종료");
	}
}