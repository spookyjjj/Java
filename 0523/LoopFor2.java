public class LoopFor2{
	public static void main (String args[]) {
		/*
		//for문을 사용하여 10부터 99사이의 정수
		for (int i = 10; i < 100; i++) {
			System.out.println(i);
		}
		*/
		
		//10부터 99사이의 정수 중, 10의 자리 수와 1의 자리 수의 합이 7인 수만 출력
		for (int i = 10; i < 100; i++) {
			if ((i / 10) + (i % 10) == 7) {
			System.out.println(i);
			}
		}
	}
}