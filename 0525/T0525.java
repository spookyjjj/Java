//주민번호를 입력하면 성별을 출력하는 프로그램
import java.util.Scanner;

public class T0525 {
	public static void main (String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("주민번호를 -를 포함하여 입력하세요: ");
		String id = scan.nextLine();
		
		char sex = id.charAt(7);
		
		if (id.length() == 14) {
			switch (sex) { //sex를 char로 잡아줬어서 ''씀.
				case '1': 
				case '3':
					System.out.println("남성");
					break;
				case '2':
				case '4':
					System.out.println("여성");
					break;
				default:
					System.out.println("유효한 주민번호가 아닙니다");
			}
		} else {
			System.out.println("-포함하여 14자리를 입력해주세요");
		}
		
	}
}