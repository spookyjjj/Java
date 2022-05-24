public class LoopFor2{
	public static void main (String args[]) {
		//for문을 사용하여 1부터 10까지 출력하기
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		//for문을 사용하여 21부터 30까지 3의배수 출력하기
		for (int i = 21; i <= 30; i += 3) {
			System.out.println(i);
		}
		
		//for문을 사용하여 30 29 28 ... 20 까지 역순 출력하기
		for (int i = 30; i >= 20; i--) {
			System.out.println(i);
		}
		
		//10부터 99사이의 정수 중, 10의 자리 수와 1의 자리 수의 합이 7인 수만 출력
		for (int i = 10; i < 100; i++) {
			if ((i / 10) + (i % 10) == 7) {
			System.out.println(i);
			}
		}
	}
}