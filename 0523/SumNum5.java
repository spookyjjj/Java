//사용자가 입력한 5개 정수의 합 구하기
import java.util.Scanner;

public class SumNum5{
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		
		int sum = 0;
		System.out.println("더하고자 하는 5개의 정수를 입력해주세요.");
		for(int i = 0; i < 5; i++) {
			int num = input.nextInt();
			sum += num;
		}
		System.out.printf("지정한 정수들의 합은 %d입니다", sum);
	}
}