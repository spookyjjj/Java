public class StaticVariableAndConst3 {
	public static void printTest(int param) {
		param++;
		System.out.println(param); //3. param의 값은 변화할수있다
	}
	
	public static void main(String args[]) {
		int inner = 10;
		final int TEST_SCOPE = 20;
		//0. 메소드실행
		printTest(TEST_SCOPE); //1. TEST_SCOPE의 값인 20이 ★'just복사'가 되서 int param박스에 담기는것!
		System.out.println("메인에서의 상수값: " + TEST_SCOPE); //2. 그래서 TEST_SCOPE값은 여전히 20이고
	}
}