public class Sum{
	public static void main (String args[]) {
		//for문을 이용하여, 0 ~ 100 범위의 정수의 합
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i; //sum = sum + i;
		}
		System.out.println(sum);
		
		////for문을 이용하여, 100~200 사이의 짝수의 합
		int evensum = 0;
		for (int i = 100; i <= 200; i += 2) {
			evensum += i;
		}
		System.out.println(evensum);
	}
}