//사용자의 정수를 입력받아 짝수면 "짝수입니다"출력
import java.util.Scanner;

public class EvenOdd {
	public static void main(String args[]) {
		/*
		if ( 조건식(=논리값) ) {
			문장1
			문장2					->then절
		} else {
			문장3
			문장4					->else절
		}
		문장5
		
		참: 문장1문장2문장5
		거짓: 문장3문장4문장5
		*/
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("홀짝을 알고 싶은 정수를 하나 입력하시오: ");
		int num = input.nextInt();

		if ((num % 2) == 0) {
			System.out.println("짝수입니다");
		} else {
			System.out.println("홀수입니다");
		}
	}
}