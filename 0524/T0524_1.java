//1. 369게임 : 1 2 Fizz 4 Buzz Fizz 7 8 Buzz ..FizzBuzz(15).. ~35까지
//2. Fibonacci 수열 : 1 1 2 3 5 8 13 21 ... ~100이하까지
//3. 사용자가 입력한 정수가 소수임을 확인하여 출력하는 프로그램
//4. 사용자에게 비밀번호를 물어보고 동일할 경우 통과 최대 3번의 기회를 줌

import java.util.Scanner;

public class T0524_1 {
	public static void main (String args[]) {
		Scanner scan = new Scanner(System.in);
		
		//1. 369게임 : 1 2 Fizz 4 Buzz Fizz 7 8 Buzz ..FizzBuzz(15).. ~35까지
		//1에서 35까지 반복 -> 3의배수이면서 5의배수이면 FizzBuzz -> 3의배수이면 Fizz -> 5의배수이면 Buzz -> 암것도 아니면 걍 출력
		// for (int i = 1; i <= 35; i++) {
			// if(i % 3 == 0 && i % 5 == 0){
				// System.out.println("FizzBuzz");
			// } else if (i % 3 == 0) {
				// System.out.println("Fizz");
			// } else if (i % 5 == 0) {
				// System.out.println("Buzz");
			// } else {
				// System.out.println(i);
			// }
		// }
		// System.out.println("369종료");
		
		//2. Fibonacci 수열 : 1 1 2 3 5 8 13 21 ... ~100이하까지
		// int a = 1;
		// int b = 1;
		// int c;
		// System.out.println(a);
		// System.out.println(b);
		// while (b <= 100) {
			// c = a; //a값 변하기 전에 저장
			// a = b;
			// b = c + b;
			// if (b > 100) {
				// continue;
			// }
			// System.out.println(b);
		// }
		// System.out.println("수열종료");

		//3. 사용자가 입력한 정수가 소수임을 확인하여 출력하는 프로그램
		// System.out.print("소수임을 확인 하고 싶은 정수를 입력하세요: ");
		// int input = scan.nextInt();
		
		// int count = 0;
		// for (int i = 1; i <= input; i++) {
			// if (input % i == 0 ) {
				// count++;
			// }
		// }
		// System.out.println((count == 2) ? "소수입니다" : "소수가 아닙니다");
		
		
		//4. 사용자에게 비밀번호를 물어보고 동일할 경우 통과 최대 3번의 기회를 줌
		String pw = "q1w2e3";
		int pwcount = 0;
		while (pwcount < 3) {
			System.out.println("비밀번호를 입력하세요");
			String pwinput = scan.nextLine();
			if (pwinput.equals(pw)) {
				System.out.println("로그인합니다");
				break;
			} else {
				pwcount++;
				System.out.println("비밀번호가 틀립니다\n틀린 횟수가 3회 이상이면 로그인 할 수 없습니다\n현재틀린횟수: " + pwcount);
				if (pwcount == 3) {
					System.out.println("비밀번호 입력 횟수를 초과하셨습니다");
				}
			}
		}
	}
}