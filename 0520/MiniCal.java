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
			result = "" + (x + y); //문자열 뒤로는 다 결합 -> 괄호로 연산 먼저 일어나게
		} else if(cal.equals("-")) {
			result = "" + (x - y);
		} else if(cal.equals("*")) {
			result = "" + (x * y);
		} else if(cal.equals("/")) {
			result = "" + (x / y);
		} else {
			result = "똑바로 입력해~!"; //이거 하려고 result를 int가 아니라 String으로 한거! 
		}
		System.out.println(result);
	}
}