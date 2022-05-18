// p101 2

import java.util.Scanner;

public class P101_2 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("큰 정수를 입력하시오: ");
		int bignum = input.nextInt();
		System.out.print("작은 정수를 입력하시오: ");
		int smallnum = input.nextInt();
		int q = bignum / smallnum;
		int m = bignum % smallnum;		
		
		System.out.println(bignum + "을 " + smallnum + "으로 나눈 몫은 " + q + "이고 나머지는 " + m + "입니다.");
	}
}