//사용자가 정수의 범위를 지정(시작~끝), 해당 범위 정수의 합
import java.util.Scanner;

public class SumForUser{
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("정수의 시작범위를 입력해주세요: ");
		int x = input.nextInt();
		System.out.print("정수의 끝범위를 입력해주세요: ");
		int y = input.nextInt();
		
		int sum = 0;
		for (int i = x; i <= y; i++) {
			sum += i;
		}
		System.out.printf("지정한 정수들의 합은 %d입니다", sum);
	}
}