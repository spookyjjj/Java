//사용자의 나이와 이름을 입력받아서 45세 홍길동이랑 같으면 true출력하기

import java.util.Scanner;

public class T0520_1 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("나이를 입력하세요(숫자만): ");
		int age = input.nextInt();
		System.out.print("이름을 입력하세요: ");
		input.nextLine(); //엔터 없애기
		String name = input.nextLine();
		
		System.out.print("45세 홍길동? ");
		//System.out.println((age == 45) && (name == "홍길동")); //(X) 스트링인 name의 ==는 값의 동일이 아니라는 것!!
		System.out.println((age == 45) && (name.equals("홍길동")));
	}
}