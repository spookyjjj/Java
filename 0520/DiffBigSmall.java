// 정수 2개를 입력받아 큰 수 에서 작은 수로 나눈 몫과 나머지를 출력

import java.util.Scanner;

public class DiffBigSmall {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("정수 하나를 입력하세요: ");
		int a = input.nextInt();
		System.out.print("또 다른 정수 하나를 입력하세요: ");
		int b = input.nextInt();

		/*
		if (a >= b) {
			System.out.printf("%d에서 %d를 나눈 몫은 %d이며, 나머지는 %d입니다.", a, b, a / b, a % b);
		} else {
			System.out.printf("%d에서 %d를 나눈 몫은 %d이며, 나머지는 %d입니다.", b, a, b / a, b % a);
		}
		-> 서식이 바뀌면 여러군데서 수정이 필요하게됨 */
		
		int c = a;
		if (a < b) {
			a = b;
			b = c;
		} 
		System.out.printf("%d에서 %d를 나눈 몫은 %d이며, 나머지는 %d입니다.", a, b, a / b, a % b);
		
		/*
		int div
		int mod	
		if (a != 0 && b != 0) {
			if (a >= b) {
				div = a / b;	//괄호 안에서 int div라고 했다면, 괄호 벗어나는 순간 div라는 이름이 뭔지 모름
				mod = a % b;
			} else {
				div = b / a;	//중괄호마다 int div라고 선언하는 것은 노상관
				mod = b % a;
			}
			System.out.println("몫은 " + div);
			System.out.println("나머지는 " + mod);
		} else {
			System.out.println("0을 입력하면 안되지롱");
		}
		*/
	}
}