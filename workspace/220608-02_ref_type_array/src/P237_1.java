//1. P237
import java.util.Scanner;
public class P237_1 {
	//메뉴 출력 메소드
	public static void printMenu() { //static이 없으면 같은 class안이라도, main메소드에서 이 클래스 객체를 만들어줘야 쓸 수 있다
		System.out.println("현재의 예약 상태는 다음과 같습니다.");
		System.out.println("----------------");
		System.out.println("1 2 3 4 5 6 7 8 9 10");
		System.out.println("----------------");
	}
	
	//배열 출력 메소드
	public static void printCurrent(int[] a) { 
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s = s + a[i] + " ";
		}
		System.out.println(s);
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] sit = new int[10];
		sit[5] = 1; // 5, 6, 7번 인덱스는 이미 선택되어 있는 좌석
		sit[6] = 1;
		sit[7] = 1;

		while (true) {
			System.out.println("좌석을 예약하시겠습니까? (1 또는0)");
			int a = scan.nextInt();
			if (a == 0) {
				break;
			}
			else if (a == 1) {
				printMenu();
				printCurrent(sit);
				System.out.println("몇번째 좌석을 예약하시겠습니까?");
				int b = scan.nextInt();
				if (sit[b-1] == 1) {
					System.out.println("이미 예약된 좌석입니다");
				} else {
					sit[b-1] = 1;
					printMenu();
					printCurrent(sit);
				}
			} else {
				System.out.println("1 또는 0을 입력해 주세요");
			}
		}
		System.out.println("프로그램 종료");
	}

}
