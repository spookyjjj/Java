public class TestMethod3 {
	public static int getSum(int a, int b) { //파라미터(parameters) : 메소드의 입력부분 -> 개수, 타입, 순서
		return a + b;
	}
	
	public static int getMultiple(int a, int b) {
		return a * b;
	}
	
	public static void main(String args[]) {
		//System.out.println(a); //파라미터에 선언한것도 결국 지역변수라서 인식 못함
		System.out.println(getSum(30, 60)); //파라미터에 약속한대로, int정수 2개 입력 가능
		System.out.println(getSum(100, 80));
		
		System.out.println(getMultiple(30, 60));
		System.out.println(getMultiple(100, 80));
	}
}