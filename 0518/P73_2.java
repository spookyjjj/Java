// p73 2

import java.util.Scanner;

public class P73_2 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("받은 돈: ");
		int inmoney = input.nextInt();
		System.out.print("상품의 총액: ");
		int price = input.nextInt();
		
		System.out.println("부가세: " + (int)(price * 0.1));
		System.out.println("잔돈: " + (inmoney - price));
	}
}