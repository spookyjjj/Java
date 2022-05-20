//1. 사용자가 입력한 정수가 0이상이며 7의 배수일 때만 true를 출력하세요.
//2. 사용자에게 3개의 정수를 입력받아 순서대로 입력된 수 일 경우에만 true를 출력하세요. 예) 123, 567
//3. 사용자가 입력한 4자리의 정수가 좌우 같을 때 true를 출력하세요. 예) 1221, 9009

import java.util.Scanner;

public class T0519_4 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("1. 정수 하나를 입력하세요: ");
		int a = input.nextInt();
		System.out.println("0이상이며 7의 배수인가? " + ((a >= 0)&&(a % 7 == 0)));
		
		System.out.println("");
		
		System.out.println("2. 한 글자 정수를 순서대로 3개 입력하세요.");
		int x = input.nextInt();
		int y = input.nextInt();
		int z = input.nextInt();
		System.out.println("연속된 수인가? " + ((x + 1 == y)&&(x + 2 == z)));
		//System.out.println(y == x + 1 && y == z - 1);라고 해도 됨! 우선순위가 산술연산자->관계연산자->논리연산자 순서
		
		System.out.println("");
		
		System.out.print("3. 4자리 정수를 입력하세요: ");
		int four = input.nextInt();
		// System.out.println("대칭인가? " + ((four % 11) == 0 )) -> (X) 이건 대칭수가 아닌 11의 배수도 참으로 출력하므로
		int digit1 = four / 1000;
		int digit2 = (four / 100) % 10; //(four % 1000) / 100;
		int digit3 = (four / 10) % 10; //(four % 100) / 10;
		int digit4 = four % 10;
		System.out.println("대칭인가? " + ((digit1 == digit4)&&(digit2 == digit3)));
	}
}