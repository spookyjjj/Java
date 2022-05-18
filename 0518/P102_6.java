// p102 6

import java.util.Scanner;

public class P102_6 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("500원 동전? ");
		int w500 = input.nextInt();
		System.out.print("100원 동전? ");
		int w100 = input.nextInt();
		System.out.print("50원 동전? ");
		int w50 = input.nextInt();
		System.out.print("10원 동전? ");
		int w10 = input.nextInt();
		
		int sum = (w500 * 500) + (w100 * 100) + (w50 * 50) + (w10 * 10);
		System.out.println("총액: " + sum);
	}
}