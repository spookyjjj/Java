public class Swap {
	public static void main(String args[]) {
		int a = 10;
		int b = 55;
		int c = a; //a의 초기값을 담고있는 c를 따로 설정 So, a = b 전에 있어야함!
		
		a = b;
		//b = a; (X) -> 위에서 a값이 b로 바뀌어 버려서 원하는 교환 안 일어남
		b = c;
		
		System.out.println(a);
		System.out.println(b);
	}
}