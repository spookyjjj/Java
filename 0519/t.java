//사용자가 입력한 두 정수의 합을 출력하고, 합이 0이면 true 그렇지 않은 경우 false를 출력하시오.

import java.util.Scanner;

public class T0519_1 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("1번 정수를 입력하시오: ");
		int x = input.nextInt();
		System.out.print("2번 정수를 입력하시오: ");
		int y = input.nextInt();
		
		System.out.print("두 수의 합: " + (x + y));
		System.out.print("두 수의 합이 0인가요? " + ((x + y) = 0));
	}
}
