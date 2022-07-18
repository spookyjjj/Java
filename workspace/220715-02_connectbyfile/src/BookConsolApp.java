import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookConsolApp {
	private BookManagerT bmt; 
	
	public BookConsolApp(BookManagerT bmt) { //BookManagerT가 무조건 있어야함 -> 객체 의존성
		this.bmt = bmt;
	}
	
	public void menu() {
		System.out.println("1. 추가, 2. 목록, 3. 삭제, 4. 수정, 5. 검색(제목) 6. 검색(가격)");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		switch (num) {
		case 1 : add(); break;
		case 2 : list(); break;
		case 3 : delete(); break;
		case 4 : update(); break;
		case 5 : searchByTitle(); break;
		case 6 : searchByPrice(); break;
		default : break;
		}
	}
	
	private void list() {
		List<BookT> list;
		try {
			list = bmt.list();
			
			if (list.size() > 0) {
				for (BookT b : list) {
					System.out.println(b);
				}
			} else {
				System.out.println("책 데이터가 없습니다.");
			}
			
		} catch (SQLException e) {
			System.out.println("데이터를 읽어오는 과정이 실패했습니다. 다시 시도해주세요.");
		}
		
	}
	
	private void delete() {
		list();
		System.out.println("삭제할 번호?");
		Scanner scan = new Scanner(System.in);
		int bookId = scan.nextInt();
		int result;
		try {
			result = bmt.delete(bookId);
			if (result > 0) {
				System.out.println(result + "개의 책이 삭제되었습니다.");
			} else {
				System.out.println("없는 번호입니다");
			}
			
		} catch (SQLException e) {
			System.out.println("데이터를 삭제하는 과정이 실패했습니다. 다시 시도해주세요.");
		}
		
	}
	
	private void add() {
		System.out.println("제목, 가격을 입력해주세요");
		Scanner scan = new Scanner(System.in);
		String title = null;
		boolean go = false;
		do { //또는 이런식으로 옳은 값 받을 때 까지 반복문 돌릴 수도 있음~
			title = scan.nextLine();
			go = title.length() > 40;
			if (go) {
				System.out.println("제목길이초과. 40자를 넘으면 안됩니다");
			}
		} while (go);
//		if (title.length() > 40) { //이런식으로 db까지 가서 에러 안고 돌아오지 말고, 미리 컷 할 수 있음
//			
//			return; //★void에서도 return이 가능!!!!!!!!
//		}
		
		int price = scan.nextInt();
		
		int result;
		try {
			result = bmt.add(new BookT(title, price));
			System.out.println(result + "개의 책이 추가되었습니다.");
		} catch (SQLException e) {
//			if (e.getErrorCode() == 1062) {
//				System.out.println("중복된 제목. 제목을 다시 확인해주세요.");
//			} else if (e.getErrorCode() == 1406) {
//				System.out.println("제목길이초과. 제목을 다시 확인해주세요.");
//			} else {
//				System.out.println("데이터를 추가하는 과정이 실패했습니다. 다시 시도해주세요.");
//			}
			//굳이 db갔다 올 필요 없이!! 에러 발생할 상황을 미리 알고 있으니깐 title 받자마자 체크해도 됨
			System.out.println("데이터를 추가하는 과정이 실패했습니다. 다시 시도해주세요.");
		}
		
	}
	
	private void update() {
		list();
		System.out.println("수정할 번호, 새 제목, 새 가격 순입력");
		Scanner scan = new Scanner(System.in);
		
		int bookId = scan.nextInt();
		String title = scan.next();
		int price = scan.nextInt();
		
		try {
			int result = bmt.update(new BookT(bookId, title, price));
			System.out.println(result + "행 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void searchByTitle() {
		System.out.println("검색할 책 제목을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		String title = scan.nextLine();
		
		BookT book;
		try {
			book = bmt.selectByTitle(title);
			if (book != null) {
				System.out.println(book);
			} else {
				System.out.println("찾는 책 데이터가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void searchByPrice() {
		System.out.println("검색할 책 제목을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int price = scan.nextInt();
		
		List<BookT> list;
		try {
			list = bmt.selectByPrice(price);
			if (list.size() > 0) {
				for (BookT b : list) {
					System.out.println(b);
				}
			} else {
				System.out.println("찾는 책 데이터가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) {
		BookConsolApp app = new BookConsolApp(new BookManagerT());
		app.menu();
	}
	
}
