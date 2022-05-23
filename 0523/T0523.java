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
		
		2. 사용자의 입력 n, m애 대해 n^m을 출력
		System.out.println("n^m의 n과 m을 순서대로 입력하세요: ");
		int n = input.nextInt();
		int m = input.nextInt();
		long squarenm = 1;
		for (int i = 1; i <=m; i++) {
			squarenm *= n;
		}
		System.out.println(squarenm);
		
		//3. 자판기! 돈 입력 -> 1번 콜라:1500, 2번 사이다:1300, 3번 계산 -> 총 몇 개의 캔을 구입하고, 거스름돈은 얼마인지
		//1번 2번이면 계속 입력창 3번이면 계산값이나오면서 종료되어야함
		int num = 0;
		int sum = 0;
		for (; num != 3;) {
			System.out.println("1은 콜라 2는 사이다 3은 계산입니다.");
			num = input.nextInt();
			if (num == 1) {
				sum += 1500;
			} else if (num == 2) {
				sum += 1300;
			} else if (num == 3 ){
				System.out.println("계산합니다");
			} else {
				System.out.println("1, 2, 3으로 입력하세요");
			}
		}
		System.out.printf("계산값은 %d입니다.", sum);
		
		//음수가 나올 때까지 input창 계속 반복
		System.out.print("가진돈을 입력하세요: ");
		int money = input.nextInt();
		for (; num != 3;) {
			
		}
		
		
		//4. 사용자가 입력한 정수의 약수를 나열하고 총 개수를 출력
		//나누었을때 나머지가 0인것들 골라내기 util 자기자신으로 나눌때까지
		System.out.println("약수를 알고싶은 정수를 입력하세요");
		int divisor = input.nextInt();
		int k = 0;
		for (int i = 1; i <= divisor; i++) {
			if (divisor % i == 0) {
				System.out.println(i);
				k++;
			}
		}
		System.out.printf("약수의 총 개수는 %d개 입니다", k);
		
		//5. 사용자가 입력한 5개의 정수 중 가장 큰 수를 출력
		//입력할때마다 둘 중 큰수만 골라내고 작은수는 버리고
		System.out.println("정수 5개를 입력해주세요.");
		
		int biggest = 0;
		for (int i = 1; i <= 5; i++) {
			int big = input.nextInt();
			if (big >= biggest) {
				biggest = big;
			}
		}
		System.out.printf("가장 큰 수는 %d입니다.", biggest);
		
		//6. 사용자가 입력한 영단어에서 모음이 몇개인지 출력 
		System.out.print("모음의 갯수를 확인하고픈 영단어를 입력하세요: ");
		String word = input.next();
		
		int length = word.length(); 
		int vowel = 0;
		for (int i = 0; i < length; i++) {
			if (word.charAt(i) == 'a' || word.charAt(i) == 'o' || word.charAt(i) == 'i' || word.charAt(i) == 'e' || word.charAt(i) == 'u') {
			vowel++;
			}
		}
		System.out.println(vowel);
	}
}