import java.util.Scanner;

public class Manage {
	private Library a = new Library();
	//메뉴출력 메소드
	private int menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("------프로그램을 선택하시오--------");
		System.out.println("1.책 목록 보기  2.분야별 검색  3.도서 정보 수정  4.책 추가  5.프로그램 종료");
		return scan.nextInt();
	}
	
	//관리프로그램
	public void manageProgram() {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			int num = menu();
			if (num == 5) {
				System.out.println("프로그램을 종료합니다");
				break;
			} else if (num == 4) {
				a.expand(Book.makeBook());
			} else if (num == 1) {
				System.out.println("--------보유중인 책 목록--------");
				System.out.println("      책제목  / 저자  / 출판사  / 분야  / 가격");
				a.showInfo();
				System.out.println("--------정렬 바꾸기?--------");
				System.out.println("1.가격내림차순 정렬  2.가격오름차순 정렬\n빠져나가려면 아무키나 누르세요");
				int num2 = scan.nextInt();
				if (num2 == 1) {
					System.out.println("--------내림차순 정렬--------");
					a.printPriceUp();
				} else if (num2 == 2) {
					System.out.println("--------오름차순 정렬--------");
					a.printPriceDown();
				}
			} else if (num == 2) {
				System.out.println("분야를 입력해 주십시오");
				a.searchGenre(scan.nextLine());
			} else if (num == 3) {
				System.out.println("수정할 책의 번호는 무엇입니까?");
				a.showInfoWithNum();
				int bookNum = scan.nextInt();
				System.out.println("수정할 부분은 어디입니까?");
				System.out.println("책제목  / 저자  / 출판사  / 분야  / 가격");
				String section = scan.next();
				a.changeInfo(bookNum, section);
			}
		}
	}
}
