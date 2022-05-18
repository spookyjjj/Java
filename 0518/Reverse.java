//사용자가 입력한 5자리 정수를 역순으로 출력하는 프로그램

import java.util.Scanner;

public class Reverse {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("*5자리* 정수를 입력하시오: ");
		int n = input.nextInt();
		int digit1 = n / 10000;
		int digit2 = (n % 10000) / 1000;
		int digit3 = (n % 1000) / 100;
		int digit4 = (n % 100) / 10;
		int digit5 = n % 10;
		
		System.out.print("역순 출력: ");
		System.out.print(digit5);
		System.out.print(digit4);
		System.out.print(digit3);
		System.out.print(digit2);
		System.out.print(digit1);
	}
}