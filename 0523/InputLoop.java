//사용자가 원하는 반복만큼만 0부터 1씩 증가하는 수를 출력.

import java.util.Scanner;

public class InputLoop{
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("원하는 반복 횟수를 입력하시오: ");
		int num = input.nextInt();
		
		int i = 0;
		while (i < num) { //1번 반복이면 <1, 2번 반복이면 <2 ... 10번 반복이면 <10
			System.out.println(i);
			i++;
		}
	}
}