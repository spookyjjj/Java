//사용자가 입력할 정수의 갯수를 먼저 정한 후, 그만큼의 정수를 입력하면 그들의 합과 평균 구하기

//입력한 수를 짝수와 홀수로 분류하여 각각의 합과 평균을 구하기
import java.util.Scanner;

public class SumNumX{
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("정수를 몇개 입력하실건가요?");
		int x = input.nextInt();
		
		int evensum = 0;
		int e = 0;
		int oddsum = 0;
		int o = 0;
		System.out.println("정수를 입력해주세요.");
		for(int i = 0; i < x; i++) {
			int num = input.nextInt();
			if (num % 2 == 0) {
				evensum += num;
				e++;
			} else {
				oddsum += num;
				o++;
			}
		}		
		System.out.printf("입력한 정수들의 짝수 합은 %d이고, 평균은 %.3f입니다.\n", evensum, (double) evensum / e );
		System.out.printf("입력한 정수들의 홀수 합은 %d이고, 평균은 %.3f입니다.\n", oddsum, (double) oddsum / o);
	}
}