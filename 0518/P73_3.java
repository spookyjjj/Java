// p73 3

import java.util.Scanner;

public class P73_3 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("반지름을 입력하시오: ");
		double radius = input.nextDouble();
		
		double vol = (4 * radius * radius * radius) / 3;
		
		System.out.println("부피: " + vol);
	}
}