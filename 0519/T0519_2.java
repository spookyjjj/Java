//사용자가 입력한 정수가 짝수면 true, 홀수면 false를 출력하시오

import java.util.Scanner;

public class T0519_2 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("정수를 입력하시오: ");
		int x = input.nextInt();
		
		System.out.println("짝수인가요? " + ((x % 2) == 0));
		// boolean result = ((x % 2) == 0);
		// System.out.println("짝수인가요? " + result);
	}
}