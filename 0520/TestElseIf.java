//컵 사이즈 알려주기
//사용자의 정수를 입력받아서 200이상이면 large, 100이상 200미만이면 medium, 100미만이면 small

import java.util.Scanner;

public class TestElseIf {
	public static void main(String args[]) {
		/*
		if (조건식) {
			문장1
		} else if (다른 조건식) {
			문장2
		} else if (또 다른 조건식) {
			문장3
		} else {
			문장4
		}
		문장 하나는 꼭 실행됨~!
		*/
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("사이즈를 입력하세요.");
		int cup = input.nextInt();
		
		String size;
		if (cup >= 200) {
			size = "large";
		} else if (cup >= 100) {
			size = "medium";
		} else {
			size = "small";
		}
		System.out.println(size);
	}
}