//사용자가 원하는 단수를 입력받아 구구단 출력하기

import java.util.Scanner;

public class Gugudan {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("원하는 단수를 입력하세요: ");
		int gugu = input.nextInt();
		
		int i = 1;
		while (i <= 9) {
			System.out.printf("%d * %d = %d\n", gugu, i, i * gugu);
			i++;
		}
	}
}