// p73 1

import java.util.Scanner;

public class P73_1 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("마일을 입력하시오: ");
		double mile = input.nextDouble();
		double km = mile * 1.609;
		System.out.println(mile + "마일은 " + km + "킬로미터입니다.");
	}
}