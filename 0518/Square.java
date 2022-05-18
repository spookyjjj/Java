//사용자에게 정수 하나를 입력받아서 제곱 값을 출력하는 프로그램

import java.util.Scanner;

public class Square {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
				
		System.out.print("제곱할 값을 입력하시오: ");
		int x = scan.nextInt(); 
			
		System.out.println("제곱값: " + (x * x));
	}
}