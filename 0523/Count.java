public class Count{
	public static void main (String args[]) {
		// 300~400사이의 정수 중, 13의 배수를 찾아 몇 개인지 출력
		int count = 0;
		for (int i = 300; i <= 400; i++) {
			if (i % 13 == 0) {
			System.out.println("확인: " + i);
			count++;
			}
		}
		System.out.println(count);
	}
}