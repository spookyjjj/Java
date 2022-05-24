//유클리드 호제법 : https://ko.wikipedia.org/wiki/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C_%ED%98%B8%EC%A0%9C%EB%B2%95

import java.util.Scanner;

public class Gcd {
	public static void main (String args[]) {
		int x, y, r; 
		System.out.println("두 개의 정수를 입력하시오(큰 수, 작은 수): ");
		Scanner scan = new Scanner(System.in);
		x = scan.nextInt();
		y = scan.nextInt();
		
		while (y != 0) {
			r = x % y;
			x = y;
			y = r;
		}
		System.out.printf("최대공약수는 %d입니다.", x);
	}
}