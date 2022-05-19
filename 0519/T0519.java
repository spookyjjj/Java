//사용자에게 정수 하나를 입력 받아서 입력값 -2 ~ +2 범위의 정수를 출력해보세요
//예) 7 -> 5 6 7 8 9

import java.util.Scanner;

public class T0519_0 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("정수 하나를 입력하세요: ");
		int a = input.nextInt();
		
		a -=2;
		// System.out.println(a);
		// System.out.println(++a);
		// System.out.println(++a);
		// System.out.println(++a);
		// System.out.println(++a);
		
		System.out.printf("%d %d %d %d %d", a, ++a, ++a, ++a, ++a);
		// System.out.printf("%d %d %d %d %d", a++, a++, a++, a++, a);
	}
}