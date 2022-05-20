//세개의 정수를 입력받아 가장 큰 수를 출력하세요
import java.util.Scanner;

public class Biggest {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("정수 세개를 입력하세요.");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		
		//순서 세우기가 아니라 젤 큰놈만 맞추면 됨
		int biggest;
		if (a >= b && a >= c) {
			biggest = a;
		} else { //일단 a는 아니니깐 b와c를 비교
			if (b >= c) {
				biggest = b;
			} else {
			biggest = c;
			}
		}
		System.out.printf("가장 큰 수는 %d입니다", biggest);
	}
}