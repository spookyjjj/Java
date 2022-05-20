//정수 2개와 연산자(문자열+-*/)등을 입력받아 사칙연산을 수행하는 계산기 프로그램

import java.util.Scanner;

public class MiniCal {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("숫자, 연산자, 숫자 순으로 입력하세요");
		int x = input.nextInt();
		input.nextLine(); //엔터 없애기
		String cal = input.nextLine();
		int y = input.nextInt();
		
		String result; 
		if (cal.equals("+")) {
			result = "" + (x + y); //괄호 없으면 앞에서 부터 결합이 일어나니깐 그냥 x값 y값이 붙어버림
		} else if(cal.equals("-")) {
			result = "" + (x - y);
		} else if(cal.equals("*")) {
			result = "" + (x * y);
		} else if(cal.equals("/")) {
			result = "" + (x / y);
		} else {
			result = "똑바로 입력해~!";
		}
		System.out.println(result);
	}
}