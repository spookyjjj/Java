import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("프로그램시작");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("왼쪽 수 입력?");
		int left = scan.nextInt();
		System.out.println("오른쪽 수 입력?");
		int right = scan.nextInt();
		
		if (right != 0) {
			System.out.println("나눈 몫: " + (left / right));
		} else {
			System.out.println("분모에 0을 넣을 수 없습니다");
		}
		
		System.out.println("프로그램종료");

	}

}
