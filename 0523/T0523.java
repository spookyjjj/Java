//1. 2의 제곱수 32개 나열하고 결과값을 확인해 보세요 예)2 4 8 16 32 ...
//2. 사용자의 입력 n, m애 대해 n^m을 출력
//3. 자판기. 1번 콜라:1500, 2번 사이다:1300, 3번 계산 -> 총 몇 개의 캔을 구입하고, 거스름돈은 얼마인지
//4. 사용자가 입력한 정수의 약수를 나열하고 총 개수를 출력
//5. 사용자가 입력한 5개의 정수 중 가장 큰 수를 출력
//6. 사용자가 입력한 영단어에서 모음이 몇개인지 출력 

import java.util.Scanner;

public class T0523 {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		
		//1. 2의 제곱수 32개 나열하고 결과값을 확인해 보세요 예)2 4 8 16 32 ...
		long square = 1;
		for (int i = 1; i <= 32; i++) {
			square *= 2;
			System.out.println(square);
		}
		
		//2. 사용자의 입력 n, m애 대해 n^m을 출력
		System.out.println("n^m의 n과 m을 순서대로 입력하세요: ");
		int n = input.nextInt();
		int m = input.nextInt();
		long squarenm = 1;
		for (int i = 1; i <= m; i++) {
			squarenm *= n;
		}
		System.out.println(squarenm);
		
		//3. 자판기! 돈 입력 -> 1번 콜라:1500, 2번 사이다:1300, 3번 계산 -> 총 몇 개의 캔을 구입하고, 거스름돈은 얼마인지 외상안됨
		//3번계산 할 때까지 input창 계속 반복
		System.out.print("가진 돈을 입력하세요: ");
		int money = input.nextInt();
		
		int pick = 0;
		int coke = 0;
		int cider = 0;
		for (; pick != 3;) {
			System.out.println("--누르시오--\n1:콜라(1500원)\n2:사이다(1300원)\n3:계산");
			pick = input.nextInt();
			if (pick == 1) {
				if (money >= 1500) {
				money -= 1500;
				coke++;
				} else {
				System.out.printf("잔액이 %d원 부족합니다\n", 1500 - money);
				}
			} else if (pick == 2) {
				if (money >= 1300) {
				money -= 1300;
				cider++;
				} else {
				System.out.printf("잔액이 %d원 부족합니다\n", 1300 - money);				
				}
			} else if (pick == 3) {
				System.out.println("계산합니다");
			} else {
				System.out.println("1 - 3 사이의 값을 입력하세요");
			}
			System.out.printf("콜라 %d개, 사이다 %d개 구매하여 거스름돈은 %d원 입니다\n", coke, cider, money);	
		}
		System.out.println("이용해주셔서 감사합니다");
		//외부에 boolean con = true로 두고 while (con) {}을 진행후에, pick이 3일 때, con=!con으로 만듦으로써 while을 탈출~!
	
		
		//4. 사용자가 입력한 정수의 약수를 나열하고 총 개수를 출력
		//나누었을때 나머지가 0인것들 골라내기 until 자기자신으로 나눌때까지
		System.out.println("약수를 알고싶은 정수를 입력하세요");
		int divisor = input.nextInt();
		int k = 0;
		for (int i = 1; i <= divisor; i++) {
			if (divisor % i == 0) {
				System.out.println(i);
				k++;
			}
		}
		System.out.printf("약수의 총 개수는 %d개 입니다\n", k);
		
		//5. 사용자가 입력한 5개의 정수 중 가장 큰 수를 출력
		//입력할때마다 둘 중 큰수만 골라내고 작은수는 버리고
		System.out.println("정수 5개를 입력해주세요.");
		
		int biggest = input.nextInt();
		for (int i = 1; i <= 4; i++) {
			int big = input.nextInt();
			if (big >= biggest) {
				biggest = big;
			}
		}
		System.out.printf("가장 큰 수는 %d입니다.\n", biggest);
		
		//6. 사용자가 입력한 영단어에서 모음이 몇개인지 출력 
		System.out.print("모음의 갯수를 확인하고픈 영단어를 입력하세요: ");
		String word = input.next();
		
		int length = word.length(); 
		int vowel = 0;
		for (int i = 0; i < length; i++) {
			if (word.charAt(i) == 'a' || word.charAt(i) == 'i' || word.charAt(i) == 'u' || word.charAt(i) == 'e' || word.charAt(i) == 'o') {
			vowel++;
			}
		}
		System.out.printf("모음의 갯수는 %d개 입니다\n", vowel);
	}
}